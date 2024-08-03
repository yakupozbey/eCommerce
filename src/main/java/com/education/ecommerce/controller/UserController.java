package com.education.ecommerce.controller;

import com.education.ecommerce.mapper.UserMapper;
import com.education.ecommerce.request.UserRequest;
import com.education.ecommerce.response.UserResponse;
import com.education.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping
    private UserResponse create(@RequestBody UserRequest request) {
        return UserMapper.toResponse(service.create(UserMapper.toDto(request)));
    }

    @PutMapping
    private UserResponse update(@RequestParam(value = "userId") UUID userId, @RequestBody UserRequest request){
        return UserMapper.toResponse(service.update(userId, UserMapper.toDto(request)));
    }

    @DeleteMapping
    private void delete(@RequestParam(value = "userId") UUID userId){
        service.delete(userId);
    }

    @GetMapping("/{userId}")
    private UserResponse get(@PathVariable(name = "userId") UUID userId){
        return UserMapper.toResponse(service.get(userId));
    }

    @GetMapping
    private List<UserResponse> getAll(){
        return UserMapper.toResponseList(service.getAll());
    }


}
