package com.colledgePortal;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/adminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String aname = request.getParameter("aName");
		String apass = request.getParameter("aPass");
		Connection con = null;
		RequestDispatcher dispatcher = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CollegePortal" , "root" , "Skyan@1#0520");
			PreparedStatement st = con.prepareStatement("select * from admin where adminName = ? and adminPass = ?");
			st.setString(1, aname);
			st.setString(2, apass);
			
			ResultSet rst = st.executeQuery();
			
			//dispatcher = request.getRequestDispatcher("login.jsp");

			if(rst.next()) {
				request.setAttribute("status", "success");
				dispatcher = request.getRequestDispatcher("index.jsp");
			//	print.print("Data entered successfully");
			}else {
				request.setAttribute("status", "failed");
				dispatcher = request.getRequestDispatcher("admin.jsp");
			}
			
			dispatcher.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		}

}
