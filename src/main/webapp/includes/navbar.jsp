<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<%
		if (session.getAttribute("author").equals("supplier")) {
		%>
		<a class="navbar-brand" href="#"><%=session.getAttribute("name")%></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="SupplierHome.jsp">Home</a></li>
				<li class="nav-item dropdown">

					<button class="btn dropdown-toggle" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">Fatura</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="PastInvoices.jsp">Geçmiş Faturalar</a></li>
						<li><a class="dropdown-item" href="ShowBill.jsp">Onay
								Bekleyen Faturalar</a></li>
					</ul>
				</li>
				<li class="nav-item"><a class="nav-link" href="AddProduct.jsp">Ürün
						Ekle</a></li>

				<li class="nav-item"><a class="nav-link" href="logout">Çıkış</a>
				</li>
			</ul>
			<%
			} else if (session.getAttribute("author").equals("retailer")) {
			%>
			<a class="navbar-brand" href="Basket.jsp">Sepet</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<form class="d-flex" role="search" action="searchproductbyname"
				method="get">
				<input class="form-control me-2" type="search" name="name"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Bul</button>
			</form>
			<%
			} else {
			%>
			<div class="internet-branch" id="myPopup">
				<button onclick="myFunction()">Giriş Yap</button>

				<!-- <span
						href=""
						data-width="1025" id="myPopup" data-height="720"
						
						class="individual-btn">User</span> <a
						href=""
						data-type="popup" data-width="1025" data-height="720"
						onclick=""
						class="corporate-btn">Admin</a> -->

			</div>
			<%
			}
			%>

		</div>
	</div>
</nav>