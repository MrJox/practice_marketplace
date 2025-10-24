package com.marketplace.controller;

import com.marketplace.dto.ProductDto;
import com.marketplace.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto dto = service.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
