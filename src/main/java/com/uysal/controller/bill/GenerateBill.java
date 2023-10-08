package com.uysal.controller.bill;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uysal.business.abstracts.BillService;
import com.uysal.business.concretes.BillManager;
import com.uysal.database.concretes.BillDao;
import com.uysal.database.concretes.Postgresql;

/**
 * Servlet implementation class GenerateBill
 */
@WebServlet("/GenerateBill")
public class GenerateBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BillService billService;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		billService=new BillManager(new BillDao(new Postgresql()));
	}


}
