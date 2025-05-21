package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login")
public class login extends HttpServlet{
	
	private String name; 

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String password=req.getParameter("password");
		
		PrintWriter p=resp.getWriter();
		resp.setContentType("text/html");
		
		
		try {
			String url="jdbc:mysql://localhost:3306/furniture";
			String user="root";
			String password1="12345";
			
			
			Connection con=DriverManager.getConnection(url,user,password1);
			PreparedStatement ps=con.prepareStatement("select * from signup where name= ? and password= ? ");
			
			ps.setString(1,name);
			ps.setString(2,password);
		ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				Cookie ck1=new Cookie("name",name );
				Cookie ck2=new Cookie("password",password );
				resp.addCookie(ck1);
				resp.addCookie(ck2);
				resp.sendRedirect("home.html");
				
			}
			else {
			
				resp.sendRedirect("login.html");
			}
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
