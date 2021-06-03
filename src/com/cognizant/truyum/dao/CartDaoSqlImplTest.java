package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;

public class CartDaoSqlImplTest {
	
	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.addCartItem(1,1);
		Cart cart = cartDao.getAllCartItems(1);
		System.out.println(cart);
	}
	
	public static void testGetAllCartItems() throws CartEmptyException {
		
		CartDao cartDao = new CartDaoSqlImpl();
		Cart cart = cartDao.getAllCartItems(1);
		System.out.println(cart);
	}
	
	public static void testRemoveCartItem() {
		
		CartDao cartDao = new CartDaoSqlImpl();
		cartDao.removeCartItem(1,1);
		try {
			Cart cart = cartDao.getAllCartItems(1);
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		try {
			//testAddCartItem();
			testGetAllCartItems();
		} catch (CartEmptyException e) {e.printStackTrace();}
		//testRemoveCartItem();

	}
}
