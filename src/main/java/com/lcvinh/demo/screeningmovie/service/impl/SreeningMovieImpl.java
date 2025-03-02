package com.lcvinh.demo.screeningmovie.service.impl;

import com.lcvinh.demo.screeningmovie.dao.ScreeningMovieDao;
import com.lcvinh.demo.screeningmovie.dto.request.ScreeningMovieRequest;
import com.lcvinh.demo.screeningmovie.dto.response.ScreeningMovieResponse;
import com.lcvinh.demo.screeningmovie.service.ScreeningMovieMapper;
import com.lcvinh.demo.screeningmovie.service.ScreeningMovieService;
import jakarta.inject.Inject;

public class SreeningMovieImpl implements ScreeningMovieService {

    @Inject
    ScreeningMovieDao screeningDao;

    @Inject
    ScreeningMovieMapper mapper;

    @Override
    public ScreeningMovieResponse create(ScreeningMovieRequest request){
        return mapper.toDto(screeningDao.save(mapper.toEntity(request)));
    }



}
