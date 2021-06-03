package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandler {

	private static Connection con = null;
	private static Properties props = new Properties();

	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {

		FileInputStream fis = null;
		
		fis = new FileInputStream("C:\\Users\\USER\\eclipse-workspace\\truYum\\src\\connection.properties");
		props.load(fis);

			// load the Driver Class
		Class.forName(props.getProperty("driver"));

			// create the connection now
		con = DriverManager.getConnection(props.getProperty("connection-url"), props.getProperty("user"),
		props.getProperty("password"));

		return con;
	}
	
	/*public static void main(String []args)
	{
		Connection con=null;
		try {
			con = ConnectionHandler.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(con!=null)
			System.out.println("Connected");
		else
			System.out.println("Failed");
	}*/
}
