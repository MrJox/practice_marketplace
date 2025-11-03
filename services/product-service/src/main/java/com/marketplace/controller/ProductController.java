package com.marketplace.controller;

import com.marketplace.dto.*;
import com.marketplace.service.ProductService;
import com.marketplace.util.UriUtil;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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

        URI location = UriUtil.buildResourceUri(dto.id());
        return ResponseEntity.created(location).body(dto);
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
    public ResponseEntity<ProductDto> updateProductDescription(@PathVariable("productId") Long productId, @RequestBody ProductDto requestDto) {
        ProductDto productDto = service.updateDescription(productId, requestDto.description());
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PatchMapping("/{productId}/price")
    public ResponseEntity<ProductDto> updateProductPrice(@PathVariable("productId") Long productId, @RequestBody ProductDto requestDto) {
        ProductDto productDto = service.updatePrice(productId, requestDto.price());
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PatchMapping("/{productId}/status")
    public ResponseEntity<ProductDto> updateProductStatus(@PathVariable("productId") Long productId, @RequestBody ProductDto requestDto) {
        ProductDto dto = service.updateAvailabilityStatus(productId, requestDto.status());
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
