package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.List;
import com.cognizant.truyum.model.MenuItem;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	@Override
	public List<MenuItem> getMenuItemListAdmin()
	{
		List<MenuItem> menuItemList = new ArrayList<>();
		String query = "SELECT * FROM menu_item";
		try(Connection con = ConnectionHandler.getConnection()){
			// Fill your code here	
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				menuItemList.add(new MenuItem(rs.getInt("me_id"),rs.getString("me_name"),rs.getFloat("me_price"),rs.getBoolean("me_active"),rs.getDate("me_date_of_launch"),rs.getString("me_category"),rs.getBoolean("me_free_Delivery")));
			}
			
			}catch(Exception e){e.printStackTrace();}
		
		return menuItemList;
	}
	
	@Override
	public List<MenuItem> getMenuItemListCustomer()
	{
		List<MenuItem> menuItemList = new ArrayList<>();
		String query = "SELECT * FROM menu_item WHERE me_active=true AND me_date_of_launch<DATE(now());";
		try(Connection con = ConnectionHandler.getConnection()){
			// Fill your code here	
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				menuItemList.add(new MenuItem(rs.getInt("me_id"),rs.getString("me_name"),rs.getFloat("me_price"),rs.getBoolean("me_active"),rs.getDate("me_date_of_launch"),rs.getString("me_category"),rs.getBoolean("me_free_Delivery")));
			}
			
			}catch(Exception e){e.printStackTrace();}
		
		return menuItemList;
	}
	
	@Override
	public MenuItem getMenuItem(long menuItemId)
	{
		MenuItem menuItem=null;
		String query = "SELECT * FROM menu_item WHERE me_id=?";
		try(Connection con = ConnectionHandler.getConnection()){
			// Fill your code here	
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1,menuItemId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				menuItem = new MenuItem(rs.getInt("me_id"),rs.getString("me_name"),rs.getFloat("me_price"),rs.getBoolean("me_active"),rs.getDate("me_date_of_launch"),rs.getString("me_category"),rs.getBoolean("me_free_Delivery"));
			}
			}catch(Exception e){e.printStackTrace();}
		return menuItem;
	}
	
	@Override
	public void modifyMenuItem(MenuItem menuItem)
	{
		
		String query = "UPDATE menu_item SET me_name=?,me_price=?,me_active=?,me_date_of_launch=?,me_category=?,me_free_Delivery=? WHERE me_id=?";
		
		try(Connection con = ConnectionHandler.getConnection()){
			// Fill your code here
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setBoolean(3, menuItem.getActive());
			ps.setDate(4, (Date)menuItem.getDateOflaunch());
			ps.setString(5, menuItem.getCategory());
			ps.setBoolean(6, menuItem.getFreeDelivery());
			ps.setLong(7,menuItem.getId());
			
			ps.executeUpdate();

			}catch(Exception e){e.printStackTrace();}
	}
	
}
