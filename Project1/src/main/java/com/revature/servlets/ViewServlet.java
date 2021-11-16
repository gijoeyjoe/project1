package com.revature.servlets;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		//	CALL OUT VIEWDISPATCHER AND PROCESS OUT REQ
		// 	RETURNS BACK A REOURCE (PAGE OR SERVLET) 
		// 	THIS WILL THEN FORWARD TO NEXT PAGE IF LOGIN WAS GOOD OR BAD PAGE IF LOGIN FAILED
		req.getRequestDispatcher(ViewDispatcher.process(req));
		res.sendRedirect("html/index.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{	
		req.getRequestDispatcher(ViewDispatcher.process(req)).forward(req, res);
	}

}
