package com.uysal.controller.retailer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uysal.business.abstracts.BillService;
import com.uysal.business.concretes.BillManager;
import com.uysal.database.concretes.BillDao;
import com.uysal.database.concretes.Postgresql;
import com.uysal.entities.Product;

/**
 * Servlet implementation class OrderControl
 */
@WebServlet("/order")
public class OrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private BillService billService;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter outPrintWriter=response.getWriter();
		
		billService=new BillManager(new BillDao(new Postgresql()));
		String billStatus=request.getParameter("status");
		HttpSession session=request.getSession();
		
		List<Product> products=(List<Product>) session.getAttribute("basket_products");
		
		if(billStatus.equals("confirm")) {
			long productId=Long.parseLong(request.getParameter("product_id"));
			outPrintWriter.print(productId);
		}
	}

	

}
