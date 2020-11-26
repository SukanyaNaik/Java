package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// This class will extend HTTP Servlet
// HTTP Servlet extends Generic Servlet.

public class HelloWorldServlet extends HttpServlet{

	/*
	 * Servlets have 3 primary Methods
	 * 1. The first is Init(), Which is called to Instantiate the Servlet first, 
	 * it checks to see if this Servlet is already in existance before creating one.
	 * 
	 * (This is a Sinleton design pattern)
	 */
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException{ // A web container will look for init() method
		System.out.println(this.getServletName() + " is instantiated");
		super.init();
	}
	
	/*
	 * 2. The second method is the service() method.
	 * This is used for business logic 
	 * and populate the response that we send back to the client
	 */
	
	// This method can be called multiple times.
	protected void service(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		System.out.println(this.getServletName() + " Service method called.");
		
		/* 
		 * In order to create a response to send back to the browser / client,
		 * we must write to it. The way we write the response is it's own printWriter obj.
		 */
		
		res.setContentType("text/html"); // We are telling the browser what type of content is coming back.
		
		PrintWriter out = res.getWriter(); // Any data written in the print writer object is sent back to the browser.
		
		out.println("<h1> Hello World!</h1>");
		
		/*
		 * At the end of the service() method, the request and response are send back to the web container.
		 */
	}
	
	/*
	 * After a long time not being used, the web container will invoke the destroy() method on your servlet
	 */
	
	public void destroy() {
		
		System.out.println(this.getServletName() + " destroy method called!");
		super.destroy();
	}
}
