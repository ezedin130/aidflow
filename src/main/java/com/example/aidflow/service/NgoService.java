package com.example.aidflow.service;

import com.example.aidflow.dto.ngoDto.NgoInDto;
import com.example.aidflow.dto.ngoDto.NgoOutDto;
import com.example.aidflow.mapper.NgoMapper;
import com.example.aidflow.model.Ngo;
import com.example.aidflow.model.User;
import com.example.aidflow.repository.NgoRepository;
import com.example.aidflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NgoService {
    @Autowired
    private final NgoRepository ngoRepo;
    @Autowired
    private final NgoMapper mapper;
    @Autowired
    private final UserRepository userRepo;

    public NgoOutDto createNgo(NgoInDto dto){
        User user = userRepo.findById(dto.getUser())
                .orElseThrow(()-> new RuntimeException("User not found"));
        Ngo ngo = mapper.toEntity(dto,user);
        Ngo saveduser = ngoRepo.save(ngo);
        return mapper.toDto(saveduser);
    }
    public List<NgoOutDto> findAllNgo(){
        return ngoRepo.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    public Ngo findngoById(Long id){
        return ngoRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("Ngo not found"));
    }
}
