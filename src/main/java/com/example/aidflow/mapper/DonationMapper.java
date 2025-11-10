package com.example.aidflow.mapper;

import com.example.aidflow.constant.PaymentStatus;
import com.example.aidflow.dto.donationDto.DonationInDto;
import com.example.aidflow.dto.donationDto.DonationOutDto;
import com.example.aidflow.model.Donation;
import com.example.aidflow.model.Project;
import com.example.aidflow.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DonationMapper {
    public Donation toEntity(DonationInDto dto, User user, Project project){
        return Donation.builder()
                .amount(dto.getAmount())
                .createdAt(LocalDateTime.now())
                .status(PaymentStatus.valueOf(dto.getStatus()))
                .user(user)
                .project(project)
                .build();
    }
    public DonationOutDto toDto(Donation donation){
        DonationOutDto dto = new DonationOutDto();
        dto.setId(donation.getId());
        dto.setAmount(donation.getAmount());
        dto.setStatus(donation.getStatus().name());
        dto.setCreatedAt(donation.getCreatedAt());
        dto.setUser(donation.getUser().getId());
        dto.setProject(donation.getProject().getId());
        return dto;
    }
}
