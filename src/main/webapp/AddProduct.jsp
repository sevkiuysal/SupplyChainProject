<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="includes/header.jsp"%>
<title>Ürün Ekle</title>
</head>
<body>

	<%@include file="includes/navbar.jsp"%>

	<div class="content">

		<div class="w-50 container">
			<h1 class="mt-4">Ürün Ekle</h1>
			<form class="mt-3"
				action="<%=request.getContextPath()%>/add-product" method="POST">
				<input type="hidden" />
				<div class="form-group">
					<label for="exampleInputEmail1">Ürün Adı</label> <input type="text"
						class="form-control" name="productName"
						placeholder="Ürün Adını Giriniz">
				</div>
				<br>
				<div class="form-group">
					<label for="exampleInputEmail1">Ürün Fiyatı(₺)</label> <input
						type="text" class="form-control" name="productPrice"
						placeholder="Ürün Fiyatını Giriniz">
				</div>
				<br>
				<div class="form-group">
					<label for="exampleInputEmail1">Ürün Stoğu</label> <input
						type="text" class="form-control" name="quantity"
						placeholder="Ürün Stoğunu Giriniz">
				</div>
				<br> <br>
				<div class="form-group">
					<label for="exampleInputEmail1">Ürün Fotoğrafı</label> <input
						type="file" accept="image/*" class="form-control"
						name="productImage" placeholder="Ürün Fotoğrafını Giriniz">
				</div>
				<br>
				<button type="submit" class="btn btn-primary">Ekle</button>
			</form>

		</div>
	</div>

	<%@include file="includes/footer.jsp"%>

</body>
</html>