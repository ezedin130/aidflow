package com.example.aidflow.dto.projectDto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProjectInDto {
    private String title;
    private String description;
    private double targetAmount;
    private double collectedAmount;
    private String location;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long ngo;
}
