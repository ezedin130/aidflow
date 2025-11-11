package com.example.aidflow.dto.projectDto;

import lombok.Data;

@Data
public class ProjectInDto {
    private String title;
    private String description;
    private double targetAmount;
    private String location;
    private Long ngo;
}
