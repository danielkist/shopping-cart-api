package com.mcfadyen.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcfadyen.model.Product;
import com.mcfadyen.service.ProductService;

/**
 * ProductManager
 * @author Daniel Kist
 */
@Component
public class ProductManager {

	@Autowired ProductService service;
	
	public List<Product> list() {
		return service.selectAll();
	}

}
