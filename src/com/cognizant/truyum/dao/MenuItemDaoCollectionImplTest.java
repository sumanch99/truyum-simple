package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void testGetMenuItemListAdmin()
	{
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for(MenuItem m : menuItemList)
				System.out.println(m);
	}
	
	public static void testGetMenuItemListCustomer()
	{
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for(MenuItem m : menuItemList)
			System.out.println(m);
	}
	
	public static void testModifyMenuItem()
	{
		try {
			MenuItem m = new MenuItem(5,"Chocolate Brownie",32f,true,DateUtil.convertToDate("02/11/2020"),"Deserts",true);
			MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
			menuItemDao.modifyMenuItem(m);
			System.out.println(menuItemDao.getMenuItem(m.getId()));
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}

}
