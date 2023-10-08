<%@page import="java.util.ArrayList"%>
<%@page import="com.uysal.database.concretes.Postgresql"%>
<%@page import="com.uysal.database.concretes.RetailerDao"%>
<%@page import="com.uysal.business.concretes.RetailerManager"%>
<%@page import="com.uysal.business.abstracts.RetailerService"%>
<%@page import="com.uysal.entities.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
	int id=(int)session.getAttribute("retailer_id");
	long retailerId=(long) id;
	
	Cookie [] cookies=request.getCookies();
	List<Product> products=(List<Product>)cookies[0];
	
		
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sepet</title>
<%@include file="includes/header.jsp"%>
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>
	<div class="container mt-5">
		<table class="table table-striped table-hover w-80 mx-auto">
			<thead class="bg-info">
				<tr>
					<th scope="col">Ürün Adı</th>
					<th scope="col">Ürün Fiyatı</th>
					<th scope="col">Miktar</th>
					<th scope="col">Toplam Tutar</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
			<% if(!products.isEmpty()){
			for(Product product:products){
			%>
				<tr name="product_id" value="<%=product.getProductId()%>">
					<td><%=product.getProductName() %></td>
					<td><%=product.getPrice() %></td>
					<td><%=product.getQuantity() %></td>
					<td><%=product.getQuantity()*product.getPrice() %></td>
					<td class="d-flex justify-content-between p-1"><a
							class="btn btn-success" href="order?status=confirm" >Onayla</a>
						<a class="btn btn-danger "  href="order?status=cancel">İptal Et</a></td>
				</tr>
				<%}
			
			}else{ %>
			
			<tr>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			</tr>
			<%} %>
			</tbody>
		</table>
	</div>
	<%@ include file="includes/footer.jsp"%>


</body>
</html>