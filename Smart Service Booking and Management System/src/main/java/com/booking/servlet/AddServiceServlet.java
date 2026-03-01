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

/**
 * Servlet implementation class AddServiceServlet
 */
@WebServlet("/AddServiceServlet")
public class AddServiceServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("sname");
		String description = request.getParameter("description");
		int price = Integer.parseInt(request.getParameter("price"));
        int duration = Integer.parseInt(request.getParameter("duration"));
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection con = DBConnection .getconnection();
        try {
          	PreparedStatement pstmt = con.prepareStatement("insert into service (sname,description,price,duration) values (?,?,?,?)");
        	  pstmt.setString(1, name);
        	  pstmt.setString(2, description);
        	  pstmt.setInt(3, price);
        	  pstmt.setInt(4, duration); 	
        	int i = pstmt.executeUpdate();
        	  if(i>0)
             { 
        	     out.print("services added successfully");	
             }
             else {
        	 	 out.print("Something went wrong");
        	 }
        }
        catch(SQLException e)
        {
        	e.printStackTrace();
        }  
	}  

}
