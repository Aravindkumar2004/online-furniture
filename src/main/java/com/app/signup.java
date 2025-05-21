package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/signup")
public class signup extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String number=req.getParameter("number");
		String password=req.getParameter("password");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/furniture";
			String user="root";
			String password1="12345";
			
			
			Connection con=DriverManager.getConnection(url,user,password1);
			PreparedStatement ps=con.prepareStatement("insert into signup values(?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,email);
			ps.setString(3,number);
			ps.setString(4,password);
			int i=ps.executeUpdate();
			
			if(i>0) {
				
				resp.sendRedirect("login.html");
			}
			
		
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
