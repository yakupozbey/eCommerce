package com.education.ecommerce.response;

import com.education.ecommerce.dto.ProductDto;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryResponse extends BaseResponse{
    private UUID categoryId;
    private String categoryName;
    private List<ProductDto> products;
}
