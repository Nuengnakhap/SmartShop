package com.sop.onez;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	Product[] products() {
		return pservice.getAllProduct();
	}
	
}
