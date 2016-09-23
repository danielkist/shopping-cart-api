package com.mcfadyen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mcfadyen.db.ShoppingCartSingleton;
import com.mcfadyen.model.ShoppingCart;

/**
 * Main class
 * @author Daniel Kist
 */
@SpringBootApplication
public class ShoppingCartApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApiApplication.class, args);
		
		//Create two empty carts for testing. This was necessary because shopping cart operations demand a Session Token 
		ShoppingCartSingleton.getInstance().put("cart-1-062c1ec1-c03f-4e6d-b459-c13fd4832d85", new ShoppingCart());
		ShoppingCartSingleton.getInstance().put("cart-2-898ef378-f6eb-4c3a-be6f-5c8f45fd9977", new ShoppingCart());
	}
}
