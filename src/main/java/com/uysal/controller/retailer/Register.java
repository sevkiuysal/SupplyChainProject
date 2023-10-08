package com.uysal.controller.retailer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uysal.business.abstracts.RetailerService;
import com.uysal.business.concretes.RetailerManager;
import com.uysal.database.concretes.Postgresql;
import com.uysal.database.concretes.RetailerDao;
import com.uysal.entities.Retailer;

/**
 * Servlet implementation class Register
 */
@WebServlet("/retailer/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private RetailerService retailerService;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); // Türkçe karakter sorunu için yazılmış kod
		
		PrintWriter out=response.getWriter();
		retailerService=new RetailerManager(new RetailerDao(new Postgresql()));
		String name=request.getParameter("name");
		String emailAddress=request.getParameter("emailAddress");
		long phoneNumber=Long.parseLong(request.getParameter("phoneNumber"));
		String password=request.getParameter("password");
		Retailer retailer=new Retailer(name, password, emailAddress, phoneNumber);
		
		
		if(retailerService.Register(retailer)) {
			response.sendRedirect(request.getContextPath()+"/RetailerLogin.jsp");
		}else
			out.print("Kayıt Yapılamadı...");
	}

}
