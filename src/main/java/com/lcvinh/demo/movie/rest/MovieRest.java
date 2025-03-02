package com.lcvinh.demo.movie.rest;

import com.lcvinh.demo.base.Response.ResponseModel;
import com.lcvinh.demo.movie.dto.Request.MovieCreationRequest;
import com.lcvinh.demo.movie.dto.Response.MovieResponse;
import com.lcvinh.demo.movie.service.IMovieService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.info.Info;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(
                title = "User API",
                version = "1.0",
                description = "API for managing users"
        )
)
@Path("/movies")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MovieRest {

    @Inject
    private IMovieService movieService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get a user by ID", description = "Returns user details")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMovie(@Valid MovieCreationRequest request) {
        MovieResponse movieResponse = movieService.create(request);
        return Response.status(Response.Status.CREATED)
                .entity(ResponseModel.<MovieResponse>builder()
                        .message("Movie created successfully.")
                        .data(movieResponse)
                        .build())
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<MovieResponse> movies = movieService.findAll();
        return Response.ok(ResponseModel.<List<MovieResponse>>builder()
                        .message("Movies retrieved successfully.")
                        .data(movies)
                        .build())
                .build();
    }
}
