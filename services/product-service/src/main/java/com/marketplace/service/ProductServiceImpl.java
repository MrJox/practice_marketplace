package com.marketplace.service;

import com.marketplace.dto.ProductDto;
import com.marketplace.entity.Product;
import com.marketplace.mapper.ProductMapper;
import com.marketplace.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ProductDto createProduct(ProductDto dto) {
        Product product = mapper.toEntity(dto);
        Product savedProduct = repository.save(product);
        return mapper.toDto(savedProduct);
    }
}
