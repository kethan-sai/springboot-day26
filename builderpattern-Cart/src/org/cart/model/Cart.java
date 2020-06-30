package org.cart.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	List<Product> cart = new ArrayList<Product>();

	public void addProductToCartbyPID(int pid) {
		final Product product = getProductbyPID(pid);
		addToCart(product);
	}

	private Product getProductbyPID(int pid) {
		Product product = null;
		final List<Product> products = new Products().getProducts();
		for (final Product prod : products) {
			if ((prod.getPid()).equals(pid)) {
				product = prod;
				break;
			}
		}
		return product;
	}

	private void addToCart(Product product) {
		cart.add(product);
	}

	public void removeProductsByPID(int pid) {
		final Product prod = getProductbyPID(pid);
		cart.remove(prod);
	}

	public void printCartItems() {
		for (final Product prod : cart) {
			System.out.println(prod.getName());
		}
	}
}
