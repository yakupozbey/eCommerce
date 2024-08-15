package com.education.ecommerce.service;

import com.education.ecommerce.dto.CategoryDto;
import com.education.ecommerce.response.CategoryResponse;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    CategoryDto create(CategoryDto dto);

    CategoryDto update(UUID categoryId, CategoryDto dto);

    void delete(UUID categoryId);

    CategoryDto getById(UUID categoryId);

    List<CategoryDto> getAll();

}
