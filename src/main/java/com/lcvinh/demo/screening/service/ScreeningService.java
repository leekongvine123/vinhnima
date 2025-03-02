package com.lcvinh.demo.screening.service;

import com.lcvinh.demo.screening.dto.request.ScreeningRequest;
import com.lcvinh.demo.screening.dto.response.ScreeningResponse;

import java.util.List;

public interface ScreeningService {
    List<ScreeningResponse> findAll();

    ScreeningResponse create(ScreeningRequest request);
}
