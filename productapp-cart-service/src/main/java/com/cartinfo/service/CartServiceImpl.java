package com.cartinfo.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cartinfo.feign.ProductInfoClient;
import com.cartinfo.model.Cart;
import com.cartinfo.model.CartItem;
import com.cartinfo.model.Product;
import com.cartinfo.repository.ICartRepository;

@Service
public class CartServiceImpl implements ICartService{
	@Autowired	
	private ProductInfoClient infoClient;
	@Autowired
	private ICartRepository cartRepository;
	@Autowired
	private ModelMapper mapper;
	
	

	@Override
	public Cart addToCart(int userId, int productId, int quantity) {
		// make an api call to check for product
		Product product = infoClient.getProductById(productId);
		System.out.println(product);
		if(product==null) {
			throw new RuntimeException("product not found");
		}
		// make an api call to check for user of userid exists
		//if user exists, check if it is in the cart table
		
		// if userId exists, then return the existing cart 
		Cart cart = cartRepository.findByUserId(userId)
				//create a new cart
				.orElseGet(()->{
					//create a new Cart
					Cart ncart = new Cart();
					//initialize a new list
					ncart.setCartItems(new ArrayList<>());
					return ncart;
				});
		System.out.println("----");
		System.out.println(cart);
		cart.setUserId(userId);
		
		CartItem item = new CartItem();
		item.setProductId(productId);
		item.setQuantity(quantity);
		item.setProductName(product.getProductName());
		item.setPrice(product.getPrice());
		item.setTotalPrice(quantity*item.getPrice());
		item.setCart(cart);
		System.out.println(item);
		// adding the new item to the cart
				cart.getCartItems().add(item);
				cart.calculateTotalPrice(); //total calculated in model
				System.out.println(cart);
				return cartRepository.save(cart);
		
	}

	@Override
	public void updateCart(int userId, int productId, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeFromCart(int userId, int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clearCart(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cart viewCart(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
