package com.dhinesh.ordermanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhinesh.ordermanagement.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
