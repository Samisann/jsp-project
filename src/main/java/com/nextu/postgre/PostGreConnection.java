package com.nextu.postgre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostGreConnection {

	private final String url = "jdbc:postgresql://localhost/productDb";
	private final String userName = "root";
	private final String password = "root";
	
	

	
	private void connect()
	{
		try(Connection connection = DriverManager.getConnection(url, userName, password))
		{
			if(connection != null)
			{
				System.out.println("Connected to the database successfully");
			}else {
				System.out.println("Not connected to the database successfully");
			}
		}
		catch(SQLException error)
		{
			System.out.println(error);
			error.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		PostGreConnection connection	= new PostGreConnection();
		connection.connect();
	}
	
}
