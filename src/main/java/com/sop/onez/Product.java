package com.sop.onez;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
	private static AtomicInteger ID_GENERATOR = new AtomicInteger(0);
	private int id;
	private String name;
	private String description;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	private double price;
	
	public Product(String name, String description, double price) {
		super();
		this.id = ID_GENERATOR.getAndIncrement();
		this.name = name;
		this.description = description;
		this.price = price;
	}

}
