package com.education.ecommerce.service;

import com.education.ecommerce.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    ProductDto create(ProductDto dto);

    ProductDto update(UUID productId, ProductDto dto);

    void delete(UUID productId);

    ProductDto getById(UUID productId);

    List<ProductDto> getAll();
}
