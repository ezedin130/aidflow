package com.example.aidflow.controller;

import com.example.aidflow.dto.userDto.UserInDto;
import com.example.aidflow.dto.userDto.UserOutDto;
import com.example.aidflow.mapper.UserMapper;
import com.example.aidflow.model.User;
import com.example.aidflow.service.UserService;
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
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService service;
    @Autowired
    private final UserMapper mapper;

    @PostMapping("/create-user")
    public ResponseEntity<UserOutDto> createUser(@RequestBody UserInDto dto){
        UserOutDto result = service.createUser(dto);
        return ResponseEntity.ok(result);
    }
    @GetMapping()
    public ResponseEntity<List<UserOutDto>> findAllUsers(){
        List<UserOutDto> result = service.findAllUsers();
        return ResponseEntity.ok(result);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserOutDto> findUserById(@PathVariable Long id){
        User user = service.findUserById(id);
        UserOutDto result = mapper.toDto(user);
        return ResponseEntity.ok(result);
    }
}
