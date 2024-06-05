package com.colledgePortal;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.sql.*;

@WebServlet("/placementImage")
@MultipartConfig
public class PlacementUpload extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InputStream inputStream = null;
        Part filePart = request.getPart("image");

        if (filePart != null) {
            inputStream = filePart.getInputStream();
        }
        
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/CollegePortal", "root", "Skyan@1#0520");
            pstmt = conn.prepareStatement("INSERT INTO Placement (placementImage) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
            if (inputStream != null) {
                pstmt.setBlob(1, inputStream);
            }

            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the auto-generated ID of the inserted row
                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int id = generatedKeys.getInt(1);
                    // Redirect to the same page with the image ID appended to the URL
//                    response.sendRedirect(request.getContextPath() + "/displayImage?id=" + id);
                    response.sendRedirect("placement.jsp?id=" + id);
                } else {
                    response.sendRedirect("placement.jsp");
                }
            } else {
                response.sendRedirect("placement.jsp");
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("placement.jsp");
        } finally {
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
