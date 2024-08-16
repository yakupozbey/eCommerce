package com.education.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID basketId;
    private Integer status;
    private Double totalPrice;

    @OneToMany(mappedBy = "basket")
    private List<BasketProduct> basketProducts;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
