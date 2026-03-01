package com.booking.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.booking.connection.DBConnection;

@WebServlet("/BookingServiceServlet")
public class BookingServiceServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession(false);

        // ✅ SESSION FIX
        if (session == null || session.getAttribute("cid") == null) {
            response.sendRedirect("Login.html");
            return;
        }

        int sid = Integer.parseInt(request.getParameter("sid"));
        int cid = (int) session.getAttribute("cid");

        Connection con = DBConnection.getconnection();

        try {
            PreparedStatement pstmt = con.prepareStatement(
                    "insert into booking(status, btime, bdate, cid, sid) values(?,?,?,?,?)");

            pstmt.setString(1, "Booked");
            pstmt.setInt(2, 1);
            pstmt.setDate(3, new Date(System.currentTimeMillis()));
            pstmt.setInt(4, cid);
            pstmt.setInt(5, sid);

            int i = pstmt.executeUpdate();

            if (i > 0) {
                out.print("<h2>Booking Successful ✅</h2>");
                out.print("<a href='Dashboard.html'>Go to Dashboard</a>");
            } else {
                out.print("Booking failed ❌");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            out.print("Error occurred");
        }
    }
}
