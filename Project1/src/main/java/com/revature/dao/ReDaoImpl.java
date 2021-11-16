package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Reimburse;

public class ReDaoImpl implements GenericDaoRe<Reimburse>
{
	
	private DBConnect reDbConnect;
	
	public ReDaoImpl() { }
	
	// CONNECTION DEPENDENCY
	public ReDaoImpl(DBConnect reDbConnect) { this.reDbConnect = reDbConnect; }

	
	
	
	
	@Override
	public void insertNewTicket(Reimburse entity) 
	{
		try(Connection con = reDbConnect.getDBConnection())
		{
			 
			String sql = "{?= call insert_reimb(?,?,?,?)}";
			CallableStatement cs = con.prepareCall(sql);
			
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, entity.getReAmount());
			cs.setString(3, entity.getReDescript());
			cs.setString(4, entity.getReAuthorUN());
			cs.setString(5, entity.getReType());
			
			cs.execute();
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	public List<Reimburse> getAllReimb(String userName)
	{	
		System.out.println("hit dao 1st");
		
		List<Reimburse> reList = new ArrayList<>();
		
		try(Connection con = reDbConnect.getDBConnection())
		{
			 
			String sql = "select * from reimbursement r left outer join userz u on r.re_author = u.user_name where u.user_name = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setString(1, userName);
			
			ResultSet rs = ps.executeQuery();

			
				while(rs.next())
				{   System.out.println(rs.getTimestamp(2));
					// int reId, Timestamp reSubmitted, String reResolverUN, String reStatus, String reType
					reList.add(new Reimburse( rs.getInt(1), rs.getTimestamp(2), rs.getString(7), rs.getString(8), rs.getString(9)) );
				//reList.add(new ( rs.getNString(1), rs.getNString(2), rs.getString(7), rs.getString(8), rs.getString(9)) );
				}
			
		  System.out.println(reList);
			return reList;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}	
	
	
	
	
	public List<Reimburse> getAllReimbResolv()
	{	
		System.out.println("hit dao 1st");
		
		List<Reimburse> reList = new ArrayList<>();
		
		try(Connection con = reDbConnect.getDBConnection())
		{
			 
			String sql = "select * from reimbursement r left outer join userz u on r.re_author = u.user_name;";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();

				while(rs.next())
				{   System.out.println(rs.getTimestamp(2));
				                               //int reId,     Timestamp reSubmitted, int reAmount, String reDescript, String reAuthorUN, String reResolverUN, String reStatus, String reType)
					reList.add(new Reimburse( rs.getInt(1), rs.getTimestamp(2), rs.getInt(3), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9) ) );
				}
			
		  System.out.println(reList);
			return reList;
			
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}	
	
	
	
	
	
	public boolean reUpdate(Reimburse info)
	{
		
		try(Connection con = reDbConnect.getDBConnection())
		{
			 
			String sql = "select * from reimbursement r where re_id = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, info.getReId());
			ResultSet rs = ps.executeQuery();
			
			if (rs.next() == false) 
			{
				return false;
			}	
			else
			{	
			sql = "update reimbursement set re_status = ?, re_resolver = ?, re_resolved = current_timestamp where re_id = ?";
			PreparedStatement ps2 = con.prepareStatement(sql);
			ps2.setString(1, info.getReStatus());
			ps2.setString(2, info.getReResolverUN());
			ps2.setInt(3, info.getReId());
			ps2.execute();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return true;
	}	
	
	

}
