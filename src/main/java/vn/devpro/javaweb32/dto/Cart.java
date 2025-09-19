package vn.devpro.javaweb32.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Cart {

	private List<CartProduct> cartProducts = new ArrayList<CartProduct>();

	public int findById(int id) {
		for (int index = 0; index < cartProducts.size(); index++) {
			if (cartProducts.get(index).getId() == id) {
				return index; // có ở vị trí có chỉ số index
			}
		}
		return -1; // không có
	}

	public BigDecimal totalCartPrice() {
		BigDecimal total = BigDecimal.ZERO;
		for (CartProduct cartProduct : this.cartProducts) {
			total = total.add(cartProduct.totalPrice());
		}
		return total;
	}

	public Cart() {
		super();
	}

	public Cart(List<CartProduct> cartProducts) {
		super();
		this.cartProducts = cartProducts;
	}

	public List<CartProduct> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<CartProduct> cartProducts) {
		this.cartProducts = cartProducts;
	}

}
