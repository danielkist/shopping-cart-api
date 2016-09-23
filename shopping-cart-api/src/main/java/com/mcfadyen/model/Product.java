package com.mcfadyen.model;

import java.math.BigDecimal;

/**
 * Product model
 * @author Daniel Kist
 */
public class Product {
	
	private String id;
	
	private String name;
	
	private String image;
	
	private BigDecimal price;
	
	public Product() {}
	
	public Product(String id, String name, String image, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.image = image;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
