package com.mcfadyen.service;

import org.springframework.stereotype.Service;

import com.mcfadyen.db.ShoppingCartSingleton;
import com.mcfadyen.model.ShoppingCart;

/**
 * @author Daniel Kist
 */
@Service
public class ShoppingCartService {
	
	//Simulate access to DataBase ou another service.
	ShoppingCartSingleton db = ShoppingCartSingleton.getInstance();
	
	public void insert(String sessionID, ShoppingCart cart) {
		db.put(sessionID, cart);
	}
	
	public ShoppingCart select(String sessionID) {
		ShoppingCart cart = db.get(sessionID);
		
		//If cart doesn't exists, create one
		if(cart == null) {
			System.out.println("Creating Empty Cart");
			cart = new ShoppingCart();
			insert(sessionID, cart);
		}
		return cart;
	}

}
