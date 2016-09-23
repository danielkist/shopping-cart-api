package com.mcfadyen.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mcfadyen.manager.ProductManager;
import com.mcfadyen.model.Product;

/**
 * Controller for Product endpoints
 * @author Daniel Kist
 */
@RestController
public class ProductController {
	
	@Autowired ProductManager manager;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Product> list() {
		return manager.list();
    }

}
