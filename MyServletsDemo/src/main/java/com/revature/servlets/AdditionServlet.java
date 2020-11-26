package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdditionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void init() throws ServletException {
		System.out.println(this.getServletName() + " is instantiated");
		super.init();
	}

	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		System.out.println(this.getServletName() + " Service method called.");
		
		/* 
		 * In order to create a response to send back to the browser / client,
		 * we must write to it. The way we write the response is it's own printWriter obj.
		 */
		
		if(req.getParameter("number1") != null && req.getParameter("number2") != null) {
			int no1 = Integer.parseInt(req.getParameter("number1"));
			int no2 = Integer.parseInt(req.getParameter("number2"));
			int sum = no1 + no2;

			PrintWriter out = res.getWriter(); // Any data written in the print writer object is sent back to the browser.

			out.println("The sum is - " + sum);
		}
		
	}
	
	public void destroy() {
		System.out.println(this.getServletName() + " destroy method called!");
		super.destroy();
	}
}
