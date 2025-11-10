package com.example.aidflow.service;

import com.example.aidflow.dto.userDto.UserInDto;
import com.example.aidflow.dto.userDto.UserOutDto;
import com.example.aidflow.mapper.UserMapper;
import com.example.aidflow.model.User;
import com.example.aidflow.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepo;
    @Autowired
    private final UserMapper mapper;

    public UserOutDto createUser(UserInDto dto){
        User user = mapper.toEntity(dto);
        User savedUser = userRepo.save(user);
        return mapper.toDto(savedUser);
    }
    public List<UserOutDto> findAllUsers(){
        return userRepo.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
    public User findUserById(Long id){
        return userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User with " +id+ " is not found"));
    }
}