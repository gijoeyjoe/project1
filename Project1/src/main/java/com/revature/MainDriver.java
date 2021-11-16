//package com.revature;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.revature.dao.DBConnect;
//import com.revature.dao.ReDaoImpl;
//import com.revature.dao.UserDaoImpl;
//import com.revature.model.Reimburse;
//import com.revature.model.Userz;
//import com.revature.service.Servicer;
//
//public class MainDriver 
//{
//
//	
//	public static void main (String[]  args)
//	
//	{
//		
////		DBConnect con = new DBConnect();
////		
//		UserDaoImpl uDao = new UserDaoImpl(con);
//		
//		Userz testUser = new Userz();
//		
//		testUser = uDao.getByName("jjve1");
//		
//		System.out.println(testUser);
//		
//		ReDaoImpl reDao = new ReDaoImpl(con);
//		
//		Servicer reServ = new Servicer(reDao);
//		
//		List<Reimburse> reList = new ArrayList<>();
//		reList = reServ.returnReimb("jjve1");
//		
//		System.out.println(reList);
		//( int reAmount,  String reDescript, String reAuthorUN,  String reType) 
		//ReDaoImpl reDao = new ReDaoImpl(con);
		//Reimburse testRe = new Reimburse(50,"Evening drinks with clients", "jjve1", "pending","other" );
		
	
		//reDao.insertNewTicket(testRe);
		
		package com.revature;

//		import org.apache.log4j.Level;
//		import org.apache.log4j.Logger;

//			RECORD RUNTIME INFO IN SEPERATE LOCATION, VIEW DATA AFTER SHUTDOWN

//			LOGGING LEVELS - DEGREE OF DETAIL 

//		 	LOWEST TO HIGHEST PRIORITY
//			ALL < TRACE < DEBUG < INFO < WARN < ERROR < FATAL < OFF

//			ALL - ALL LEVELS INCLUDED
//			TRACE - MACRO LEVEL INFO, MORE GENERAL THEN DEBUG
//			DEBUG - FINE GRAIN INFO NEEDED FOR DEBUGGING EFFORTS
//			INFO - INFO MESSAGES THAT HIGHLIGHT PROGRESS OF APP
//			WARN - POTENTIAL HARMFUL SITUATIONS THAT MERIT RECORD
//			ERROR - EXCEPTIONS / ERROR EVENTS, MAY ALLOW RECOVERY
//		 	FATAL - SERVER ERRORS LEAD TO ABORT
//			OFF - 	DOES NOT LOG
		public class MainDriver 
		{

//			public static final Logger log = Logger.getLogger(MainDriver.class);
//
//			public static void main(String[] args) 
//			{
//			//	 	DEFAULT LOG LEVEL IS DEBUG, LOGS LEVELS ABOVE IT
//				
//				log.setLevel(Level.DEBUG);
//				
//				//	MESSAGE OR INFO RECORED AT TRACE LEVEL
//				log.trace("Ray Tracing");
//				
//				//
//				log.debug("Squishing the Bugs");
//				
//				//
//				log.info("It is a Secret Info");
//				
//				//
//				log.warn("It is dangerous to go alone, take this");
//				
//				//
//				log.error("That's a big no, no");
//			
//				//
//				log.fatal("Pineapple on pizza");
////				
//				
//				LogHelper lHelp = new LogHelper();
//				
//				lHelp.callStaticLogger();
//				lHelp.callInstanceLogger();
//
//			}

		
		
		
	}
	
	