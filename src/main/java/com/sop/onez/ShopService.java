package com.sop.onez;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sop.onez.model.Order;
import com.sop.onez.model.Product;

public class ShopService {

	static List<Product> products = new ArrayList<Product>();
	static Map<String, List<Object>> customers = new HashMap<>();
	static Map<String, Order> orders = new HashMap<>();
	static Map<String, List<OrderDetail>> orderDetails = new HashMap<>();

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