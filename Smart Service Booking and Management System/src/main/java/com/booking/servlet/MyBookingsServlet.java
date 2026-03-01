package com.booking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.booking.connection.DBConnection;

@WebServlet("/MyBookingsServlet")
public class MyBookingsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("cid") == null) {
			response.sendRedirect("Login.html");
			return;
		}


		int cid = (int) session.getAttribute("cid");

		Connection con = DBConnection.getconnection();

		try {
		
			PreparedStatement pstmt = con.prepareStatement(
				"select b.bid, b.status, b.btime, b.bdate, s.sname " +
				"from booking b inner join service s on b.sid = s.sid " +
				"where b.cid = ?"
			);

			pstmt.setInt(1, cid);
			ResultSet res = pstmt.executeQuery();

			out.println("<h1>My Bookings</h1>");

			while (res.next()) {
				out.println("Booking ID: " + res.getInt("bid") + "<br>");
				out.println("Service: " + res.getString("sname") + "<br>");
				out.println("Status: " + res.getString("status") + "<br>");
				out.println("Time: " + res.getInt("btime") + "<br>");
				out.println("Date: " + res.getDate("bdate") + "<br>");
				out.println("<hr>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			out.println("Error loading bookings");
		}
	}
}

