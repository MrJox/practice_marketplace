package com.marketplace.mapper;

import com.marketplace.dto.ProductDto;
import com.marketplace.entity.Product;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-24T18:14:52+0200",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.8 (JetBrains s.r.o.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductDto dto) {
        if ( dto == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( dto.name() );
        product.setPrice( dto.price() );

        product.setCreatedAt( java.time.LocalDateTime.now() );

        return product;
    }

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        String name = null;
        BigDecimal price = null;

        name = product.getName();
        price = product.getPrice();

        ProductDto productDto = new ProductDto( name, price );

        return productDto;
    }
}
