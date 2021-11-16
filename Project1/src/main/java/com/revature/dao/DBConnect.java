package com.revature.dao;

	import java.io.IOException;
	import java.io.InputStream;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.Properties;

//		CLASS PURPOSE CREATES CONNECTIONS TO DB
//		ELIMINATE REPEAT CODE

//		HELPS MAKE CODE MORE TESTABLE
//	 	MAINDRIVER HARD TO TEST
	public class DBConnect 
	{
		//	HIDING CREDENTIALS
		ClassLoader classLoader = getClass().getClassLoader();
		
		InputStream is;
		Properties p = new Properties();
		
		public DBConnect()
		{
			is = classLoader.getResourceAsStream("connection.properties");
			try 
			{
				p.load(is);
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		//	MAKE SURE DAO HANDLES EXCEPTIONS, SO THIS THROWS EXCEPTION TO CALLER
		public Connection getDBConnection() throws SQLException
		{
			final String URL = p.getProperty("url");
			final String USERNAME = p.getProperty("username");
			final String PASSWORD = p.getProperty("password");
					
			try 
			{
		       Class.forName("org.postgresql.Driver");
		    } 
			catch(ClassNotFoundException e) 
			{
		       //handle logic
		    }
			 
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} 

}
