package com.lcvinh.demo.movie.service;



import com.lcvinh.demo.movie.dto.Request.MovieCreationRequest;
import com.lcvinh.demo.movie.dto.Response.MovieResponse;
import com.lcvinh.demo.movie.entity.Movie;

import java.util.List;

public interface IMovieService{
    List<MovieResponse> findAll();
    MovieResponse create(MovieCreationRequest movie);
    MovieResponse update(MovieCreationRequest movie);
    void deleteMovie(String movieId);
    MovieResponse getResponseById(String movieId);
    Movie getEntityById(String movieId);

}
