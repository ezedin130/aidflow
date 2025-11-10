package com.example.aidflow.mapper;

import com.example.aidflow.constant.UserStatus;
import com.example.aidflow.dto.ngoDto.NgoInDto;
import com.example.aidflow.dto.ngoDto.NgoOutDto;
import com.example.aidflow.model.Ngo;
import com.example.aidflow.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NgoMapper {
    public Ngo toEntity(NgoInDto dto, User user){
        return Ngo.builder()
                .name(dto.getName())
                .mission(dto.getMission())
                .address(dto.getAddress())
                .phone(dto.getPhone())
                .createdAt(LocalDateTime.now())
                .status(UserStatus.valueOf(dto.getStatus()))
                .user(user)
                .build();
    }
    public NgoOutDto toDto(Ngo ngo){
        NgoOutDto dto = new NgoOutDto();
        dto.setId(ngo.getId());
        dto.setName(ngo.getName());
        dto.setMission(ngo.getMission());
        dto.setAddress(ngo.getAddress());
        dto.setPhone(ngo.getPhone());
        dto.setStatus(ngo.getStatus().name());
        dto.setCreatedAt(ngo.getCreatedAt());
        dto.setUser(ngo.getUser().getId());
        return dto;
    }
}
