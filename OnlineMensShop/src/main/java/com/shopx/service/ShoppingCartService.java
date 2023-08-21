package com.shopx.service;

import java.util.List;

import com.shopx.entities.ShoppingCart;

public interface ShoppingCartService {
	String addProductToCart(long userId, long prodId, int quantity);
	
	List<ShoppingCart> getCartDetails();
	
	double getTotalCartPrice(long userId);
	int getTotalCartItems(long userId);
	//	String deleteCart(long userId);
	String deleteCartContents(long userId);
}
