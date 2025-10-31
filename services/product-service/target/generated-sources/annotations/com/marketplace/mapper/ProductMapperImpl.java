package com.marketplace.mapper;

import com.marketplace.dto.ProductDto;
import com.marketplace.entity.Product;
import com.marketplace.entity.ProductAvailabilityStatus;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-31T10:22:36+0100",
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
        product.setDescription( dto.description() );
        product.setPrice( dto.price() );
        product.setStatus( dto.status() );

        product.setCreatedAt( java.time.LocalDateTime.now() );

        return product;
    }

    @Override
    public ProductDto toDto(Product product) {
        if ( product == null ) {
            return null;
        }

        String name = null;
        String description = null;
        BigDecimal price = null;
        ProductAvailabilityStatus status = null;

        name = product.getName();
        description = product.getDescription();
        price = product.getPrice();
        status = product.getStatus();

        ProductDto productDto = new ProductDto( name, description, price, status );

        return productDto;
    }

    @Override
    public void updateProductFromDto(Product product, ProductDto dto) {
        if ( dto == null ) {
            return;
        }

        product.setName( dto.name() );
        product.setDescription( dto.description() );
        product.setPrice( dto.price() );
        product.setStatus( dto.status() );
    }
}
