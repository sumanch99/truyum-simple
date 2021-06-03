package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;

public class CartDaoCollectionImplTest {

	public static void testAddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1,3);
		cartDao.addCartItem(1,2);
		Cart cart = cartDao.getAllCartItems(1);
		System.out.println(cart);
	}
	
	public static void testGetAllCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		Cart cart = cartDao.getAllCartItems(1);
		System.out.println(cart);
	}
	
	public static void testRemoveCartItem()
	{
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1,3);
		cartDao.removeCartItem(1,2);
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
		} catch (CartEmptyException e) {
			e.printStackTrace();
		}
		//testRemoveCartItem();
	}

}
