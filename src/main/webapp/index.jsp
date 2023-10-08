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
ProductService productService = new ProductManager(new ProductDao(new Postgresql()));

List<Product> products = null;

products = productService.getAll();
if (session.getAttribute("products") != null) {
	products = (List<Product>) session.getAttribute("products");
}
%>
<!DOCTYPE html>
<html>
<head>
<script src="popup.js"></script>
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


			<div class="col-md-3 my-3"><form
								action="<%=request.getContextPath()%>
								/retailer/add-basket"
								method="get">
				<div class="card w-100" style="width: 18rem;">
				
					<a href="viewproductdetails?product-id=<%=product.getProductId()%>"><img
						src="image/<%=product.getImage()%>" class="card-img-top" alt="..."
						style="width: 214px; height: 214px;">
						 </a>
						 <input style="border-style: none; text-align: center;" name="product-price" value="<%=product.getPrice()%>" readonly>
					<div class="card-body">
						<input class="card-subtitle mb-2 text-muted border-0" name="product-name" value="<%=product.getProductName()%>">
						<div class="mt-3 d-flex justify-content-between">
							
								<input style="width: 50px; height: 30px;" type="number" min="1"
									name="quantity" value="1">
									
									<button type="submit" name="product-id" value="<%=product.getProductId()%>" 
									class="btn btn-primary">Satın Al</button>
							</form>
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
