package com.sop.onez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopService {

	static List<Product> products = new ArrayList<Product>();
	static Map<String, List<Object>> customers = new HashMap<>();
	static Map<String, Order> orders = new HashMap<>();
	static Map<String, List<OrderDetail>> orderDetails = new HashMap<>();

	public ShopService() {
		Product p = new Product("FLAPPER VEGETABLE MIX DELIGHTS 70 GM",
				"Vegetable chips are chips or crisps that are prepared using vegetables. Vegetable chips may be fried, deep-fried, dehydrated, dried or baked. Many various root vegetables or leaf vegetables are used.",
				10);
		p.setId(0);
		products.add(p);
		p = new Product("NICK SNACKS BABY APPLE STARS 30 GM",
				"Freshly baked cookies are the stuff of childhood dreams, help the kids make their own with these simple.",
				10);
		p.setId(1);
		products.add(p);
		p = new Product("CHI ORGANIC VIRGIN COCONUT OIL 200 ML", "Chi 100% Organic Virgin coconut oil is never heated.",
				10);
		p.setId(2);
		products.add(p);
		p = new Product("LA CUERVA BLACKBERRIES 300 GM",
				"The blackberry is an aggregate fruit that.The fruit is very dark purple with smooth, fragile skin. In the center of the cluster is a greenish-white core that extends to almost the bottom of the berry. Blackberries are red and hard when they are immature and turn black and shiny when they ripen.",
				10);
		p.setId(3);
		products.add(p);
		p = new Product("COCOMOJO PASSION PURE COCONUT WATER DRINK 250 ML",
				"A delightful and delicious pure coconut water drink blended with a burst of passion fruit.", 10);
		p.setId(4);
		products.add(p);
	}

	public List<Product> getAllProduct() {
		return products;
	}

	public Product getProduct(int id) {
		for (Product product : products) {
			System.out.println(product.getId());
			if (product.getId() == id) {
				System.out.println("TRUE");
				return product;
			}
		}
		System.out.println("FALSE");
		return null;
	}

	public void addNewProduct(Product item) {
		item.setId(products.size());
		products.add(item);
	}

	public void editProduct(int productId, Product item) {
//		item.setId(productId);
//		products.set(productId, item);
		for (int i = 0; i < products.size(); i++) {
			Product element = products.get(i);
			if (element.getId() == productId) {
				item.setId(productId);
				products.set(i, item);
			}
		}
	}

	public void deleteProduct(int productId) {
		for (int i = 0; i < products.size(); i++) {
			Product element = products.get(i);
			if (element.getId() == productId) {
				products.remove(i);
			}
		}
	}

	public void addOrder(OrderDetail item) {
		List<OrderDetail> items = new ArrayList<>();
		List<Object> groupOrders = new ArrayList<>();
		String customerId = item.getCustomerId();
		if (customers.containsKey(customerId)) {
			items = orderDetails.get("orderDetails");

			item.setId(items.size());

			Order order = item.setOrder(customerId);
			order.setOrderNum(items.size() + 1);

			item.setProduct(getProduct(item.getProductId()));

			items.add(item);

			orders.put("order", order);
			orderDetails.put("orderDetails", items);

			groupOrders.add(orders);
			groupOrders.add(orderDetails);

			customers.put(customerId, groupOrders);
		} else {
			item.setId(0);

			Order order = item.setOrder(customerId);
			order.setOrderNum(1);

			item.setProduct(getProduct(item.getProductId()));
			items.add(item);

			orders.put("order", order);
			orderDetails.put("orderDetails", items);

			groupOrders.add(orders);
			groupOrders.add(orderDetails);

			customers.put(customerId, groupOrders);
		}
	}

	public Map<String, List<Object>> getOrder() {
		return customers;
	}

}