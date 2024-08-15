package com.education.ecommerce.repository;

import com.education.ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    Product findProductByProductId(UUID productId);
}
