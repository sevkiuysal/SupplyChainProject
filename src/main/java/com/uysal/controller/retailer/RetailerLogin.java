package com.uysal.controller.retailer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uysal.business.abstracts.RetailerService;
import com.uysal.business.concretes.RetailerManager;
import com.uysal.database.concretes.Postgresql;
import com.uysal.database.concretes.RetailerDao;


@WebServlet("/retailer/login")
public class RetailerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RetailerService retailerService;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); // Türkçe karakter sorunu için yazılmış kod
		
		retailerService=new RetailerManager(new RetailerDao(new Postgresql()));
		
		HttpSession session=request.getSession();
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		int retailerId=retailerService.Login(name, password);
		if(retailerId!=0) {
			session.setAttribute("retailer_id", retailerId);
			session.setAttribute("author", "retailer");
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}
		else
			response.sendRedirect(request.getContextPath()+"/RetailerLogin.jsp");
	}

}
