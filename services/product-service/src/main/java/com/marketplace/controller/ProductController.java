package com.marketplace.controller;

import com.marketplace.dto.ProductDto;
import com.marketplace.dto.ProductFilterDto;
import com.marketplace.entity.Product;
import com.marketplace.entity.ProductAvailabilityStatus;
import com.marketplace.service.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

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

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Long productId) {
        service.deleteProduct(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable("productId") Long productId, @RequestBody ProductDto productDto) {
        ProductDto dto = service.updateProduct(productId, productDto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PatchMapping("/{productId}/description")
    public ResponseEntity<ProductDto> updateProductDescription(@PathVariable("productId") Long productId, @RequestBody String description) {
        ProductDto dto = service.updateDescription(productId, description);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PatchMapping("/{productId}/price")
    public ResponseEntity<ProductDto> updateProductPrice(@PathVariable("productId") Long productId, @RequestBody BigDecimal price) {
        ProductDto dto = service.updatePrice(productId, price);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    @PatchMapping("/{productId}/status")
    public ResponseEntity<ProductDto> updateProductStatus(@PathVariable("productId") Long productId, @RequestBody ProductAvailabilityStatus status) {
        ProductDto dto = service.updateAvailabilityStatus(productId, status);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
