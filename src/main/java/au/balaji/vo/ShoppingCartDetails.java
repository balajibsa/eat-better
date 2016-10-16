package au.balaji.vo;

import java.math.BigDecimal;
import java.util.List;

import au.balaji.entity.Product;

public class ShoppingCartDetails {

	private List<Product> products;

	private BigDecimal totalPrice = new BigDecimal("0");

	public BigDecimal getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
