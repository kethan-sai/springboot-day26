package org.cart.model;

public class Product {
	private final Integer pid;
	private final String name;
	private final Double price;
	private final Integer stock;

	public Product(ProductBuilder pb) {
		pid = pb.pid;
		name = pb.name;
		price = pb.price;
		stock = pb.stock;
	}

	public Integer getPid() {
		return pid;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public Integer getStock() {
		return stock;
	}

	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", price=" + price + ", stock=" + stock + "]";
	}

	public static class ProductBuilder {
		private final Integer pid;
		private final String name;
		private final Double price;
		private final Integer stock;

		public ProductBuilder(Integer pid, String name, Double price, Integer stock) {
			this.pid = pid;
			this.name = name;
			this.price = price;
			this.stock = stock;
		}

		public Product build() {
			final Product pr = new Product(this);
			validate(pr);
			return pr;
		}

		private void validate(Product product) {
			try {
				if (product.pid == null || product.name == null || product.price == null || product.stock == null) {

				}
			} catch (final Exception e) {
				e.printStackTrace();
			}

		}
	}
}
