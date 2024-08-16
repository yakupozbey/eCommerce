package com.education.ecommerce.service.impl;

import com.education.ecommerce.dto.ProductDto;
import com.education.ecommerce.entity.Product;
import com.education.ecommerce.mapper.ProductMapper;
import com.education.ecommerce.repository.ProductRepository;
import com.education.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;

    @Override
    public ProductDto create(ProductDto dto) {
        return ProductMapper.toDto(repository.save(ProductMapper.toEntity(dto)));
    }

    @Override
    public ProductDto update(UUID productId, ProductDto dto) {
        Product entity = repository.findProductByProductId(productId);
        Product exitEntity = ProductMapper.toEntity(dto);
        exitEntity.setProductId(entity.getProductId());
        exitEntity = repository.save(exitEntity);
        return ProductMapper.toDto(exitEntity);
    }

    @Override
    public void delete(UUID productId) {
        repository.deleteById(productId);
    }

    @Override
    public ProductDto getById(UUID productId) {
        return ProductMapper.toDto(repository.findProductByProductId(productId));
    }

    @Override
    public List<ProductDto> getAll() {
        return ProductMapper.toDtoList(repository.findAll());
    }
}
