package com.education.ecommerce.controller;

import com.education.ecommerce.mapper.ProductMapper;
import com.education.ecommerce.request.ProductRequest;
import com.education.ecommerce.response.ProductResponse;
import com.education.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @PostMapping
    public ProductResponse create(@RequestBody ProductRequest request) {
        return ProductMapper.toRespone((service.create(ProductMapper.toDto(request))));
    }

    @PutMapping
    public ProductResponse update(@RequestParam(value = "productId") UUID productId, @RequestBody ProductRequest request) {
        return ProductMapper.toRespone(service.update(productId, ProductMapper.toDto(request)));
    }

    @DeleteMapping
    public void delete(@RequestParam(value = "productId") UUID productId) {
        service.delete(productId);
    }

    @GetMapping("/{productId}")
    public ProductResponse getById(@PathVariable(name = "productId") UUID productId) {
        return ProductMapper.toRespone(service.getById(productId));
    }

    @GetMapping
    public List<ProductResponse> getAll() {
        return ProductMapper.toResponseList(service.getAll());
    }
}
