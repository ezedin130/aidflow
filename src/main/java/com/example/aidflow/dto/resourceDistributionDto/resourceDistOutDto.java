package com.example.aidflow.dto.resourceDistributionDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class resourceDistOutDto {
    private Long id;
    private String resourceName;
    private int quantity;
    private LocalDateTime distributedAt;
    private LocalDateTime createdAt;
    private Long project;
    private Long ngo;
}
