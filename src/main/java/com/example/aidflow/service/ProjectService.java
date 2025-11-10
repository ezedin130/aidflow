package com.example.aidflow.service;

import com.example.aidflow.dto.projectDto.ProjectInDto;
import com.example.aidflow.dto.projectDto.ProjectOutDto;
import com.example.aidflow.mapper.ProjectMapper;
import com.example.aidflow.model.Ngo;
import com.example.aidflow.model.Project;
import com.example.aidflow.repository.NgoRepository;
import com.example.aidflow.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {
    @Autowired
    private final ProjectRepository projectRepo;
    @Autowired
    private final ProjectMapper mapper;
    @Autowired
    private final NgoRepository ngoRepo;

    public ProjectOutDto createProject(ProjectInDto dto){
        Ngo ngo = ngoRepo.findById(dto.getNgo())
                .orElseThrow(()-> new RuntimeException("Ngo not found"));
        Project project = mapper.toEntity(dto,ngo);
        Project savedProject = projectRepo.save(project);
        return mapper.toDto(savedProject);
    }
    public List<ProjectOutDto> findAllProjects(){
        return projectRepo.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    public Project findProjectById(Long id){
        return projectRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Project not found"));
    }
}
