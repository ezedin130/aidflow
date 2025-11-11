package com.example.aidflow.controller;

import com.example.aidflow.dto.resourceDistributionDto.ResourceDistInDto;
import com.example.aidflow.dto.resourceDistributionDto.ResourceDistOutDto;
import com.example.aidflow.mapper.ResourceDistMapper;
import com.example.aidflow.model.ResourceDistribution;
import com.example.aidflow.service.ResourceDistService;
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
@RequestMapping("/api/resource")
@RequiredArgsConstructor
public class ResourceDistController {
    @Autowired
    private final ResourceDistService service;
    @Autowired
    private final ResourceDistMapper mapper;

    @PostMapping("/create-resource-dist")
    public ResponseEntity<ResourceDistOutDto> createResourceDist(@RequestBody ResourceDistInDto dto){
        ResourceDistOutDto result = service.createDist(dto);
        return ResponseEntity.ok(result);
    }
    @GetMapping()
    public ResponseEntity<List<ResourceDistOutDto>> getAllResourceDists(){
        List<ResourceDistOutDto> result = service.findAllDist();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<ResourceDistOutDto> getResourceDistById(@PathVariable Long id){
        ResourceDistribution dist = service.findDistById(id);
        ResourceDistOutDto result = mapper.toDto(dist);
        return ResponseEntity.ok(result);
    }
}
