package com.education.ecommerce.response;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse extends BaseResponse{
    private UUID productId;
    private String productName;
    private String productDescription;
    private Long productPrice;
    private UUID categoryId;
}
