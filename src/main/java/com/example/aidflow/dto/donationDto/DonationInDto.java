package com.example.aidflow.dto.donationDto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DonationInDto {
    private double amount;
    private String status;
    private Long user;
    private Long project;
}
