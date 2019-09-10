package com.sop.onez.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")
public class Order {
	
	@Id
	private int id;
	@Column(name = "customer_id")
	private String customerId;
	@Column(name = "order_num")
	private int orderNum;

	public Order() {
		super();
	}
	
	public Order(String customerId) {
		super();
		this.customerId = customerId;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
