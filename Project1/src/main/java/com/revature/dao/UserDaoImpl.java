package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.model.Userz;

public class UserDaoImpl implements GenericDao<Userz>
{

	private DBConnect reDbConnect;

	public UserDaoImpl() { }
	
	// CONNECTION DEPENDENCY
	public UserDaoImpl(DBConnect reDbConnect) { this.reDbConnect = reDbConnect; }
	
	

	//	CHECK USER NAME EXISTS IN DB
	//	IF SO RETURNS A USER OBJECT WITH CONTENTS OF ROW
	@Override
	public Userz getByName(String userName)
	{
		Userz client = new Userz();

		try (Connection con = reDbConnect.getDBConnection())
		{
			String sql = "select * from userz where user_name= ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			
			ResultSet rs = ps.executeQuery();

			if (rs.next() == false) 
			{
				return null;
			}	
			else
			{
			//rs.next();
			// jjve1	password	joey	vel	joejoe@hotmail.com	employee
			client = new Userz(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6) );
			return client;
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return client;

	}

	
}
