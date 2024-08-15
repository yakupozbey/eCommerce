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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID productId;
    private String productName;
    private String productDescription;
    private Long productPrice;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}
