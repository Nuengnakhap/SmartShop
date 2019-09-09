package com.sop.onez.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sop.onez.model.Product;
import com.sop.onez.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	public Product getProduct(int id) {
		return productRepository.findById(id).get();
	}

	public void saveProduct(Product product) {
		int id = ((int) productRepository.count()) + 1;
		product.setId(id);
		productRepository.save(product);
	}
	
	public void updateProduct(int id, Product newProduct) {
		newProduct.setId(id);
		productRepository.save(newProduct);
	}
	
	public void deleteProduct(int id) {
		productRepository.deleteById(id);
	}

}
