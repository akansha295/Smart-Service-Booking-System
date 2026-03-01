package com.booking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booking.connection.DBConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con = DBConnection.getconnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("Select * from customer where email=? and password=?");
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet res= pstmt.executeQuery();
			if (res.next())
			{
				HttpSession session = request.getSession(); 
				session.setAttribute("email", email);   //store user's email
				session.setAttribute("cid", res.getInt("cid")); //stores customer id
				response.sendRedirect("Dashboard.html");
		       // out.print("Login Successfully");
			}
			else {
				out.print("Invalid email or password");
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}

}
