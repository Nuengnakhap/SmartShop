package com.sop.onez.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sop.onez.model.Product;
import com.sop.onez.service.ServiceFactory;
import com.sop.onez.service.Services;

@RestController
public class ProductController {
	
	ServiceFactory serviceFactory = ServiceFactory.getInstanse();
	
	@Autowired
	@Qualifier("productService")
	Services productSevice = serviceFactory.getService("PRODUCT");
	
	@GetMapping("/products")
	public Object getAllProducts() {
		return productSevice.getAll();
	}
	
	@GetMapping("/products/{productId}")
	public Object getProducts(@PathVariable int productId) {
		return productSevice.getById(productId);
	}

	@PostMapping("/products")
	Object postProduct(@RequestBody @Valid Product item) {
		productSevice.create(item);
		return productSevice.getAll();
	}
	
	@PutMapping("/products/{productId}")
    public Object putProduct(@PathVariable int productId, @Valid @RequestBody Product item) {
        productSevice.update(productId, item);
        return productSevice.getById(productId);
    }
	
	@DeleteMapping("/products/{productId}")
	public Object deleteProduct(@PathVariable int productId) {
        productSevice.deleteById(productId);
        return productSevice.getAll();
    }
}
