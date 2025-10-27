package com.marketplace.controller;

import com.marketplace.dto.ProductDto;
import com.marketplace.dto.ProductFilterDto;
import com.marketplace.service.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public ResponseEntity<Page<ProductDto>> getProducts(@ModelAttribute ProductFilterDto filterDto, Pageable pageable) {
        Page<ProductDto> page = service.getProductsFiltered(filterDto, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") Long productId) {
        ProductDto dto = service.getProductById(productId);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        ProductDto dto = service.createProduct(productDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
