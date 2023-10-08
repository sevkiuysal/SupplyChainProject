package com.uysal.controller.retailer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uysal.entities.Product;
import com.uysal.entities.Retailer;

/**
 * Servlet implementation class AddBasket
 */
@WebServlet("/retailer/add-basket")
public class AddBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Retailer retailer;
	
	private Product product;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8"); // Türkçe karakter sorunu için yazılmış kod
		
		PrintWriter out=response.getWriter();
		
//		int quantity=Integer.parseInt(request.getParameter("quantity"));
//		int productId=Integer.parseInt(request.getParameter("product-id"));
//		double productPrice=Double.parseDouble(request.getParameter("product-price"));
//		String productName=request.getParameter("product-name");
//		
//		HttpSession session=request.getSession();
//		int retailerId=(int) session.getAttribute("retailer_id");
//		
//		
//		
//		
//		product=new Product(productId,productName,quantity,productPrice);
//		List<Product> retailerProducts=new ArrayList<>();
		
		Cookie productsCookie=new Cookie("products", "hello");
		response.addCookie(productsCookie);
		response.sendRedirect(request.getContextPath()+"/testCookie.jsp");
		
		
		
		
		
//		if(session.getAttribute("basket_products")!=null)
//		retailerProducts=(List<Product>)session.getAttribute("basket_products");
//		if(!retailerProducts.isEmpty() && retailerProducts!=null) {
//		if( !retailerProducts.contains(product)) {
//		retailerProducts.add(product);
//		session.setAttribute("basket_products", retailerProducts);
//		response.sendRedirect(request.getContextPath()+"/index.jsp");
//		}else {
//			response.setStatus(204, "Tekrar Deneyin...");	
//		}
//		
//		}
//		else {
//			retailerProducts.add(product);
//			session.setAttribute("basket_products", retailerProducts);
//			response.sendRedirect(request.getContextPath()+"/index.jsp");
//		}
		
		
	}
	
	
	
	
	
	
	
	
	

}
