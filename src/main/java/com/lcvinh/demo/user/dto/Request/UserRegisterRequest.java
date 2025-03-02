package com.lcvinh.demo.user.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegisterRequest {

    private String name;

    private String email;

    private String password;

    private String role; // Admin or Customer

}
