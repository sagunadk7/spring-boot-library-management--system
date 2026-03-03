package com.project.library_management_system.controller;

import com.project.library_management_system.dto.UserRequestDto;
import com.project.library_management_system.dto.UserResponseDto;
import com.project.library_management_system.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl service;
    public UserController(UserServiceImpl service){
        this.service = service;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto user) {
        System.out.println(user);
        return service.registerUser(user);
    }
}
