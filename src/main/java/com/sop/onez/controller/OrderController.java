package com.sop.onez.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sop.onez.model.OrderDetail;
import com.sop.onez.service.ServiceFactory;
import com.sop.onez.service.Services;

@RestController
public class OrderController {

	ServiceFactory serviceFactory = ServiceFactory.getInstanse();

	@Autowired
	@Qualifier("orderService")
	Services orderSevice = serviceFactory.getService("ORDER");

	@GetMapping("/orders")
	public Object getAllOrder() {
		return orderSevice.getAll();
	}
	
	@GetMapping("/orders/{id}")
	public Object getOrderDetailByCustomerId(@PathVariable int id) {
		return orderSevice.getById(id);
	}

	@PostMapping("/orders")
	public Object postOrder(@RequestBody @Valid OrderDetail order) {
		orderSevice.create(order);
		return orderSevice.getAll();
	}

}
