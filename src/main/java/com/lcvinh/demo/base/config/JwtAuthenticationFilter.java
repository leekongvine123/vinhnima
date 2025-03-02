package com.lcvinh.demo.base.config;

import com.lcvinh.demo.base.Response.ResponseModel;
import com.lcvinh.demo.user.dto.Role;
import com.lcvinh.demo.utils.JwtService;
import io.jsonwebtoken.Claims;
import jakarta.ws.rs.NotAuthorizedException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.util.Set;

@Provider
public class JwtAuthenticationFilter implements ContainerRequestFilter {
    private static final Set<String> PUBLIC_ENDPOINTS = Set.of(
            "/openapi.json",
            "/auth"
    );

    private static final Set<String> ADMIN_ENDPOINTS = Set.of(
            "/admin",
            "/movies"
    );

    private static final Set<String> STAFF_ENDPOINTS = Set.of(
            "/staff-dashboard",
            "/orders"
    );

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String path = requestContext.getUriInfo().getPath();
        String method = requestContext.getMethod();

        if (isPublicEndpoint(path, method)) return;

        try {
            String authorizationHeader = requestContext.getHeaderString("Authorization");
            String token = extractToken(authorizationHeader);
            Claims claims = JwtService.decodeToken(token);
            Role role = Role.valueOf(claims.get("role", String.class));

            if (isAccessDenied(path, method, role)) {
                requestContext.abortWith(Response.status(Response.Status.FORBIDDEN).build());
            }
        } catch (NotAuthorizedException e) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED)
                    .entity(ResponseModel.builder()
                            .message("Unauthorized access: " + e.getMessage())
                            .build()).build());
        }
    }

    private String extractToken(String authorizationHeader) {
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            throw new NotAuthorizedException("Invalid Authorization header.");
        }
        return authorizationHeader.substring("Bearer".length()).trim();
    }

    private boolean isPublicEndpoint(String path, String method) {
        for (String endpoint : PUBLIC_ENDPOINTS) {
            if (endpoint.contains("-")) {
                String[] splitString = endpoint.split("-");
                if (path.startsWith(splitString[0]) && method.equalsIgnoreCase(splitString[1])) {
                    return true;
                }
            } else if (path.startsWith(endpoint)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAdminEndpoint(String path) {
        return ADMIN_ENDPOINTS.stream().anyMatch(path::startsWith);
    }

    private boolean isStaffEndpoint(String path) {
        return STAFF_ENDPOINTS.stream().anyMatch(path::startsWith);
    }

    private boolean isAccessDenied(String path, String method, Role role) {
        if (role == Role.ADMIN) return false;
        if (role == Role.STAFF && isAdminEndpoint(path)) return true;
        if (role == Role.USER && (isAdminEndpoint(path) || isStaffEndpoint(path))) return true;
        return isForbiddenForRole(path, method, role);
    }

    private boolean isForbiddenForRole(String path, String method, Role role) {
        return path.startsWith("/movies") && method.equalsIgnoreCase("POST") &&
                (role == Role.STAFF || role == Role.USER);
    }
}
