package com.project.library_management_system.service.impl;

import com.project.library_management_system.dto.UserRequestDto;
import com.project.library_management_system.dto.UserResponseDto;
import com.project.library_management_system.entity.User;
import com.project.library_management_system.mapper.UserMapper;
import com.project.library_management_system.repository.UserRepository;
import com.project.library_management_system.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public UserResponseDto registerUser(UserRequestDto user){
        User user1 = UserMapper.toEntity(user);
        userRepository.save(user1);
        return UserMapper.toResponse(user1);
    }
}
