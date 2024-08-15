package com.education.ecommerce.mapper;

import com.education.ecommerce.dto.CategoryDto;
import com.education.ecommerce.entity.Category;
import com.education.ecommerce.request.CategoryRequest;
import com.education.ecommerce.response.CategoryResponse;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static CategoryDto toDto(CategoryRequest request) {
        CategoryDto dto= new CategoryDto();
        dto.setCategoryName(request.getCategoryName());
        return dto;
    }

    public static CategoryResponse toResponse(CategoryDto dto) {
        CategoryResponse response= new CategoryResponse();
        response.setCategoryId(dto.getCategoryId());
        response.setCategoryName(dto.getCategoryName());
        response.setProducts(dto.getProducts());
        return response;
    }

    public static List<CategoryResponse> toResponseList(List<CategoryDto> dtoList){
        return dtoList.stream()
                .map(CategoryMapper::toResponse)
                .collect(Collectors.toList());
    }

    public static Category toEntity(CategoryDto dto) {
        Category entity= new Category();
        entity.setCategoryName(dto.getCategoryName());
        return entity;
    }

    public static CategoryDto toDto(Category entity){
        CategoryDto dto= new CategoryDto();
        dto.setCategoryId(entity.getCategoryId());
        dto.setCategoryName(entity.getCategoryName());
        dto.setProducts(ProductMapper.toDtoList(entity.getProducts()));
        return dto;
    }

    public static List<CategoryDto> toDtoList(List<Category> entityList){
        return entityList.stream()
                .map(CategoryMapper::toDto)
                .collect(Collectors.toList());
    }
}
