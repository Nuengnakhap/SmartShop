package com.sop.onez;

public class Order {
	private String customerId;
	private int orderNum;

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
	
}
