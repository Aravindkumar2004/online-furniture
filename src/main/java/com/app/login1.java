package com.app;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/login1")


public class login1 extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] ck=req.getCookies();
		if(ck==null) {
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.forward(req, resp);
		}else {
			resp.sendRedirect("home.html");
		}
	}

}
