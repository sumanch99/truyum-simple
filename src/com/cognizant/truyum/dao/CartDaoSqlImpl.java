package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId) {
		String query = "INSERT INTO cart(ct_us_id,ct_pr_id) VALUES(?,?)";

		try (Connection con = ConnectionHandler.getConnection()) {
			// Fill your code here
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Cart getAllCartItems(long userId) throws CartEmptyException {

		ArrayList<MenuItem> menuItemList = new ArrayList<>();
		double totalAmount = 0;

		try (Connection con = ConnectionHandler.getConnection()) {

			String query = "SELECT * FROM menu_item WHERE me_id IN(SELECT ct_pr_id FROM cart WHERE ct_us_id=?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MenuItem m = new MenuItem(rs.getLong("me_id"), rs.getString("me_name"), rs.getFloat("me_price"),
						rs.getBoolean("me_active"), rs.getDate("me_date_of_launch"), rs.getString("me_category"),
						rs.getBoolean("me_free_Delivery"));
				menuItemList.add(m);

			}
			if (menuItemList.isEmpty()) {
				throw new CartEmptyException();
			}

			query = "SELECT SUM(me_price) AS total FROM menu_item WHERE me_id IN(SELECT ct_pr_id FROM cart WHERE ct_us_id=?)";
			ps = con.prepareStatement(query);
			ps.setLong(1, userId);
			rs = ps.executeQuery();
			while (rs.next()) {
				totalAmount = rs.getFloat("total");

			}
		} catch (SQLException | ClassNotFoundException | IOException  e) {
			e.printStackTrace();
		}
		Cart cart = new Cart(menuItemList, totalAmount);

		return cart;

	}


	@Override
	public void removeCartItem(long userId, long menuItemId) {

		String query = "DELETE FROM cart WHERE ct_us_id=? AND ct_pr_id=?";
		try (Connection con = ConnectionHandler.getConnection()) {
			// Fill your code here
			PreparedStatement ps = con.prepareStatement(query);
			ps.setLong(1, userId);
			ps.setLong(2, menuItemId);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
