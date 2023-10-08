<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@include file="includes/header.jsp"%>
</head>
<body>

	<form action="<%=request.getContextPath()%>/retailer/register" method="post">

		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px; height:100vh;">
				<h4 class="card-title mt-3 text-center">Kullanıcı Ekle</h4>
				<p>
					<a href="" class="btn btn-block btn-twitter"> <i
						class="fab fa-twitter"></i>   Login via Twitter
					</a> <a href="" class="btn btn-block btn-facebook"> <i
						class="fab fa-facebook-f"></i>   Login via facebook
					</a>
				</p>
				<p class="divider-text"></p>
				<form>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-user"></i>
							</span>
						</div>
						<input name="name" class="form-control" placeholder="Full name"
							type="text">
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-envelope"></i>
							</span>
						</div>
						<input name="emailAddress" class="form-control"
							placeholder="Email address" type="email">
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-phone"></i>
							</span>
						</div>
						<select class="custom-select" style="max-width: 120px;">
							<option selected="">+90</option>
							<option value="1">+972</option>
							<option value="2">+198</option>
							<option value="3">+701</option>
						</select> <input name="phoneNumber" class="form-control"
							placeholder="Phone number" type="text">
					</div>
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input class="form-control" name="password"
							placeholder="Create password" type="password">
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input class="form-control" placeholder="Repeat password"
							type="password">
					</div>
					<!-- form-group// -->
					<div class="form-group">
						<button type="submit" class="btn btn-primary btn-block">
							Kaydet</button>
					</div>
					<!-- form-group// -->
					<p class="text-center">
						Have an account? <a href="SupplierLogin.jsp">Log In</a>
					</p>
				</form>
			</article>
		</div>
		<!-- card.// -->

		</div>
		<!--container end.//-->
</body>
</html>