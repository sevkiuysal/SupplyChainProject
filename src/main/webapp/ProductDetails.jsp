<%@page import="com.uysal.entities.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	
	<% Product product=(Product)session.getAttribute("product"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="includes/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<!-- https://bbbootstrap.com/snippets/bootstrap-ecommerce-single-product-page-size-attribute-59223596 --> 
	<%@include file="includes/navbar.jsp"%>

	<div class="container mt-5 mb-5">
		<div class="row d-flex justify-content-center">
			<div class="col-md-10">
				<div class="card">
					<div class="row">
						<div class="col-md-6">
							<div class="images p-3">
								<div class="text-center p-4">
									<img id="main-image" src="image/<%=product.getImage() %>" width="250" />
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="product p-4">

								<div class="mt-4 mb-3">
									<span class="text-uppercase text-muted brand">Orianz</span>
									<h5 class="text-uppercase">Men's slim fit t-shirt</h5>
									<div class="price d-flex flex-row align-items-center">
										<span class="act-price"><%=product.getPrice() %>₺</span>
										
									</div>
								</div>
								<p class="about">Shop from a wide range of t-shirt from
									orianz. Pefect for your everyday use, you could pair it with a
									stylish pair of jeans or trousers complete the look.</p>
								<div class="quanties mt-5">
								
					<label for="exampleInputEmail1">Ürün Stoğu</label> <input
						type="number" class="form-control" name="quantity" min="1"
						value="<%=product.getQuantity()%>">
				
								</div>
								<div class="cart mt-4 align-items-center">
									<button class="btn btn-danger text-uppercase mr-2 px-4">Add
										to cart</button>
									<i class="fa fa-heart text-muted"></i> <i
										class="fa fa-share-alt text-muted"></i>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<%@include file="includes/footer.jsp"%>

</body>
</html>