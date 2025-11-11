package com.example.aidflow.controller;

import com.example.aidflow.dto.projectDto.ProjectInDto;
import com.example.aidflow.dto.projectDto.ProjectOutDto;
import com.example.aidflow.mapper.ProjectMapper;
import com.example.aidflow.model.Project;
import com.example.aidflow.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
@RestController
@Validated
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {
    @Autowired
    private final ProjectService service;
    @Autowired
    private final ProjectMapper mapper;

    @PostMapping("/create-project")
    public ResponseEntity<ProjectOutDto> createProject(@RequestBody ProjectInDto dto){
        ProjectOutDto result = service.createProject(dto);
        return ResponseEntity.ok(result);
    }
    @GetMapping()
    public ResponseEntity<List<ProjectOutDto>> findAllProject(){
        List<ProjectOutDto> result = service.findAllProjects();
        return ResponseEntity.ok(result);
    }
    @GetMapping("{id}")
    public ResponseEntity<ProjectOutDto> findProjectById(@PathVariable Long id){
        Project project = service.findProjectById(id);
        ProjectOutDto result = mapper.toDto(project);
        return ResponseEntity.ok(result);
    }
}
