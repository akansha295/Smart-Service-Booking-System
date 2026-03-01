package com.booking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.booking.connection.DBConnection;


@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("cname");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    Connection con = DBConnection.getconnection();
	    try {
	    	PreparedStatement pstmt = con.prepareStatement("insert into customer (cname,password,email) values(?,?,?)");
	    	pstmt.setString(1, name);
	    	pstmt.setString(2, password);
	    	pstmt.setString(3, email);
	    	int i = pstmt.executeUpdate(); 	
	    	if (i>0)
	    	{
	    	out.print("inserted successfully");
	    	}
	    	else {
	    		out.print("something went wrong");
	    	}
	    }
	    catch (SQLException e)
	    {
	    	e.printStackTrace();
	    }
	    
	        
		
	}

}
