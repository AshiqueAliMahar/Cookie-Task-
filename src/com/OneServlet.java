package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OneServlet
 */
@WebServlet("/OneServlet")
public class OneServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie cookie[] = request.getCookies();	
		int btn = Integer.parseInt(request.getParameter("delete"));
		System.out.println(btn);
		Cookie ck = cookie[btn];
		ck.setMaxAge(0);
		response.addCookie(ck);
		response.sendRedirect("basket.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("productName");
		String price = request.getParameter("productPrice");
		Cookie cookie = new Cookie(name, price);
		response.addCookie(cookie);
		response.sendRedirect("index.jsp");
	}//end 

}
