package com.example.aidflow.dto.userDto;

import lombok.Data;

@Data
public class UserInDto {
    private String name;
    private String email;
    private String password;
    private String role;
    private String status;
}
