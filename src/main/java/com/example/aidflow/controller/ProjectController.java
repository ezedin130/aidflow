package com.example.aidflow.controller;

import com.example.aidflow.constant.ProjectStatus;
import com.example.aidflow.dto.projectDto.ProjectInDto;
import com.example.aidflow.dto.projectDto.ProjectOutDto;
import com.example.aidflow.mapper.ProjectMapper;
import com.example.aidflow.model.Project;
import com.example.aidflow.repository.ProjectRepository;
import com.example.aidflow.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    @Autowired
    private final ProjectRepository projectRepo;

    @PostMapping("/create-project")
    public ResponseEntity<ProjectOutDto> createProject(@RequestBody ProjectInDto dto){
        ProjectOutDto result = service.createProject(dto);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}/activate")
    //@PreAuthorize(("hasRole('ADMIN')"))
    public ResponseEntity<ProjectOutDto> activateProject(@PathVariable Long id){
        Project project = projectRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        project.setStatus(ProjectStatus.ACTIVE);
        project.setStartDate(LocalDate.now());

        Project updated = projectRepo.save(project);
        ProjectOutDto result = mapper.toDto(updated);
        return ResponseEntity.ok(result);
    }
    @PutMapping("/{id}/complete")
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ProjectOutDto> completeProject(@PathVariable Long id) {
        ProjectOutDto updatedProject = service.completeProject(id);
        return ResponseEntity.ok(updatedProject);
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
