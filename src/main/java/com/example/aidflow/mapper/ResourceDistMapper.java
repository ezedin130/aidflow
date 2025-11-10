package com.example.aidflow.mapper;

import com.example.aidflow.dto.resourceDistributionDto.ResourceDistInDto;
import com.example.aidflow.dto.resourceDistributionDto.ResourceDistOutDto;
import com.example.aidflow.model.Ngo;
import com.example.aidflow.model.Project;
import com.example.aidflow.model.ResourceDistribution;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ResourceDistMapper {
    public ResourceDistribution toEntity(ResourceDistInDto dto, Project project, Ngo ngo){
        return ResourceDistribution.builder()
                .resourceName(dto.getResourceName())
                .quantity(dto.getQuantity())
                .distributedAt(dto.getDistributedAt())
                .createdAt(LocalDateTime.now())
                .project(project)
                .ngo(ngo)
                .build();
    }
    public ResourceDistOutDto toDto(ResourceDistribution dist){
        ResourceDistOutDto dto = new ResourceDistOutDto();
        dto.setId(dist.getId());
        dto.setResourceName(dist.getResourceName());
        dto.setQuantity(dist.getQuantity());
        dto.setDistributedAt(dist.getDistributedAt());
        dto.setCreatedAt(dist.getCreatedAt());
        dto.setProject(dist.getProject().getId());
        dto.setNgo(dist.getNgo().getId());
        return dto;
    }
}
