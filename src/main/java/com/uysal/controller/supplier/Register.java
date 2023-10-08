package com.uysal.controller.supplier;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uysal.business.abstracts.SupplierService;
import com.uysal.business.concretes.ProductManager;
import com.uysal.business.concretes.SupplierManager;
import com.uysal.database.concretes.Postgresql;
import com.uysal.database.concretes.SupplierDao;
import com.uysal.entities.Supplier;

/**
 * Servlet implementation class Register
 */
@WebServlet("/supplier/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private SupplierService supplierService;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String name=request.getParameter("name");
		String emailAddress=request.getParameter("emailAddress");
		long phoneNumber=Long.parseLong(request.getParameter("phoneNumber"));
		String password=request.getParameter("password");
		
		supplierService=new SupplierManager(new SupplierDao(new Postgresql()));
		
		supplierService.Register(new Supplier(name, password, emailAddress, phoneNumber));
	}

}
