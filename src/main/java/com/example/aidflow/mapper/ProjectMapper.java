package com.example.aidflow.mapper;

import com.example.aidflow.constant.ProjectStatus;
import com.example.aidflow.dto.projectDto.ProjectInDto;
import com.example.aidflow.dto.projectDto.ProjectOutDto;
import com.example.aidflow.model.Ngo;
import com.example.aidflow.model.Project;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ProjectMapper {
    public Project toEntity(ProjectInDto dto, Ngo ngo){
        return Project.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .targetAmount(dto.getTargetAmount())
                .collectedAmount(dto.getCollectedAmount())
                .location(dto.getLocation())
                .status(ProjectStatus.valueOf(dto.getStatus()))
                .createdAt(LocalDateTime.now())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .ngo(ngo)
                .build();
    }
    public ProjectOutDto toDto(Project project){
        ProjectOutDto dto = new ProjectOutDto();
        dto.setId(project.getId());
        dto.setTitle(project.getTitle());
        dto.setDescription(project.getDescription());
        dto.setTargetAmount(project.getTargetAmount());
        dto.setCollectedAmount(project.getCollectedAmount());
        dto.setLocation(project.getLocation());
        dto.setStatus(project.getStatus().name());
        dto.setStartDate(project.getStartDate());
        dto.setEndDate(project.getEndDate());
        dto.setCreatedAt(project.getCreatedAt());
        dto.setNgo(project.getNgo().getId());
        return dto;
    }
}
