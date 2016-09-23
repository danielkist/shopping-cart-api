package com.mcfadyen.model;

/**
 * Bean for add to cart endpoint
 * @author Daniel Kist
 */
public class ShoppingItemCart {

	private String product_id;
	
	private Integer quantity;

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}
