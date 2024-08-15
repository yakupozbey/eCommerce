package com.education.ecommerce.dto;

import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private UUID categoryId;
    private String categoryName;
    private List<ProductDto> products;
}
