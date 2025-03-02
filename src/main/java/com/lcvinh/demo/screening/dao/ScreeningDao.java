package com.lcvinh.demo.screening.dao;

import com.lcvinh.demo.base.BaseDao;
import com.lcvinh.demo.movie.entity.Movie;
import com.lcvinh.demo.screening.entity.Screening;
import jakarta.ejb.Stateless;

@Stateless
public class ScreeningDao extends BaseDao<Screening> {
    public ScreeningDao() {
        super(Screening.class);
    }
}

