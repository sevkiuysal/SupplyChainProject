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
@WebServlet("/searchproductbyname")
public class SearchProduct extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ProductService productService;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		productService = new ProductManager(new ProductDao(new Postgresql()));

		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); // Türkçe karakter sorunu için yazılmış kod
		PrintWriter out=response.getWriter();
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		List<Product> products = null;
		if (name != null && name!=" ") {
			out.print(name);
			products = productService.searchProductbyName(name);
			session.setAttribute("products", products);
			response.sendRedirect("Home.jsp?name="+name);
		}else
			session.setAttribute("products", null);
	}

}
