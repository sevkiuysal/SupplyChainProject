package com.uysal.controller.product;

import java.io.IOException;

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
 * Servlet implementation class AddProduct
 */
@WebServlet("/add-product")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService productService;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); // Türkçe karakter sorunu için yazılmış kod
		
		
		HttpSession session=request.getSession();
		productService=new ProductManager(new ProductDao(new Postgresql()));
		long userId=Long.parseLong(session.getAttribute("userId").toString()); 
		String productName=request.getParameter("productName");
		double productPrice=Double.parseDouble(request.getParameter("productPrice")) ;
		String productImage=request.getParameter("productImage");
		long quantity=Long.parseLong(request.getParameter("quantity")) ;
		Product product=new Product(productName,quantity,productPrice,productImage,userId);		
		if(productService.addProduct(product)) {
		session.setAttribute("products", productService.getAll(userId));
		response.sendRedirect("SupplierHome.jsp");
		}
		else {
			System.out.println("Hatalı Giriş");
		}
		
	}

}
