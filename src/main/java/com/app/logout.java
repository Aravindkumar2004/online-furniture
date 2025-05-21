package com.app;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/logout")
public class logout extends HttpServlet{
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] c=req.getCookies();
		
		c[0].setMaxAge(0);
		c[1].setMaxAge(0);
		resp.addCookie(c[0]);
		resp.addCookie(c[1]);
		resp.sendRedirect("login.html");
	}

}