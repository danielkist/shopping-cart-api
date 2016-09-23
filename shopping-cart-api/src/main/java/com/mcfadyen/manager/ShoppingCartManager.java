package com.mcfadyen.manager;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcfadyen.model.CommerceItem;
import com.mcfadyen.model.Product;
import com.mcfadyen.model.ShoppingCart;
import com.mcfadyen.service.ProductService;
import com.mcfadyen.service.ShoppingCartService;

/**
 * @author Daniel Kist
 */
@Component
public class ShoppingCartManager {

	@Autowired ShoppingCartService shoppingCartService;
	@Autowired ProductService productService;
	
	public ShoppingCart get(String sessionID) throws Exception {
		validateSessionID(sessionID);
		return shoppingCartService.select(sessionID);
	}
	
	public CommerceItem addItem(String sessionID, String product_id, Integer quantity) throws Exception {
		validateSessionID(sessionID);
		
		ShoppingCart cart = get(sessionID);
		
		Product product = productService.selectById(product_id);
		if(product == null) throw new Exception("product.not.found");
		
		//TODO QUESTION:
		//If this cart already have this product, shoud I add another row (for auditing or pricing questions) or should I just add this new quantity to the existing row?
		CommerceItem item = new CommerceItem(UUID.randomUUID().toString(), product.getId(), quantity, product.getPrice().multiply(BigDecimal.valueOf(quantity)));
		cart.add(item);
		
		return item;
	}
	
	public void removeItem(String sessionID, String commerceItemId) throws Exception {
		validateSessionID(sessionID);
		ShoppingCart cart = get(sessionID);
		
		boolean updated = false;
		for(int i = 0; i < cart.getItems().size(); i++) {
			if(cart.getItems().get(i).getId().equals(commerceItemId)) {
				cart.getItems().remove(i);
				updated = true;
				break;
			}
		}
		
		//Confirm that one item was removed. If not, dispatch one Exception.
		if(updated) shoppingCartService.insert(sessionID, cart);
		else throw new Exception("item.not.found");
	}
	
	/*
	 * Security method.
	 * Main goal: validate the session ID
	 */
	private void validateSessionID(String sessionID) throws Exception {
		//Check if Authentication Token was informed
		if(sessionID == null) throw new Exception("not.authorized");
		
		//Check if Authentication Token is valid
		if(shoppingCartService.select(sessionID) == null) throw new Exception("shopping.cart.invalid");
	}

}
