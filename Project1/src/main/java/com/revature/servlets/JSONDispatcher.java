package com.revature.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.UserController;
import com.revature.model.Userz;

public class JSONDispatcher 
{
	public static void process(HttpServletRequest req, HttpServletResponse res) throws IOException
	{
		switch(req.getRequestURI())
		{
				// CASE FOR LOGIN
				// CASE FOR USER REIMBURSE VIEWS
				// CASE FOR ALL REIMBURSE FOR RESOLVERS VIEWS
				case "/Project1/getsessionuser.json":
					System.out.println("in get session user case dispatcher");
					UserController.getSessionUser(req, res);
					break;
				case "/Project1/getsessionreimb.json":
					System.out.println("in get session reimb case dispatcher");
					UserController.getSessionReimb(req, res);
					break;
				case "/Project1/getsessionreimbAll.json":
					System.out.println("in get session reimbAll case dispatcher");
					UserController.getSessionReimbAll(req, res);
					break;
				default:
					//	IF WRONG URI THEN PASS A BLANK VILLAIN OBJECT
						System.out.println("in JSON default");
						res.getWriter().write(new ObjectMapper().writeValueAsString(new Userz()));
		}
	}
}
