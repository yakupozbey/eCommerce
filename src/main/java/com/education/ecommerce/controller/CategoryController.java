package com.education.ecommerce.controller;

import com.education.ecommerce.mapper.CategoryMapper;
import com.education.ecommerce.request.CategoryRequest;
import com.education.ecommerce.response.CategoryResponse;
import com.education.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService service;

    @PostMapping
    public CategoryResponse create(@RequestBody CategoryRequest request) {
        return CategoryMapper.toResponse(service.create(CategoryMapper.toDto(request)));

    }

    @PutMapping
    public CategoryResponse update(@RequestParam(value = "categoryId") UUID categoryId, @RequestBody CategoryRequest request) {
        return CategoryMapper.toResponse(service.update(categoryId, CategoryMapper.toDto(request)));
    }

    @DeleteMapping
    public void delete(@RequestParam(value = "categoryId") UUID categoryId) {
        service.delete(categoryId);
    }

    @GetMapping("/{categoryId}")
    public CategoryResponse getById(@PathVariable(name = "categoryId") UUID categoryId) {
        return CategoryMapper.toResponse(service.getById(categoryId));
    }

    @GetMapping
    public List<CategoryResponse> getAll() {
        return CategoryMapper.toResponseList(service.getAll());
    }
}
