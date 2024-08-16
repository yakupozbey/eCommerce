package com.education.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasketProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID basketProductId;
    private Integer count;
    private Double totalAmount;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
