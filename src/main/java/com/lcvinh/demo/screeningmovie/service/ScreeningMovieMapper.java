package com.lcvinh.demo.screeningmovie.service;

import com.lcvinh.demo.screeningmovie.dto.request.ScreeningMovieRequest;
import com.lcvinh.demo.screeningmovie.dto.response.ScreeningMovieResponse;
import com.lcvinh.demo.screeningmovie.entity.ScreeningMovie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ScreeningMovieMapper {
    ScreeningMovie toEntity(ScreeningMovieRequest request);

    ScreeningMovieResponse toDto(ScreeningMovie entity);

    List<ScreeningMovieResponse> toDtoList(List<ScreeningMovie> screeningMovieList);
}
