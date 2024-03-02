package com.dhinesh.ordermanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhinesh.ordermanagement.model.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}
