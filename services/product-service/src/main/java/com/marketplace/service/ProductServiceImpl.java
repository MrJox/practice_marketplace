package com.marketplace.service;

import com.marketplace.component.ProductSpecificationBuilder;
import com.marketplace.dto.ProductDto;
import com.marketplace.dto.ProductFilterDto;
import com.marketplace.entity.Product;
import com.marketplace.exception.NotFoundException;
import com.marketplace.mapper.ProductMapper;
import com.marketplace.repository.ProductRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final ProductSpecificationBuilder specificationBuilder;

    public ProductServiceImpl(ProductRepository repository, ProductMapper mapper, ProductSpecificationBuilder builder) {
        this.repository = repository;
        this.mapper = mapper;
        this.specificationBuilder = builder;
    }

    @Override
    public Page<ProductDto> getProductsFiltered(ProductFilterDto filterDto, Pageable pageable) {
        Specification<Product> specification = specificationBuilder.build(filterDto);
        Page<Product> filteredProducts = repository.findAll(specification, pageable);
        return filteredProducts.map(mapper::toDto);
    }

    @Override
    public ProductDto getProductById(Long productId) {
        Product product = repository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Product", productId));

        return mapper.toDto(product);
    }

    public ProductDto createProduct(ProductDto dto) {
        Product product = mapper.toEntity(dto);
        Product savedProduct = repository.save(product);
        return mapper.toDto(savedProduct);
    }
}
