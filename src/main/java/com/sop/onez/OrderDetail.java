package com.sop.onez;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sop.onez.model.Order;
import com.sop.onez.model.Product;

public class OrderDetail {

	private int id;
    private String customerId;
    private int quanity;
    private double price;
    private int productId;
    private String orderDate;
    private Product product;
    
	public OrderDetail(String customerId, int productId, int quanity) {
		super();
		this.customerId = customerId;
		this.quanity = quanity;
		this.productId = productId;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.setOrderDate(dateFormat.format(date));
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Order setOrder(String customerId) {
		Order order = new Order(customerId);
		return order;
	}
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
		this.price = product.getPrice() * quanity;
	}
	
	public int getQuanity() {
		return quanity;
	}
	
	public void setQuanity(int quanity) {
		this.quanity = quanity;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
    
}
