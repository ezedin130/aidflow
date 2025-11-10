package com.example.aidflow.dto.donationDto;

import com.example.aidflow.model.Project;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DonationOutDto {
    private Long id;
    private double amount;
    private String status;
    private LocalDateTime createdAt;
    private Long user;
    private Long project;
}
