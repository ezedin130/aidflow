package com.example.aidflow.dto.resourceDistributionDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResourceDistInDto {
    private String resourceName;
    private int quantity;
    private LocalDateTime distributedAt;
    private Long project;
    private Long ngo;
}
