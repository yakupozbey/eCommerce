package com.education.ecommerce.request;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {
    private UUID productId;
    private String productName;
    private String productDescription;
    private Long productPrice;
    private UUID categoryId;
}
