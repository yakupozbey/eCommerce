package com.education.ecommerce.service;

import com.education.ecommerce.dto.UserDto;

import java.util.List;
import java.util.UUID;


public interface UserService {
    UserDto create(UserDto userDto);

    UserDto update(UUID userId, UserDto dto);

    void delete(UUID userId);

    UserDto get(UUID userId);

    List<UserDto> getAll();
}
