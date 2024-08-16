package com.education.ecommerce.service.impl;

import com.education.ecommerce.dto.CategoryDto;
import com.education.ecommerce.entity.Category;
import com.education.ecommerce.mapper.CategoryMapper;
import com.education.ecommerce.mapper.ProductMapper;
import com.education.ecommerce.repository.CategoryRepository;
import com.education.ecommerce.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;

    @Override
    public CategoryDto create(CategoryDto dto) {
        return CategoryMapper.toDto(repository.save(CategoryMapper.toEntity(dto)));
    }

    @Transactional
    @Override
    public CategoryDto update(UUID categoryId, CategoryDto dto) {
        Category entity = repository.findCategoryByCategoryId(categoryId);
        entity.setCategoryName(dto.getCategoryName());
        entity.setProducts(ProductMapper.toEntityList(dto.getProducts()));
        entity = repository.save(entity);
        return CategoryMapper.toDto(entity);
    }

    @Override
    public void delete(UUID categoryId) {
        repository.deleteById(categoryId);
    }

    @Transactional
    @Override
    public CategoryDto getById(UUID categoryId) {
        return CategoryMapper.toDto(repository.findCategoryByCategoryId(categoryId));
    }

    @Transactional
    @Override
    public List<CategoryDto> getAll() {
        return CategoryMapper.toDtoList(repository.findAll());
    }

    public Category findById(UUID categoryId) {
        return repository.findCategoryByCategoryId(categoryId);
    }


}
