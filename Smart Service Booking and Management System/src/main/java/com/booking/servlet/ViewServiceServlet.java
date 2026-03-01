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

import com.booking.connection.DBConnection;

@WebServlet("/ViewServiceServlet")
public class ViewServiceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection con = DBConnection.getconnection();

        try {
            PreparedStatement pstmt = con.prepareStatement("select * from service");
            ResultSet res = pstmt.executeQuery();

            while (res.next()) {
                int sid = res.getInt("sid");

                out.println("<h2>" + res.getString("sname") + "</h2>");
                out.println("<p>" + res.getString("description") + "</p>");
                out.println("<p>Price: " + res.getInt("price") + "</p>");
                out.println("<p>Duration: " + res.getInt("duration") + " days</p>");

                // ✅ FIXED URL
                out.println("<a href='" + request.getContextPath()
                        + "/BookServiceServlet?sid=" + sid + "'>Book</a>");

                out.println("<hr>");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}