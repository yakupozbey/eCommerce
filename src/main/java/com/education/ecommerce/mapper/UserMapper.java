package com.education.ecommerce.mapper;

import com.education.ecommerce.dto.UserDto;
import com.education.ecommerce.entity.User;
import com.education.ecommerce.request.UserRequest;
import com.education.ecommerce.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserMapper {

    public static UserResponse toResponse(UserDto dto){
        UserResponse response= new UserResponse();
        response.setUserId(dto.getUserId());
        response.setUserName(dto.getUserName());
        response.setFullName(dto.getFullName());
        return response;
    }

    public static UserDto toDto(UserRequest request){
        UserDto dto= new UserDto();
        dto.setUserName(request.getUserName());
        dto.setFullName(request.getFullName());
        dto.setPassword(request.getPassword());
        dto.setAddress(request.getAddress());
        dto.setBirthDate(request.getBirthDate());
        return dto;
    }

    public static List<UserResponse> toResponseList(List<UserDto> dtoList){
        return dtoList.stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
    }


    public static UserDto toDto(User entity){
        UserDto dto= new UserDto();
        dto.setUserId(entity.getUserId());
        dto.setUserName(entity.getUserName());
        dto.setFullName(entity.getFullName());
        dto.setPassword(entity.getPassword());
        dto.setAddress(entity.getAddress());
        dto.setBirthDate(entity.getBirthDate());
        return dto;
    }

    public static User toEntity(UserDto dto){
        User entity= new User();
        entity.setUserName(dto.getUserName());
        entity.setFullName(dto.getFullName());
        entity.setPassword(dto.getPassword());
        entity.setAddress(dto.getAddress());
        entity.setBirthDate(dto.getBirthDate());
        return entity;
    }

    public static List<UserDto> toDtoList(List<User> entityList){
        return entityList.stream()
                .map(UserMapper::toDto)
                .collect(Collectors.toList());
    }
}
