package com.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/order")
public class order extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String FullName=req.getParameter("name");
		String Email=req.getParameter("email");
		String MobileNo=req.getParameter("number");
		String AlternativeNo=req.getParameter("number1");
		String Address=req.getParameter("address");
		String pinNumber=req.getParameter("pin");
		String City=req.getParameter("city");
		String State=req.getParameter("state");
		String productID=req.getParameter("productID");
		String Quantity=req.getParameter("Quantity");
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/furniture";
			String user="root";
			String password="12345";
			
			
			Connection con=DriverManager.getConnection(url,user,password);
			PreparedStatement ps=con.prepareStatement("insert into orders values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, FullName);
			ps.setString(2, Email);
			ps.setString(3, MobileNo);
			ps.setString(4, AlternativeNo);
			ps.setString(5, Address);
			ps.setString(6, pinNumber);
			ps.setString(7, City);
			ps.setString(8, State);
			ps.setString(9, productID);
			ps.setString(10, Quantity);
			
			int i=ps.executeUpdate();
			
			if(i>0) {
				
				resp.sendRedirect("conform.html");
			}
			
		
			
			} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}


