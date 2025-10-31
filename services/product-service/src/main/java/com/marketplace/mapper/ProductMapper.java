package com.marketplace.mapper;

import com.marketplace.dto.ProductDto;
import com.marketplace.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    Product toEntity(ProductDto dto);

    ProductDto toDto(Product product);

    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    void updateProductFromDto(@MappingTarget Product product, ProductDto dto);
}
