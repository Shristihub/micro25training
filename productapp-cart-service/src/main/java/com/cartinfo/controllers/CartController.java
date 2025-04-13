package com.cartinfo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cartinfo.model.Cart;
import com.cartinfo.service.ICartService;

@RestController
@RequestMapping("/cart-service/v1")
public class CartController {
	
	@Autowired
	private ICartService cartService;
	
	@PostMapping("/cartInfo")
	public ResponseEntity<Cart> addToCart(@RequestParam int userId,@RequestParam int productId,@RequestParam int quantity){
		Cart cart = cartService.addToCart(userId,productId,quantity);
		return ResponseEntity.ok(cart);
	}
	

}
