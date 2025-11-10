package com.example.aidflow.service;

import com.example.aidflow.dto.resourceDistributionDto.ResourceDistInDto;
import com.example.aidflow.dto.resourceDistributionDto.ResourceDistOutDto;
import com.example.aidflow.mapper.ResourceDistMapper;
import com.example.aidflow.model.Ngo;
import com.example.aidflow.model.Project;
import com.example.aidflow.model.ResourceDistribution;
import com.example.aidflow.repository.NgoRepository;
import com.example.aidflow.repository.ProjectRepository;
import com.example.aidflow.repository.ResourceDistributionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResourceDistService {
    @Autowired
    private final ResourceDistributionRepository distRepo;
    @Autowired
    private final ResourceDistMapper mapper;
    @Autowired
    private final ProjectRepository  projectRepo;
    @Autowired
    private final NgoRepository ngoRepo;
    public ResourceDistOutDto createDist(ResourceDistInDto dto){
        Project project = projectRepo.findById(dto.getProject())
                .orElseThrow(()-> new RuntimeException("Project not found"));
        Ngo ngo = ngoRepo.findById(dto.getNgo())
                .orElseThrow(()-> new RuntimeException("Ngo not found"));
        ResourceDistribution dist = mapper.toEntity(dto,project,ngo);
        ResourceDistribution savedDist =  distRepo.save(dist);
        return mapper.toDto(savedDist);
    }
    public List<ResourceDistOutDto> findAllDist(){
        return distRepo.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    public ResourceDistribution findDistById(Long id){
        return distRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Dist not found"));
    }
}
