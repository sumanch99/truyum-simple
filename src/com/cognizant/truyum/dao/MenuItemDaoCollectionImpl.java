package com.cognizant.truyum.dao;

import java.util.List;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import com.cognizant.truyum.util.DateUtil;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;
	
	public MenuItemDaoCollectionImpl() {
		if (menuItemList == null) {
			
			List<MenuItem> obj = new ArrayList<>();
			try {
				obj.add(new MenuItem(1,"Sandwich",99f,true,DateUtil.convertToDate("15/03/2017"),"Main Course",false));
				obj.add(new MenuItem(2,"Burger",129f,true,DateUtil.convertToDate("23/12/2017"),"Main Course",false));
				obj.add(new MenuItem(3,"Pizza",149f,true,DateUtil.convertToDate("21/08/2018"),"Main Course",false));
				obj.add(new MenuItem(4,"French Fries",57f,false,DateUtil.convertToDate("02/07/2017"),"Startes",true));
				obj.add(new MenuItem(5,"Chocolate Brownie",32f,true,DateUtil.convertToDate("02/11/2022"),"Deserts",true));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}

			menuItemList=obj;
		}
	}
	
	
	
	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}
	
	@Override
	public List<MenuItem> getMenuItemListCustomer()
	{
		List<MenuItem> obj = new ArrayList<>();
		
		for(MenuItem m : menuItemList)
		{
			if(m.getDateOflaunch().getTime() <= new Date().getTime() && m.getActive())
			{
				obj.add(m);
			}
		}
		return obj;	
	}
	
	@Override
	public void modifyMenuItem(MenuItem menuItem)
	{
		for(MenuItem m : menuItemList)
		{
			if(m.getId()==menuItem.getId())
			{
				m.setName(menuItem.getName());
				m.setPrice(menuItem.getPrice());
				m.setActive(menuItem.getActive());
				m.setDateOflaunch(menuItem.getDateOflaunch());
				m.setCategory(menuItem.getCategory());
				m.setActive(menuItem.getActive());
				return;
			}
		}
	}
	
	@Override
	public MenuItem getMenuItem(long menuItemId)
	{
		for(MenuItem m : menuItemList)
		{
			if(m.getId()==menuItemId)
			{
				return m;
			}
		}
		return null;
	}

}
