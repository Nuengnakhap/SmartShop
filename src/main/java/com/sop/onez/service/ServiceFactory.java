package com.sop.onez.service;

public class ServiceFactory {
	
	private static ServiceFactory instance;
	
	public static ServiceFactory getInstanse() {
		if (instance == null) {
            instance = new ServiceFactory();
        }
        return instance;
	}

	public Services getService(String service) {
		if (service == null) {
			return null;
		} else if (service.equalsIgnoreCase("ORDER")) {
			return new OrderService();
		} else if (service.equalsIgnoreCase("PRODUCT")) {
			return new ProductService();
		} 
		return null;
	}
	
}
