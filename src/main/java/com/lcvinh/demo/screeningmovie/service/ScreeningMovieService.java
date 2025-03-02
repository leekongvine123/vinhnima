package com.lcvinh.demo.screeningmovie.service;

import com.lcvinh.demo.screeningmovie.dto.request.ScreeningMovieRequest;
import com.lcvinh.demo.screeningmovie.dto.response.ScreeningMovieResponse;

public interface ScreeningMovieService {
    ScreeningMovieResponse create(ScreeningMovieRequest request);
}
