package com.education.ecommerce.controller;

import com.education.ecommerce.mapper.ProductMapper;
import com.education.ecommerce.request.ProductRequest;
import com.education.ecommerce.response.ProductResponse;
import com.education.ecommerce.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    public ProductResponse create(@RequestBody ProductRequest request){
        return ProductMapper.toRespone((service.create(ProductMapper.toDto(request))));
    }
}
