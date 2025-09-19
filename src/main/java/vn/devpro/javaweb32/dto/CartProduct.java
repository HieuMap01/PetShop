package vn.devpro.javaweb32.dto;

import java.math.BigDecimal;
import java.math.BigInteger;

public class CartProduct {

	private int id;
	private String name;
	private BigDecimal price;
	private BigInteger quantity;
	private String avatar;

	public BigDecimal totalPrice() {
		return this.price.multiply(new BigDecimal(this.quantity));
	}

	public void updateQuantity(BigInteger aq) { // ad = additional Quatity
		this.quantity = this.quantity.add(aq);
	}

	public CartProduct() {
		super();
	}

	public CartProduct(int id, String name, BigDecimal price, BigInteger quatity, String avatar) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quatity;
		this.avatar = avatar;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigInteger getQuantity() {
		return quantity;
	}

	public void setQuantity(BigInteger quatity) {
		this.quantity = quatity;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
