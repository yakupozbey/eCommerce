package com.education.ecommerce.service.impl;

import com.education.ecommerce.dto.UserDto;
import com.education.ecommerce.entity.User;
import com.education.ecommerce.mapper.UserMapper;
import com.education.ecommerce.repository.UserRepository;
import com.education.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserDto create(UserDto dto) {
        return UserMapper.toDto(repository.save(UserMapper.toEntity(dto)));
    }

    @Override
    public UserDto update(UUID userId, UserDto dto) {
        User user= repository.findUserByUserId(userId);
        User exitUser= UserMapper.toEntity(dto);
        exitUser.setUserId(user.getUserId());
        exitUser= repository.save(exitUser);
        return UserMapper.toDto(exitUser);
    }

    @Override
    public void delete(UUID userId) {
        repository.deleteById(userId);
    }

    @Override
    public UserDto get(UUID userId) {
        return UserMapper.toDto(repository.findUserByUserId(userId));
    }

    @Override
    public List<UserDto> getAll() {
        return UserMapper.toDtoList(repository.findAll());
    }
}
