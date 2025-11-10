package com.example.aidflow.dto.projectDto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class ProjectOutDto {
    private Long id;
    private String title;
    private String description;
    private double targetAmount;
    private double collectedAmount;
    private String location;
    private String status;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime createdAt;
    private Long ngo;
}
