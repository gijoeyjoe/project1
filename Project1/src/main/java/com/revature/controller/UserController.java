package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.DBConnect;
import com.revature.dao.ReDaoImpl;
import com.revature.dao.UserDaoImpl;
import com.revature.model.Reimburse;
import com.revature.model.Userz;
import com.revature.service.Servicer;

public class UserController 
{
	public static final Logger log = Logger.getLogger(UserController.class);
	
	static DBConnect con = new DBConnect();
	static Servicer uServ = new Servicer( new UserDaoImpl(con));
	static Servicer reServ = new Servicer( new ReDaoImpl(con));
	public static String login(HttpServletRequest req)
	{
				// checks that you should not use GET 
				// all login should be done as POST
				System.out.println("in controller login");
				if(!req.getMethod().equals("POST")) 
				{
					return "html/index.html";
				}
				//System.out.println(req.getParameter("usernamex"));
				//System.out.println(req.getParameter("passwordx"));
				// GET NAME AND PASSWORD VALUES FROM LOGIN PAGE - NAME ATTRIBUTE ON FORM
				//	GET-USER-VERIFY IN SERVICE LAYER TO CHECK USER NAME AND PASSWORD MATCH IN DB
				Userz user1 = uServ.getUserVerify(req.getParameter("usernamex"), req.getParameter("passwordx"));
				
				if(user1== null) 
				{	//	 GOES THROUGHT SERVLET PATH AND TERMINATED AT DISPATCHER BY SENDING BAD LOGIN PAGE
					log.info("Login Service Returned Null User, User Name DNE");
					return "wrongcreds.change";
					
				}
				else if (user1.getUserRole().equals("employee"))
				{
					log.info("Login Service Found Employee User:" + user1.getUserName());
					log.info("Login User Saved to Session: " + user1.getUserName());
					req.getSession().setAttribute("currentUser", user1);
					return "html/home.html";
				}
				else if (user1.getUserRole().equals("resolver"))
				{
					log.info("Login User Saved to Session: " + user1.getUserName() );
					log.info("Login Service Found Resolver User:" + user1.getUserName());
					req.getSession().setAttribute("currentUser", user1);
					return "html/resolv.html";
				}
				else 
				{
					return "wrongcreds.change";
				}
		}
	
	
	
	public static void getSessionUser(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException 
	{
		//	CASTS A USER FROM SESSION SAVED AT LOGIN UNDER KEY NAME currentVill
		Userz user = (Userz)req.getSession().getAttribute("currentUser");
		//	RESPONSE OBJECT TO SEND CURRENT LOGGED USER  AS JASON TO FRONT END
		res.getWriter().write(new ObjectMapper().writeValueAsString(user));
		log.info("Session Returned Current User" + user.getUserName());

			
	}
	
	
	public static void getSessionReimb(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException 
	{
		
		Userz user = (Userz)req.getSession().getAttribute("currentUser");
		String user1 = user.getUserName();
		
		List<Reimburse> reList = new ArrayList<>();
		reList = reServ.returnReimb(user1);
		
		if ( reList ==  null )
		{
			res.getWriter().write(new ObjectMapper().writeValueAsString(new Reimburse()));	
		}
		else
		{
			req.getSession().setAttribute("currentReimb", reList);
			System.out.println("reache reimbure session controll");
			
			@SuppressWarnings("unchecked")
			List<Reimburse> reList2  = (List<Reimburse>)req.getSession().getAttribute("currentReimb");
			//	RESPONSE OBJECT TO SEND CURRENT LOGGED USER  AS JASON TO FRONT END
			res.getWriter().write(new ObjectMapper().writeValueAsString(reList2));
		}
		
	}
	
	
	
	
	@SuppressWarnings("unchecked")
	public static void getSessionReimbAll(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException 
	{
	
		Userz user = (Userz)req.getSession().getAttribute("currentUser");
		List<Reimburse> reList = new ArrayList<>();
		reList = reServ.returnReimbAll();
		
		if ( reList ==  null )
		{
			res.getWriter().write(new ObjectMapper().writeValueAsString(new Reimburse()));	
		}
		else
		{
			req.getSession().setAttribute("currentReimb", reList);
			System.out.println("reache reimbure session controll");
			
	
			List<Reimburse> reList2  = (List<Reimburse>)req.getSession().getAttribute("currentReimb");
			//	RESPONSE OBJECT TO SEND CURRENT LOGGED USER  AS JASON TO FRONT END
			res.getWriter().write(new ObjectMapper().writeValueAsString(reList2));
	
		}
		
	}
	
	
	public static void postReimburse (HttpServletRequest req)
	{
		
		Userz user = (Userz)req.getSession().getAttribute("currentUser");
		String user1 = user.getUserName();
		
		Reimburse reInput = new Reimburse();
		reInput.setReAuthorUN(user1);
		reInput.setReAmount(Integer.parseInt(req.getParameter("amountInput")));
		reInput.setReDescript(req.getParameter("textA1"));
		reInput.setReType(req.getParameter("gridRadios"));
		
		reServ.insertReimburseServ(reInput);
		
		
	}
	
	
	public static void updateReServ (HttpServletRequest req)
	{
		Userz user = (Userz)req.getSession().getAttribute("currentUser");
		String user1 = user.getUserName();
		
		Reimburse reInput = new Reimburse();
		reInput.setReResolverUN(user1);
		reInput.setReId(Integer.parseInt(req.getParameter("inputid")));
		reInput.setReStatus(req.getParameter("gridRadios"));
		System.out.println(req.getParameter("gridRadios"));
		reServ.updateReimbServ(reInput);
		
	}
	
	
	public static void logOut(HttpServletRequest req)
	{
		HttpSession sess = req.getSession();
		sess.removeAttribute("currentUser");
		sess.removeAttribute("currentReimb");
		System.out.println("log out controller");
		sess.invalidate();
	}
 
}
