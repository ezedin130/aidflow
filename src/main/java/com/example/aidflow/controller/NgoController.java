package com.example.aidflow.controller;

import com.example.aidflow.dto.ngoDto.NgoInDto;
import com.example.aidflow.dto.ngoDto.NgoOutDto;
import com.example.aidflow.mapper.NgoMapper;
import com.example.aidflow.model.Ngo;
import com.example.aidflow.service.NgoService;
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
@RequiredArgsConstructor
@RequestMapping("/api/ngo")
public class NgoController {
    @Autowired
    private final NgoService service;
    @Autowired
    private NgoMapper mapper;

    @PostMapping("/create-ngo")
    public ResponseEntity<NgoOutDto> createNgo(@RequestBody NgoInDto dto){
        NgoOutDto result = service.createNgo(dto);
        return ResponseEntity.ok(result);
    }
    @GetMapping()
    public ResponseEntity<List<NgoOutDto>> findAllNgo(){
        List<NgoOutDto> result = service.findAllNgo();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<NgoOutDto> findNgoById(@PathVariable Long id){
        Ngo ngo = service.findngoById(id);
        NgoOutDto result = mapper.toDto(ngo);
        return ResponseEntity.ok(result);
    }
}
