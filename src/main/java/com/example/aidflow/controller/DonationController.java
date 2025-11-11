package com.example.aidflow.controller;

import com.example.aidflow.dto.donationDto.DonationInDto;
import com.example.aidflow.dto.donationDto.DonationOutDto;
import com.example.aidflow.mapper.DonationMapper;
import com.example.aidflow.model.Donation;
import com.example.aidflow.service.DonationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/donation")
public class DonationController {
    @Autowired
    private final DonationService service;
    @Autowired
    private final DonationMapper mapper;

    @PostMapping("/create-donation")
    public ResponseEntity<DonationOutDto> createDonation(@RequestBody DonationInDto dto){
        DonationOutDto result = service.createDonation(dto);
        return ResponseEntity.ok(result);
    }
    @GetMapping()
    public ResponseEntity<List<DonationOutDto>> getAllDonations(){
        List<DonationOutDto> result = service.getAllDonations();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<DonationOutDto> getDonationById(@PathVariable Long id){
        Donation donation = service.findDonationById(id);
        DonationOutDto dto = mapper.toDto(donation);
        return ResponseEntity.ok(dto);
    }
}
