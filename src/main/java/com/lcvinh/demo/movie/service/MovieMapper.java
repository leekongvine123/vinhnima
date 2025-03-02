package com.lcvinh.demo.movie.service;


import com.lcvinh.demo.movie.entity.Movie;
import com.lcvinh.demo.movie.dto.Request.MovieCreationRequest;
import com.lcvinh.demo.movie.dto.Response.MovieResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface MovieMapper {
   MovieResponse toDto(Movie movie);
   List<MovieResponse> toDtoList(List<Movie> movies);
    Movie toEntity(MovieCreationRequest request);
}
