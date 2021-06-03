package com.cognizant.truyum.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<Long,Cart> userCarts;
	
	public CartDaoCollectionImpl() {
		if(userCarts==null) {
			userCarts = new HashMap<Long,Cart>();
		}
	}
	
	@Override
	public void addCartItem(long userId, long menuItemId) {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem m = menuItemDao.getMenuItem(menuItemId);
		ArrayList<MenuItem> mList = new ArrayList<>();
		if (userCarts.containsKey(userId)) {
			userCarts.get(userId).getMenuItemList().add(m);
		} else {
			mList.add(m);
			Cart c = new Cart(mList);
			userCarts.put(userId, c);
		}
	}


	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {
		if(userCarts.get(userId)==null)
		{
			throw new CartEmptyException();
		}
		List<MenuItem> menuListPerCustomer = userCarts.get(userId).getMenuItemList();
		if (menuListPerCustomer.isEmpty()) {
			throw new CartEmptyException();
		} else {
			double total = 0;
			for (MenuItem m : menuListPerCustomer) {
				total += m.getPrice();
			}
			userCarts.get(userId).setTotal(total);
		}
		return userCarts.get(userId);
	}
	
	@Override
	public void removeCartItem(long userId,long menuItemId)
	{
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		Iterator<MenuItem> itr = menuItemList.iterator();
		while(itr.hasNext())
		{
			MenuItem m = (MenuItem)itr.next();
			if(m.getId()==menuItemId)
				itr.remove();
		}
	}
}
