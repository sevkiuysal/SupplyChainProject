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
import com.uysal.entities.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/viewproductdetails")
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); // Türkçe karakter sorunu için yazılmış kod
		
		HttpSession session=request.getSession();
		productService=new ProductManager(new ProductDao(new Postgresql()));
		String id=request.getParameter("product-id");
		long productId=Long.parseLong(id);
		Product product=productService.viewProductDetails(productId);
		session.setAttribute("product", product);
		response.sendRedirect("/ProductDetails.jsp");
		
	}

}
