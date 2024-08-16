package com.education.ecommerce.dto;


import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketDto {
    private UUID basketId;
    private Integer status;
    private Double totalPrice;
    private List<BasketProductDto> basketProducts;
    private UUID userId;
}
