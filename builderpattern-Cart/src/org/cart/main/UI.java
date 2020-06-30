package org.cart.main;

import java.util.List;
import java.util.Scanner;

import org.cart.model.Cart;
import org.cart.model.Product;
import org.cart.model.Products;

public class UI {

	Cart cart = new Cart();
	int ch = 0;

	public UI() {
		menu();
	}

	public void startScreen() {
		System.out.println("1. Display Store Products");
		System.out.println("2. Display Cart");
		System.out.println("0. Exit" + "\n");
	}

	public void storeProductsMenu() {
		System.out.println("1. Add to Cart");
		System.out.println("2. Remove From Cart");
		System.out.println("0. Exit" + "\n");
	}

	public void menu() {
		do {
			startScreen();
			getUserInput();

			switch (ch) {
			case 1:
				displayStoreProducts();
				storeProductsMenu();
				getUserInput();
				innerChoice1();
				break;
			case 2:
				showCart();
				break;
			case 0:
				System.exit(0);
				break;
			default:

				break;
			}
		} while (ch != 0);
	}

	private void innerChoice1() {
		switch (ch) {
		case 1:
			addProductToCart();
			showCart();
			break;
		case 2:
			removeProductFromCart();
			break;
		default:

			break;
		}
	}

	Scanner in = new Scanner(System.in);

	private int getUserInput() {

		ch = in.nextInt();

		return ch;
	}

	private void displayStoreProducts() {
		final List<Product> products = new Products().getProducts();
		for (final Product prod : products) {
			System.out.println(
					prod.getPid() + "- " + prod.getName() + " " + prod.getPrice() + " " + prod.getStock() + "\n");
		}
	}

	private void addProductToCart() {
		final int pid = getUserInput();
		cart.addProductToCartbyPID(pid);
	}

	private void showCart() {
		cart.printCartItems();
	}

	private void removeProductFromCart() {
		int pid = getUserInput();
		cart.removeProductsByPID(pid);
	}
}