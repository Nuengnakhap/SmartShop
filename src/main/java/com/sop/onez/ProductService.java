package com.sop.onez;

import java.util.ArrayList;
import java.util.List;

public class ProductService {

	static List<Product> products = new ArrayList<Product>();

	public ProductService() {
		products.add(
			new Product(
					"FLAPPER VEGETABLE MIX DELIGHTS 70 GM",
					"Vegetable chips are chips or crisps that are prepared using vegetables. Vegetable chips may be fried, deep-fried, dehydrated, dried or baked. Many various root vegetables or leaf vegetables are used.",
					10
				)
		);
		products.add(
			new Product(
					"NICK SNACKS BABY APPLE STARS 30 GM",
					"Freshly baked cookies are the stuff of childhood dreams, help the kids make their own with these simple.", 
					10
				)
		);
		products.add(
			new Product(
					"CHI ORGANIC VIRGIN COCONUT OIL 200 ML",
					"Chi 100% Organic Virgin coconut oil is never heated.", 
					10
				)
		);
		products.add(
			new Product(
					"LA CUERVA BLACKBERRIES 300 GM",
					"The blackberry is an aggregate fruit that.The fruit is very dark purple with smooth, fragile skin. In the center of the cluster is a greenish-white core that extends to almost the bottom of the berry. Blackberries are red and hard when they are immature and turn black and shiny when they ripen.", 
					10
				)
		);
		products.add(
			new Product(
					"COCOMOJO PASSION PURE COCONUT WATER DRINK 250 ML",
					"A delightful and delicious pure coconut water drink blended with a burst of passion fruit.", 
					10
				)
		);
	}
	
	public List<Product> getAllProduct() {
		return products;
	}
	
	public void addNewProduct(Product item) {
		products.add(item);
	}

}