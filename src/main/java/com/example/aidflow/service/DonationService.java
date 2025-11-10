package com.example.aidflow.service;

import com.example.aidflow.dto.donationDto.DonationInDto;
import com.example.aidflow.dto.donationDto.DonationOutDto;
import com.example.aidflow.mapper.DonationMapper;
import com.example.aidflow.model.Donation;
import com.example.aidflow.model.Project;
import com.example.aidflow.model.User;
import com.example.aidflow.repository.DonationRepository;
import com.example.aidflow.repository.ProjectRepository;
import com.example.aidflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DonationService {
    @Autowired
    private final DonationRepository donationRepo;
    @Autowired
    private final DonationMapper mapper;
    @Autowired
    private final ProjectRepository  projectRepo;
    @Autowired
    private final UserRepository userRepo;

    public DonationOutDto createDonation(DonationInDto dto){
        Project project = projectRepo.findById(dto.getProject())
                .orElseThrow(()-> new RuntimeException("Project not found"));
        User user = userRepo.findById(dto.getUser())
                .orElseThrow(()-> new RuntimeException("User not found"));
        Donation donation = mapper.toEntity(dto,user,project);
        Donation savedDonation = donationRepo.save(donation);
        return mapper.toDto(savedDonation);
    }
    public List<DonationOutDto> getAllDonations(){
        return donationRepo.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    public Donation findDonationById(Long id){
        return donationRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Donation not found"));
    }
}
