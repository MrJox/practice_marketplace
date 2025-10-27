package com.marketplace.component;

import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.marketplace.dto.ProductFilterDto;
import com.marketplace.entity.Product;
import com.marketplace.entity.Product_;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSpecificationBuilder {
    public Specification<Product> build(ProductFilterDto filterDto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filterDto.status() != null) {
                predicates.add(cb.equal(root.get(Product_.status), filterDto.status()));
            }

            if (filterDto.dateFrom() != null && filterDto.dateTo() != null) {
                predicates.add(cb.between(root.get(Product_.createdAt), filterDto.dateFrom(), filterDto.dateTo()));
            }

            if (filterDto.priceFrom() != null && filterDto.priceTo() != null) {
                predicates.add(cb.between(root.get(Product_.price), filterDto.priceFrom(), filterDto.priceTo()));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
