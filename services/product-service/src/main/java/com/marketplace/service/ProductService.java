package com.marketplace.service;

import com.marketplace.dto.ProductDto;
import com.marketplace.dto.ProductFilterDto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;

public interface ProductService {
    Page<ProductDto> getProductsFiltered(ProductFilterDto filterDto, Pageable pageable);
    ProductDto getProductById(Long productId);
    ProductDto createProduct(ProductDto dto);
}
