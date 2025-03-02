package com.lcvinh.demo.screening.service.iml;

import com.lcvinh.demo.screening.dao.ScreeningDao;
import com.lcvinh.demo.screening.dto.request.ScreeningRequest;
import com.lcvinh.demo.screening.dto.response.ScreeningResponse;
import com.lcvinh.demo.screening.service.ScreeningMapper;
import com.lcvinh.demo.screening.service.ScreeningService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;

@Stateless
public class ScreeningServiceIml implements ScreeningService {

    @Inject
    ScreeningDao screeningDao;

    @Inject
    ScreeningMapper mapper;

    @Override
    public List<ScreeningResponse> findAll(){
        return  mapper.toDtoList(screeningDao.findAll());
    }

    @Override
    public ScreeningResponse create(ScreeningRequest request){
        return mapper.toDto(screeningDao.save(mapper.toEntity(request)));
    }

}
