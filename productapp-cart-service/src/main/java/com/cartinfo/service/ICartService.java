package com.cartinfo.service;

import com.cartinfo.model.Cart;
import com.cartinfo.model.CartItemDTO;

public interface ICartService {
	
	Cart addToCart(int userId, int productId, int quantity);
	void updateCart(int userId,int productId,int quantity);
	void removeFromCart(int userId,int productId);
	Cart viewCart(int userId);
	void clearCart(int userId);
}
