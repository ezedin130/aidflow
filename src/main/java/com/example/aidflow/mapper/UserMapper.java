package com.example.aidflow.mapper;

import com.example.aidflow.constant.RoleType;
import com.example.aidflow.constant.UserStatus;
import com.example.aidflow.dto.userDto.UserInDto;
import com.example.aidflow.dto.userDto.UserOutDto;
import com.example.aidflow.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserMapper {
    public User toEntity(UserInDto dto){
        return User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .createdAt(LocalDateTime.now())
                .role(RoleType.valueOf(dto.getRole()))
                .status(UserStatus.valueOf(dto.getStatus()))
                .build();
    }
    public UserOutDto toDto(User user){
        UserOutDto dto = new UserOutDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setRole(user.getRole().name());
        dto.setStatus(user.getStatus().name());
        return dto;
    }
}
