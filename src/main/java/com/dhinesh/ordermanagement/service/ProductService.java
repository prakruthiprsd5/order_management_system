package com.dhinesh.ordermanagement.service;

import java.util.List;
import java.util.Optional;

import com.dhinesh.ordermanagement.dao.ProductRepository;
import com.dhinesh.ordermanagement.exceptions.DuplicateValueException;
import com.dhinesh.ordermanagement.exceptions.InvalidProductException;
import com.dhinesh.ordermanagement.model.Product;
import com.dhinesh.ordermanagement.exceptions.ProductNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	@Autowired
    ProductRepository pr;

	public void save(Product product) throws DuplicateValueException, InvalidProductException {
		if (product.getProductPrice() < 0.1) {
			throw new InvalidProductException("Product price cannot be Zero");
		}
		try {
			pr.save(product);
		} catch (DataIntegrityViolationException e) {
			throw new DuplicateValueException("Product with the same name already exists.");
		} catch (Exception e) {
			throw new ServiceException("Failed to save product: " + e.getMessage());
		}
	}


	public void delete(Long id) {
		pr.deleteById(id);
	}
	public List<Product> get(){
		return (List<Product>) pr.findAll();
	}

	public void deductQty(long id, int qty) throws ProductNotFoundException {

		Optional<Product> optionalProduct = findById(id);
		Product product = optionalProduct.get();
		int newQty = product.getProductQty() - qty;
		product.setProductQty(newQty);
		pr.save(product);
	}
	public void addQty(long id, int qty) throws ProductNotFoundException {
		Optional<Product> optionalProduct = findById(id);
		Product product = optionalProduct.get();
		int newQty = product.getProductQty() + qty;
		product.setProductQty(newQty);
		pr.save(product);
	}

	public Optional<Product> findById(long id) throws ProductNotFoundException {
		Optional<Product> optionalProduct = pr.findById(id);
		if (!optionalProduct.isPresent()) {
			throw new ProductNotFoundException("Product not available");
		}
		return optionalProduct;
	}

	public List<Product> findByCategoryId(Long categoryId) {
		return pr.findByCategoryId(categoryId);
	}
}
