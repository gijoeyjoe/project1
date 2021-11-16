package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.dao.ReDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.model.Reimburse;
import com.revature.model.Userz;

public class Servicer 
{
	public static final Logger log = Logger.getLogger(Servicer.class);
	
	private UserDaoImpl uDao;
	private ReDaoImpl reDao;
	
	public Servicer() {}
	
	public Servicer(UserDaoImpl uDao) { super(); this.uDao = uDao; }
	public Servicer(ReDaoImpl reDao) { super(); this.reDao = reDao; }
	
	
		
	
		public Userz getUserVerify(String name, String pass)
		{
			Userz user1 = uDao.getByName(name);
			
			if(user1 != null)
			{
				
				if(user1.getPassWord().equals(pass))
				{
					log.info(user1.getUserName() + " Logged in");
					return user1;
				}
			}
			else
			
			log.info(" User Not Found Log in Failed");
			return null;
			
		}

		
		
		
		
		
		public List<Reimburse> returnReimb(String userName)
		{			
			List<Reimburse> reList = reDao.getAllReimb(userName);
			
			if(reList != null)
			{
				log.info( "Reimbursement found for user: "+userName);
				return reList;
			}
			else
			{
				log.info(" No Reimbursement found for user: " + userName);
				return null;
			}
			
		}
		
		
		
		
		public List<Reimburse> returnReimbAll()
		{	
			List<Reimburse> reList = reDao.getAllReimbResolv();
			
			if(reList != null)
			{
				log.info("List Found for Resolver");
				return reList;
			}
			else
			{
				log.info("List Not Found for Resolver");
				return null;
			}
			
		}
		
		
		
		public void insertReimburseServ(Reimburse reImb)
		{
			reDao.insertNewTicket(reImb);
			log.info("New Reimbursement creteed by: "+ reImb.getReAuthorUN());
		}
		
		
		public void updateReimbServ(Reimburse reImb)
		{
			
			boolean checker = reDao.reUpdate(reImb);
		
			if (checker == true)
			{	
				log.info("Ticket Status Updated by: "+ reImb.getReResolverUN());
			}
			else
			{
				log.error("Ticket Number: "+ reImb.getReId() + "Not Found");
			}
		}
		
}
