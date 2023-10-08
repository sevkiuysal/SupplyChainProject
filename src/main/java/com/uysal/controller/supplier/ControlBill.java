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

/**
 * Servlet implementation class ControlBill
 */
@WebServlet("/control-bill")
public class ControlBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private SupplierService supplierService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		supplierService=new SupplierManager(new SupplierDao(new Postgresql()));
		String control=(String)request.getParameter("control");
		HttpSession session=request.getSession();
		
		long billId=(long)(session.getAttribute("billId"));
		if(control.equals("acceptBill")) {
			supplierService.acceptBill(billId);
			response.sendRedirect(request.getContextPath()+"/ShowBill.jsp");
		}else if(control.equals("cancelBill")) {
			supplierService.cancelBill(billId);
			response.sendRedirect(request.getContextPath()+"/ShowBill.jsp");
		}
		
		
	}


}
