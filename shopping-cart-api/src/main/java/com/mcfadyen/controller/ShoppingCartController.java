package com.mcfadyen.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;

import com.mcfadyen.manager.ShoppingCartManager;
import com.mcfadyen.model.CommerceItem;
import com.mcfadyen.model.ShoppingCart;

/**
 * Controller for Shopping Cart endpoints
 * @author Daniel Kist
 */
@RestController
public class ShoppingCartController {
	
	@Autowired HttpServletRequest  request;
	@Autowired ShoppingCartManager manager;
	
	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ShoppingCart get() throws Exception {
		return manager.get(getAuthorization());
    }
	
	@RequestMapping(value = "/shoppingcart/items/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void delete(@PathVariable String id) throws Exception {
		manager.removeItem(getAuthorization(), id);
    }
	
	@RequestMapping(value = "/shoppingcart/items", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CommerceItem postJson(String product_id, Integer quantity) throws Exception {
		return manager.addItem(getAuthorization(), product_id, quantity);
    }
	
	//Retrive SessionID or Authorization Header
	private String getAuthorization() {
		String auth = request.getHeader("Authorization");
		if(auth == null) auth = RequestContextHolder.currentRequestAttributes().getSessionId();
		return auth;
	}

}
