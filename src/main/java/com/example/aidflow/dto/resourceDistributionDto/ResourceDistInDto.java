package com.example.aidflow.dto.resourceDistributionDto;

import lombok.Data;


@Data
public class ResourceDistInDto {
    private String resourceName;
    private double quantity;
    private String unitType;
    private Long project;
    private Long ngo;
}
