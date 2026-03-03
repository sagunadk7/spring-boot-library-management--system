package com.project.library_management_system.service;

import com.project.library_management_system.dto.UserRequestDto;
import com.project.library_management_system.dto.UserResponseDto;
import com.project.library_management_system.entity.User;

public interface UserService {
    UserResponseDto registerUser(UserRequestDto user);
}
