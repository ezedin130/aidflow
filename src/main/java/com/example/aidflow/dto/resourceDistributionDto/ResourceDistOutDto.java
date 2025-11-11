package com.example.aidflow.dto.resourceDistributionDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ResourceDistOutDto {
    private Long id;
    private String resourceName;
    private double quantity;
    private String unitType;
    private LocalDateTime createdAt;
    private Long project;
    private Long ngo;
}
