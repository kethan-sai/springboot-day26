package org.cart.model;

import java.util.ArrayList;
import java.util.List;

public class Products {

	private final List<Product> products = new ArrayList<>();

	public List<Product> getProducts() {
		return products;
	}

	public Products() {
		initStoreItems();
	}

	public void initStoreItems() {
		final String[] productNames = { "Lux Soap", "Fair n Lovely", "MTR" };
		final Double[] productPrice = { 40.00d, 60.00d, 30.00d };
		final Integer[] stock = { 10, 6, 10 };

		for (int i = 0; i < productNames.length; i++) {
			final Product pr = new Product.ProductBuilder(i + 1, productNames[i], productPrice[i], stock[i]).build();
			products.add(pr);
		}
	}
}
