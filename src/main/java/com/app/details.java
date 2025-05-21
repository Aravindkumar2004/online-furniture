package com.app;



	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;
	import jakarta.servlet.http.HttpSession;
	@WebServlet("/details")
	public class details extends HttpServlet {
		
		protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			    String url="jdbc:mysql://localhost:3306/furniture";
			    String user="root";
			    String password="12345";
		Connection con= DriverManager.getConnection(url,user,password);
			      
		Statement st=con.createStatement();
		ResultSet res=st.executeQuery("select * from orders");
		PrintWriter pw=resp.getWriter();
		resp.setContentType("text/html");
		pw.print("<html><head><title>DETAILS OF orders</title></head>");
		pw.print("<body><table border='2'><tr>");
		pw.print("<th>FullName</th><th>Email</th><th>MobileNo</th><th>AlternativeNo</th><th>Address</th><th>pinNumber</th><th>City</th><th>State</th><th>productID</th><th>Quantity</th>");
		
		 while (res.next()) {
			 pw.print("<tr><td>"+res.getString("FullName")+"</td>");
			 pw.print("<td>"+res.getString("Email")+"</td>");
			 pw.print("<td>"+res.getString("MobileNo")+"</td>");
			 pw.print("<td>"+res.getString("AlternativeNo")+"</td>");
			 pw.print("<td>"+res.getString("Address")+"</td>");
			 pw.print("<td>"+res.getString("pinNumber")+"</td>");
			 pw.print("<td>"+res.getString("City")+"</td>");
			 pw.print("<td>"+res.getString("State")+"</td>");
			 pw.print("<td>"+res.getString("productID")+"</td>");
			 pw.print("<td>"+res.getString("Quantity")+"</td></tr>");


			 
			 
		 }
		 pw.print("</table></body></html");
		
		} catch (Exception e) {
		
		}
	  
		}

	}

