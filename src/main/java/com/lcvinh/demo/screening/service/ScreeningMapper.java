package com.lcvinh.demo.screening.service;

import com.lcvinh.demo.screening.dto.request.ScreeningRequest;
import com.lcvinh.demo.screening.dto.response.ScreeningResponse;
import com.lcvinh.demo.screening.entity.Screening;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface ScreeningMapper {

    Screening toEntity(ScreeningRequest request);
    ScreeningResponse toDto(Screening screening);
    List<ScreeningResponse> toDtoList(List<Screening> screeningList);

}
