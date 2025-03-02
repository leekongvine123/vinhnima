package com.lcvinh.demo.user.service;


import com.lcvinh.demo.user.dto.Request.UserLoginRequest;
import com.lcvinh.demo.user.dto.Request.UserRegisterRequest;

public interface IUserService {

    void register(UserRegisterRequest request);

    String login(UserLoginRequest request);

}
