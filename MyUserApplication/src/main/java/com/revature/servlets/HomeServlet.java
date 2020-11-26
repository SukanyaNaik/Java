package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public void init() throws ServletException {

		System.out.println(this.getServletName() + " INSTANTIATED!");
		super.init();
	}
		
	// we will ALSO use a doPost method here....but we will take in different parameters
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
		throws ServletException, IOException {
		
		PrintWriter out = res.getWriter();
		res.setCharacterEncoding("text/html");
		out.println(req.getAttribute("message") );
		
	}
	
	
	public void destroy() {
		
		System.out.println(this.getServletName() + " DESTROYED!");
		super.destroy();
		// we will also close our connection
	}

}
