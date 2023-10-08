<%@page import="com.uysal.business.abstracts.ProductService"%>
<%@page import="com.uysal.database.concretes.Postgresql"%>
<%@page import="com.uysal.database.concretes.ProductDao"%>
<%@page import="com.uysal.business.concretes.ProductManager"%>
<%@page import="com.uysal.entities.Product"%>
<%@page import="java.util.List"%>
<%@page import="javax.servlet.http.HttpSession"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
ProductService productService=new ProductManager(new ProductDao(new Postgresql()));

List<Product> products=null ;
products=productService.getAll();
session.setAttribute("author", "user");
if(session.getAttribute("products")!=null){
	products=(List<Product>)session.getAttribute("products");}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="includes/header.jsp"%>
<title>Ana Sayfa</title>
</head>
<body>
	<%@include file="includes/navbar.jsp"%>
	
	<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
			<%
			if (!products.isEmpty())
				for (Product product : products) {
			%>

			<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
					<a href="viewproductdetails?product-id=<%=product.getProductId()%>"><img
						src="image/<%=product.getImage()%>" class="card-img-top"
						alt="..." style="width: 214px; height: 214px;"> </a>
					<div class="card-body">
						<h5 class="card-subtitle mb-2 text-muted"><%=product.getProductName()%></h5>
						<div class="mt-3 d-flex justify-content-between">
							<a
								href="UpdateProduct.jsp?product-id=<%=product.getProductId()%>"
								class="btn btn-primary">Güncelle</a> <a
								href="delete?productId=<%=product.getProductId()%>"
								class="btn btn-primary">Sil</a>
						</div>
					</div>
				</div>
			</div>

			<%
			}
			%>


		</div>
	</div>




	<%@include file="includes/footer.jsp"%>

</body>
</html>
