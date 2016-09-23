package com.mcfadyen.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * ShoppingCart model
 * @author Daniel Kist
 */
public class ShoppingCart {
	
	private List<CommerceItem> items = new ArrayList<CommerceItem>();
	
	public void add(CommerceItem item) {
		this.items.add(item);
	}

	public List<CommerceItem> getItems() {
		return items;
	}

	public void setItems(List<CommerceItem> items) {
		this.items = items;
	}

	/*
	 * Amount is calculated on each request
	 * @return
	 */
	public BigDecimal getAmount() {
		return items.stream().map(i -> i.getAmount().multiply(BigDecimal.valueOf(i.getQuantity()))).reduce(BigDecimal.ZERO, BigDecimal::add);	
	}

}
