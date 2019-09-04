package com.sop.onez;

import java.util.List;

import javax.validation.Valid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class SmartShopApplication {
	
	ShopService services = new ShopService();

	public static void main(String[] args) {
		SpringApplication.run(SmartShopApplication.class, args);
	}

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
	
	@GetMapping("/products")
	List<Product> getProducts() {
		return services.getAllProduct();
	}
	
	@PostMapping("/products")
	List<Product> postProduct(@RequestBody @Valid Product item) {
		services.addNewProduct(item);
		return services.getAllProduct();
	}
	
	@PutMapping("/products/{productId}")
    public Object putProduct(@PathVariable int productId, @Valid @RequestBody Product item) {
        services.editProduct(productId, item);
        return services.getProduct(productId);
    }

	@PostMapping("/order")
	String buyProduct(@RequestBody @Valid OrderDetail item) {
		services.addOrder(item);
		return "You have purchased the product for " + item.getPrice() + " baht.";
	}
	
	@GetMapping("/emp/order")
	Object getAllOrder() {
		return services.getOrder();
	}
	
	
}
