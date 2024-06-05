package com.colledgePortal;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.*;
import java.sql.*;

@WebServlet("/updateStudent")
@MultipartConfig
public class UpdateStudentInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        Connection con = null;
        PreparedStatement pstmt = null; 
        RequestDispatcher dispatcher = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CollegePortal", "root", "Skyan@1#0520");

            // Check if the email already exists in the database
            PreparedStatement checkStmt = con.prepareStatement("SELECT * FROM AddStudent WHERE Email = ?");
            checkStmt.setString(1, email);
            ResultSet checkResult = checkStmt.executeQuery();

            if (checkResult.next()) {
                // If email exists, update the existing record
                pstmt = con.prepareStatement("UPDATE AddStudent SET Name = ?, Pass = ? WHERE Email = ?");
                pstmt.setString(1, name);
                pstmt.setString(2, pass);
                pstmt.setString(3, email);
            } else {
                // If email doesn't exist, insert a new record
                pstmt = con.prepareStatement("INSERT INTO AddStudent (Name, Email, Pass) VALUES (?, ?, ?)");
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, pass);
            }

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                request.setAttribute("status", "success");
            } else {
                request.setAttribute("status", "failed");
                request.setAttribute("message", "Failed to add/update data in the database.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "Database operation failed: " + e.getMessage());
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        dispatcher = request.getRequestDispatcher("userProfile.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward the request to doGet method
        doGet(req, resp);
    }    
}
