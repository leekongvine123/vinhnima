package com.lcvinh.demo.user.service;

import com.lcvinh.demo.user.dto.Request.UserRegisterRequest;
import com.lcvinh.demo.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    User toEntity(UserRegisterRequest userRegisterRequest);
}
