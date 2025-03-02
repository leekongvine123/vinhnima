package com.lcvinh.demo.movie.service.impl;
import com.lcvinh.demo.movie.dto.Request.MovieCreationRequest;
import com.lcvinh.demo.movie.dto.Response.MovieResponse;
import com.lcvinh.demo.movie.entity.Movie;
import com.lcvinh.demo.movie.service.MovieMapper;
import com.lcvinh.demo.movie.dao.MovieDao;
import com.lcvinh.demo.movie.service.IMovieService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class MovieService implements IMovieService {

    @Inject
    private MovieDao repository;

    @Inject
    private MovieMapper mapper;

    @Override
    public List<MovieResponse> findAll() {
        List<Movie> movies = repository.findAll();
        return mapper.toDtoList(movies);
    }

    @Override
    public MovieResponse create(MovieCreationRequest movie) {
        Movie movieById = repository.save(mapper.toEntity(movie));
        return mapper.toDto(movieById);
    }

    @Override
    public MovieResponse update(MovieCreationRequest movie) {
        return null;
    }

    @Override
    public void deleteMovie(String movieId) {

    }

    @Override
    public MovieResponse getResponseById(String movieId) {
        return null;
    }

    @Override
    public Movie getEntityById(String movieId) {
        return null;
    }
}
