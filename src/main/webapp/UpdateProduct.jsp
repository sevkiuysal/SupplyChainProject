<%@page import="com.uysal.database.concretes.Postgresql"%>
<%@page import="com.uysal.database.concretes.ProductDao"%>
<%@page import="com.uysal.business.concretes.ProductManager"%>
<%@page import="com.uysal.business.abstracts.ProductService"%>
<%@page import="com.uysal.entities.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
int productId = Integer.parseInt(request.getParameter("product-id"));

session.setAttribute("product-id", productId);
ProductService productService = new ProductManager(new ProductDao(new Postgresql()));
Product product = productService.getProduct(productId);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="includes/header.jsp"%>
<title>Ürün Güncelle</title>
</head>
<body>

	<%@include file="includes/navbar.jsp"%>

	<div class="content">

		<div class="w-50 container">
			<h1 class="mt-4">Ürün Güncelle</h1>
			<form class="mt-3"
				action="<%=request.getContextPath()%>/update-product" method="POST">
				<input type="hidden" />
				<div class="form-group">
					<label for="exampleInputEmail1">Ürün Adı</label> <input type="text"
						class="form-control" name="productName"
						value="<%=product.getProductName()%>">
				</div>
				<br>
				<div class="form-group">
					<label for="exampleInputEmail1">Ürün Fiyatı(₺)</label> <input
						type="number" class="form-control" name="productPrice" min="1"
						value="<%=product.getPrice()%>">
				</div>
				<br>
				<div class="form-group">
					<label for="exampleInputEmail1">Ürün Stoğu</label> <input
						type="number" class="form-control" name="quantity" min="1"
						value="<%=product.getQuantity()%>">
				</div>
				<br> <br>
				<div class="form-group">
					<label for="exampleInputEmail1">Ürün Fotoğrafı</label> <input
						type="file" accept="image/*" class="form-control"
						name="productImage" value="<%=product.getImage()%>">
				</div>
				<br>
				<button type="submit" class="btn btn-primary">Güncelle</button>
			</form>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>

</body>
</html>