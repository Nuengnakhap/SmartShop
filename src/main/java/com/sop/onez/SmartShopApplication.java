package com.sop.onez;

import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class SmartShopApplication {
	
	ProductService pservice = new ProductService();

	public static void main(String[] args) {
		SpringApplication.run(SmartShopApplication.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
	@GetMapping("/products")
	List<Product> products() {
		return pservice.getAllProduct();
	}
	
	@PostMapping
	List<Product> addProduct(@RequestBody @Valid Product item) {
		pservice.addNewProduct(item);
		return pservice.getAllProduct();
//		pservice.addNewProduct(item);
	}
}
