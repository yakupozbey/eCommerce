package com.education.ecommerce.service.impl;

import com.education.ecommerce.dto.ProductDto;
import com.education.ecommerce.entity.Product;
import com.education.ecommerce.mapper.ProductMapper;
import com.education.ecommerce.repository.ProductRepository;
import com.education.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    public Product findById(UUID productId){
        return repository.findProductByProductId(productId);
    }

    @Override
    public ProductDto create(ProductDto dto) {
        return ProductMapper.toDto(repository.save(ProductMapper.toEntity(dto)));
    }
}
