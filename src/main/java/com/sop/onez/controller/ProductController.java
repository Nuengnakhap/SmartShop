package com.sop.onez.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sop.onez.model.Product;
import com.sop.onez.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService productSevice;
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productSevice.getAllProduct();
	}
	
	@GetMapping("/products/{productId}")
	public Product getProducts(@PathVariable int productId) {
		return productSevice.getProduct(productId);
	}

	@PostMapping("/products")
	List<Product> postProduct(@RequestBody @Valid Product item) {
		productSevice.saveProduct(item);
		return productSevice.getAllProduct();
	}
	
	@PutMapping("/products/{productId}")
    public Object putProduct(@PathVariable int productId, @Valid @RequestBody Product item) {
        productSevice.updateProduct(productId, item);
        return productSevice.getProduct(productId);
    }
	
	@DeleteMapping("/products/{productId}")
	public Object deleteProduct(@PathVariable int productId) {
        productSevice.deleteProduct(productId);
        return productSevice.getAllProduct();
    }
}
