package com.lcvinh.demo.movie.dao;

import com.lcvinh.demo.base.BaseDao;
import com.lcvinh.demo.movie.entity.Movie;
import jakarta.ejb.Stateless;

@Stateless
public class MovieDao extends BaseDao<Movie> {

    public MovieDao() {
        super(Movie.class);
    }
}

