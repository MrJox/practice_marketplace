package com.marketplace.service;

import com.marketplace.dto.ProductDto;
import com.marketplace.dto.ProductFilterDto;

import com.marketplace.entity.ProductAvailabilityStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.ArrayList;

public interface ProductService {
    Page<ProductDto> getProductsFiltered(ProductFilterDto filterDto, Pageable pageable);
    ProductDto getProductById(Long productId);
    ProductDto createProduct(ProductDto dto);
    void deleteProduct(Long productId);
    ProductDto updateProduct(Long productId, ProductDto dto);
    ProductDto updateDescription(Long productId, String description);
    ProductDto updatePrice(Long productId, BigDecimal price);
    ProductDto updateAvailabilityStatus(Long productId, ProductAvailabilityStatus status);
}
