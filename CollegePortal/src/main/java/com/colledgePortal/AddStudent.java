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

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/addStudent")
@MultipartConfig
public class AddStudent extends HttpServlet {
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
                pstmt = con.prepareStatement("INSERT INTO AddStudent (Name, Email, Pass) VALUES (?, ?, ?)");

                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, pass);

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    request.setAttribute("status", "success");
                } else {
                    request.setAttribute("status", "failed");
                    request.setAttribute("message", "Failed to add data to the database.");
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
        
        dispatcher = request.getRequestDispatcher("addNew.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Forward the request to doGet method
        doGet(req, resp);
    }    

}
