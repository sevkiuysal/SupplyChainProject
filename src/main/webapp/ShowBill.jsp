<%@page import="com.uysal.database.concretes.Postgresql"%>
<%@page import="com.uysal.database.concretes.SupplierDao"%>
<%@page import="com.uysal.business.concretes.SupplierManager"%>
<%@page import="com.uysal.business.abstracts.SupplierService"%>
<%@page import="com.uysal.entities.Bill"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
long supplierId = (long) session.getAttribute("userId");

SupplierService supplierService = new SupplierManager(new SupplierDao(new Postgresql()));
List<Bill> bills = supplierService.showBill(supplierId);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Bill</title>
<%@include file="includes/header.jsp"%>
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>
	<div class="container mt-5">
		<table class="table table-striped table-hover w-80 mx-auto">
			<thead class="bg-info">
				<tr>
					<th scope="col">Müşteri Adı</th>
					<th scope="col">Ürün Adı</th>
					<th scope="col">Ürün Miktarı</th>
					<th scope="col">Ürün Fiyatı</th>
					<th scope="col">Toplam Tutar</th>
					<th></th>
					<th></th>
				</tr>
			</thead>

			<tbody>
				<%
				if (!bills.isEmpty()) {
					for (Bill bill : bills) {
				%>
				
				<tr >
					<%session.setAttribute("billId", bill.getBillId()); %>
					<td><%=bill.getRetailerName()%></td>
					<td><%=bill.getProductName()%></td>
					<td><%=bill.getQuantity()%></td>
					<td><%=bill.getProductPrice()%></td>
					<td><%=bill.getTotalAmount()%></td>
					<td><a class="btn btn-success" href="control-bill?control=acceptBill" >Onayla</a></td>
					<td><a class="btn btn-danger " href="control-bill?control=cancelBill" >İptal	Et</a></td>
				</tr>
				<%
				}
				} else {
				%>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>

				<%
				}
				%>
			</tbody>
		</table>
	</div>
	<%@ include file="includes/footer.jsp"%>


</body>
</html>