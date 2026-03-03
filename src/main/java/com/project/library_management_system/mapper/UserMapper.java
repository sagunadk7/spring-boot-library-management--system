package com.project.library_management_system.mapper;

import com.project.library_management_system.dto.UserRequestDto;
import com.project.library_management_system.dto.UserResponseDto;
import com.project.library_management_system.entity.User;

import java.time.Instant;
import java.time.LocalDate;

public class UserMapper {

    public static UserResponseDto toResponse(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static User toEntity(UserRequestDto request) {
        return new User(
                null,
                request.getName(),
                request.getEmail(),
                request.getPassword(),
                LocalDate.now()
        );
    }
}
