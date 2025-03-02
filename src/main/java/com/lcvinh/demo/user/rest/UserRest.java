package com.lcvinh.demo.user.rest;

import com.lcvinh.demo.base.Response.ResponseModel;
import com.lcvinh.demo.user.dto.Request.UserLoginRequest;
import com.lcvinh.demo.user.dto.Request.UserRegisterRequest;
import com.lcvinh.demo.user.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("auth")
@Tag(name = "User", description = "Operations related to user")
@SecurityScheme(
        type = SecuritySchemeType.HTTP,
        scheme = "Bearer",
        bearerFormat = "JWT"
)
public class UserRest {

    @Inject
    private IUserService userService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Operation(summary = "Login", description = "Retrieve a list of all users")
    public Response login(@Valid UserLoginRequest request) {
        String token = userService.login(request);
        return Response.ok(ResponseModel.<String>builder()
                        .message("Login successful.")
                        .data(token)
                        .build())
                .build();
    }

    @POST
    @Path("/registration")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(@Valid UserRegisterRequest request) {
        userService.register(request);
        return Response.status(Response.Status.CREATED)
                .entity(ResponseModel.builder()
                        .message("User registered successfully.")
                        .build())
                .build();
    }
}
