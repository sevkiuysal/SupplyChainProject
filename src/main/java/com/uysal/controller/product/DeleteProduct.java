package com.uysal.controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uysal.business.abstracts.ProductService;
import com.uysal.business.concretes.ProductManager;
import com.uysal.database.concretes.Postgresql;
import com.uysal.database.concretes.ProductDao;

/**
 * Servlet implementation class Delete
 */
@WebServlet("/delete")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    private ProductService productService;
    
    public DeleteProduct() {
        
    }

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		productService=new ProductManager(new ProductDao(new Postgresql()));
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		
		int productId=Integer.parseInt(request.getParameter("productId"));
		int userId=Integer.parseInt(session.getAttribute("userId").toString()) ;
		
		if(productService.delete(productId)) {
			session.setAttribute("products", productService.getAll(userId));
			response.sendRedirect("SupplierHome.jsp");	
			
		}
		
		
	}

}
