package com.lcvinh.demo.screening.rest;

import com.lcvinh.demo.base.Response.ResponseModel;
import com.lcvinh.demo.screening.dto.request.ScreeningRequest;
import com.lcvinh.demo.screening.dto.response.ScreeningResponse;
import com.lcvinh.demo.screening.service.ScreeningService;
import com.lcvinh.demo.user.dto.Request.UserLoginRequest;
import com.lcvinh.demo.user.service.IUserService;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("screenings")
public class ScreeningRest {

    @Inject
    private ScreeningService screeningService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid ScreeningRequest request) {
        return Response.ok(ResponseModel.<ScreeningResponse>builder()
                        .data(screeningService.create(request))
                        .build())
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(ResponseModel.<List<ScreeningResponse>>builder()
                        .data(screeningService.findAll())
                        .build())
                .build();
    }

}