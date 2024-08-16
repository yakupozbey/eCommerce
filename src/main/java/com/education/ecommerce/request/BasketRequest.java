package com.education.ecommerce.request;


import lombok.*;


import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketRequest {
    private UUID userId;
    private UUID productId;
}
