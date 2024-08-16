package com.education.ecommerce.dto;


import lombok.*;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketProductDto {
    private UUID basketProductId;
    private Integer count;
    private Double totalAmount;
    private UUID basketId;
    private UUID productId;
}
