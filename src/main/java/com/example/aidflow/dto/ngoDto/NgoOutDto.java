package com.example.aidflow.dto.ngoDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class NgoOutDto {
    private Long id;
    private String name;
    private String mission;
    private String address;
    private String phone;
    private LocalDateTime createdAt;
    private Long user;
}
