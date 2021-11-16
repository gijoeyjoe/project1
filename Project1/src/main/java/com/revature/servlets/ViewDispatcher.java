package com.revature.servlets;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.UserController;

// #1 FROM HTML
public class ViewDispatcher 
{
	
	public static String process(HttpServletRequest req) 
	{
		
		switch(req.getRequestURI()) 
		{
		
		case "/Project1/login.change":
			System.out.println("in login.change dispatcher");
			// WE CAN CALL THIS METHOD BECAUSE HE USED A STATIC METHOD
			// WOULD NEED TO CREATE INSTANCE OBJECT OF CONTROLLER CLASS AND 
			return UserController.login(req);
			
		case "/Project1/submitRe.change":
			System.out.println("in submitRe.change dispatcher");
			UserController.postReimburse(req);
			return "html/home.html";
		case "/Project1/submitResolv.change":
			System.out.println("in submitRe.change dispatcher");
			UserController.updateReServ(req);
			return "html/resolv.html";
		case "/Project1/logOut.change":
			System.out.println("in logOut.change dispatcher");
			UserController.logOut(req);
		
		 default:
			 	System.out.println("in  default");
			 	return "html/badlogin.html";
		
		}
		
	}
	
}
