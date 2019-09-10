package com.sop.onez.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sop.onez.model.Product;
import com.sop.onez.repository.ProductRepository;

@Service("productService")
public class ProductService implements Services {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Object getById(int id) {
		if (productRepository.findById(id).isPresent()) {
			return productRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public Object getAll() {
		return productRepository.findAll();
	}

	@Override
	public void create(Object item) {
		Product product = (Product) item;
		product.setId(((int) productRepository.count()) + 1);
		productRepository.save(product);
	}

	@Override
	public void update(int id, Object item) {
		if (productRepository.findById(id).isPresent()) {
			Product product = (Product) item;
			product.setId(id);
			productRepository.save(product);
		}
	}

	@Override
	public void deleteById(int id) {
		if (productRepository.findById(id).isPresent()) {
			productRepository.deleteById(id);
		}
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
	}

}
