package com.example.aidflow.dto.userDto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class UserOutDto {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String role;
    private String status;
    private LocalDateTime createdAt;
}
