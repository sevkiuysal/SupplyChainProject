package com.uysal.controller.supplier;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uysal.business.abstracts.SupplierService;
import com.uysal.business.concretes.SupplierManager;
import com.uysal.database.concretes.Postgresql;
import com.uysal.database.concretes.SupplierDao;
import com.uysal.entities.Supplier;

/**
 * Servlet implementation class Login
 */
@WebServlet("/supplierlogin")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SupplierService supplierService;



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		supplierService = 
				new SupplierManager(new SupplierDao(new Postgresql()));
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); // Türkçe karakter sorunu için yazılmış kod
		
		
		
		HttpSession session=request.getSession();
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		session.setAttribute("name", null);
		
		Supplier supplier=supplierService.Login(name, password);
		
					
		if (supplier.getUserId() !=0) {
			session.setAttribute("name", name);
			session.setAttribute("userId", supplier.getUserId());			
			response.sendRedirect("SupplierHome.jsp");
		}
		else {
			response.sendRedirect("SupplierLogin.jsp");
		}
		
	}

}
