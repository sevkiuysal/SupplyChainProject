package com.uysal.controller.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
@WebServlet("/getAll")
public class GetAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("application/json;charset=UTF-8");
		HttpSession session=request.getSession();
		int id=Integer.parseInt((String) session.getAttribute("supplierId"));
		productService=new ProductManager(new ProductDao(new Postgresql()));
		PrintWriter out = response.getWriter();
		List<Product> products=productService.getAll(id);
		session.setAttribute("products", products);
		
		out.flush();
	}

}
