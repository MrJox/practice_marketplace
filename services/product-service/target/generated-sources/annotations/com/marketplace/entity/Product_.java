package com.marketplace.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@StaticMetamodel(Product.class)
@Generated("org.hibernate.processor.HibernateProcessor")
public abstract class Product_ {

	public static final String CREATED_AT = "createdAt";
	public static final String PRODUCT_ID = "productId";
	public static final String PRICE = "price";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String STATUS = "status";

	
	/**
	 * @see com.marketplace.entity.Product#createdAt
	 **/
	public static volatile SingularAttribute<Product, LocalDateTime> createdAt;
	
	/**
	 * @see com.marketplace.entity.Product#productId
	 **/
	public static volatile SingularAttribute<Product, Long> productId;
	
	/**
	 * @see com.marketplace.entity.Product#price
	 **/
	public static volatile SingularAttribute<Product, BigDecimal> price;
	
	/**
	 * @see com.marketplace.entity.Product#name
	 **/
	public static volatile SingularAttribute<Product, String> name;
	
	/**
	 * @see com.marketplace.entity.Product#description
	 **/
	public static volatile SingularAttribute<Product, String> description;
	
	/**
	 * @see com.marketplace.entity.Product
	 **/
	public static volatile EntityType<Product> class_;
	
	/**
	 * @see com.marketplace.entity.Product#status
	 **/
	public static volatile SingularAttribute<Product, ProductAvailabilityStatus> status;

}

