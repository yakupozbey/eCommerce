package com.education.ecommerce.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private UUID productId;
    private String productName;
    private String productDescription;
    private Long productPrice;
    private UUID categoryId;
}
