package com.dhinesh.ordermanagement.service;

import java.util.List;
import java.util.Optional;

import com.dhinesh.ordermanagement.dao.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dhinesh.ordermanagement.model.ProductCategory;

@Service
public class ProductCategoryService {

	@Autowired
    ProductCategoryRepository pcr;
	
	public void save(ProductCategory productCategory) {
		pcr.save(productCategory);
	}

	public void delete(Long id){
		pcr.deleteById(id);
	}

	public List<ProductCategory> get(){
		return (List<ProductCategory>) pcr.findAll();
	}

	public Optional<ProductCategory> findById(Long id) {
		return pcr.findById(id);
	}
}
