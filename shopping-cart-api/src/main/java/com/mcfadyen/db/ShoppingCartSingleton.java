package com.mcfadyen.db;

import java.util.HashMap;
import java.util.Map;

import com.mcfadyen.model.ShoppingCart;

/**
 * Basic singleton to simulate a repository for Shopping Carts
 * 
 * @author Daniel Kist
 */
public class ShoppingCartSingleton {
    
	private static final ShoppingCartSingleton INSTANCE = new ShoppingCartSingleton();
	
	private static final Map<String, ShoppingCart> map  = new HashMap<String, ShoppingCart>();
 
    private ShoppingCartSingleton() {}
 
    public static ShoppingCartSingleton getInstance() {
    	return INSTANCE;
    }
    
    public void put(String sessionId, ShoppingCart arg0) {
    	map.put(sessionId, arg0);
    }
    
    public ShoppingCart get(String sessionID) {
    	return map.get(sessionID);
    }
    
}
