package com.mcfadyen.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcfadyen.db.ProductSingleton;
import com.mcfadyen.model.Product;

/**
 * @author Daniel Kist
 */
@Service
public class ProductService {
	
	//Simulate access to DataBase ou another service.
	ProductSingleton db = ProductSingleton.getInstance();
	
	public List<Product> selectAll() {
		return db.getAll();
	}
	
	public Product selectById(String id) {
		return db.get(id);
	}

}
