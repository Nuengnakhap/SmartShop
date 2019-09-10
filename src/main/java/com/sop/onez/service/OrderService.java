package com.sop.onez.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sop.onez.model.Order;
import com.sop.onez.model.OrderDetail;
import com.sop.onez.model.Product;
import com.sop.onez.repository.OrderDetailRepository;
import com.sop.onez.repository.OrderRepository;
import com.sop.onez.repository.ProductRepository;

@Service("orderService")
public class OrderService implements Services {

	@Autowired
	private OrderDetailRepository orderDetailRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private OrderRepository orderRepository;

	
	@Override
	public Object getById(int id) {
		Optional<Order> order = orderRepository.findById(id);
		if (order.isPresent()) {
			return orderDetailRepository.findByCustomerId(order.get().getCustomerId());
		}
		return null;
	}

	@Override
	public Object getAll() {
		return orderRepository.findAll();
	}

	@Override
	public void create(Object item) {
		OrderDetail orderDetail = (OrderDetail) item;
		Optional<Product> product = productRepository.findById(orderDetail.getProductId());
		if (product.isPresent()) {
			
			Order order = null;
			Optional<Order> customer = orderRepository.findByCustomerId(orderDetail.getCustomerId());
			if (customer.isPresent()) {
				order = customer.get();
				order.setOrderNum(order.getOrderNum() + 1);
			} else {
				order = new Order(orderDetail.getCustomerId());
				order.setId(((int) orderRepository.count()) + 1);
				order.setOrderNum(1);
			}
			orderRepository.save(order);
			
			// Set order ID
			orderDetail.setId(((int) orderDetailRepository.count()) + 1);
			// Set order date
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date();
			orderDetail.setOrderDate(dateFormat.format(date));
			// Set order price
			Product product2 = product.get();
			orderDetail.setPrice(orderDetail.getQuanity() * product2.getPrice());
			// Save to database
			orderDetailRepository.save(orderDetail);
		}
	}

	@Override
	public void update(int id, Object item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
