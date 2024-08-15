package com.education.ecommerce.repository;

import com.education.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Category findCategoryByCategoryId(UUID categoryId);
}
