package com.education.ecommerce.response;


import com.education.ecommerce.dto.BasketProductDto;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketResponse {
    private UUID basketId;
    private Integer status;
    private Double totalPrice;
    private List<BasketProductDto> basketProducts;
    private UUID userId;
}
