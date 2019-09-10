package com.sop.onez.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDER_DETAIL")
public class OrderDetail {

	@Id
	private int id;
	@Column(name = "customer_id")
    private String customerId;
    private int quanity;
    private double price;
    @Column(name = "product_id")
    private int productId;
    @Column(name = "orderdate")
    private String orderDate;
    
    public OrderDetail() {
    	super();
    }
    
	public OrderDetail(String customerId, int productId, int quanity) {
		super();
		this.customerId = customerId;
		this.quanity = quanity;
		this.productId = productId;
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.orderDate = dateFormat.format(date);
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
