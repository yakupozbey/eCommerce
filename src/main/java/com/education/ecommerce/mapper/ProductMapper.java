package com.education.ecommerce.mapper;

import com.education.ecommerce.dto.ProductDto;
import com.education.ecommerce.entity.Category;
import com.education.ecommerce.entity.Product;
import com.education.ecommerce.request.ProductRequest;
import com.education.ecommerce.response.ProductResponse;
import com.education.ecommerce.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductMapper {
    private final CategoryServiceImpl categoryService;


    public static ProductDto toDto(ProductRequest request) {
        ProductDto dto = new ProductDto();
        dto.setProductName(request.getProductName());
        dto.setProductDescription(request.getProductDescription());
        dto.setProductPrice(request.getProductPrice());
        dto.setCategoryId(request.getCategoryId());
        return dto;
    }

    public static ProductResponse toRespone(ProductDto dto) {
        ProductResponse response = new ProductResponse();
        response.setProductId(dto.getProductId());
        response.setProductName(dto.getProductName());
        response.setProductDescription(dto.getProductDescription());
        response.setProductPrice(dto.getProductPrice());
        response.setCategoryId(dto.getCategoryId());
        return response;
    }

    public static List<ProductResponse> toResponseList(List<ProductDto> dtoList) {
        return dtoList.stream()
                .map(ProductMapper::toRespone)
                .collect(Collectors.toList());
    }

    public static Product toEntity(ProductDto dto) {
        /*Product entity = new Product();
        entity.setProductName(dto.getProductName());
        entity.setProductDescription(dto.getProductDescription());
        entity.setProductPrice(dto.getProductPrice());
        entity.setCategory(categoryService.findById(dto.getCategoryId()));
        return entity;                                                //Builder ile yaptığımda sorunsuz çalışıyor. Ama 42-46 kodları ile yapılırsa categoryService.findById(dto.getCategoryId() NULLPOİNTEREXCEPTİON atıyor.
        */                                                            // Sebebi ise CategoryService'in düzgün Inject edilmemesidir. Çözümü nasıl araştır
        return Product.builder()
                .productName(dto.getProductName())
                .productDescription(dto.getProductDescription())
                .productPrice(dto.getProductPrice())
                .category(Category.builder().categoryId(dto.getCategoryId()).build())
                .build();


    }

    public static ProductDto toDto(Product entity) {
        ProductDto dto = new ProductDto();
        dto.setProductId(entity.getProductId());
        dto.setProductName(entity.getProductName());
        dto.setProductDescription(entity.getProductDescription());
        dto.setProductPrice(entity.getProductPrice());
        dto.setCategoryId(entity.getCategory().getCategoryId());
        return dto;
    }

    public static List<ProductDto> toDtoList(List<Product> entityList) {
        if (entityList == null) {
            return Collections.emptyList();
        }
        return entityList.stream()
                .map(ProductMapper::toDto)
                .collect(Collectors.toList());
    }

    public static List<Product> toEntityList(List<ProductDto> dtoList) {
        if (dtoList == null) {
            return Collections.emptyList();
        }
        return dtoList.stream()
                .map(ProductMapper::toEntity)
                .collect(Collectors.toList());
    }
}
