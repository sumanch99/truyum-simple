package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {
	
	public static void testGetMenuItemListAdmin() {
		
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();
		for(MenuItem m : menuItemList)
			System.out.println(m);
	}
	
	public static void testGetMenuItemListCustomer() {
		
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();
		for(MenuItem m : menuItemList)
			System.out.println(m);
	}
	
	public static void testModifyMenuItem() {
		try {
			MenuItem m = new MenuItem(5,"Chocolate Brownie",32f,true,new java.sql.Date(DateUtil.convertToDate("02/11/2020").getTime()),"Deserts",true);
			MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
			menuItemDao.modifyMenuItem(m);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	public static void testGetMenuItem() {
		
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(2);
		System.out.println(menuItem);
		
	}
	
	public static void main(String[] args) {
		
		//testGetMenuItemListAdmin();
		//testGetMenuItemListCustomer();
		//testModifyMenuItem();
		//testGetMenuItem();
		//testGetMenuItemListAdmin();
		//testGetMenuItemListCustomer();
	}

}
