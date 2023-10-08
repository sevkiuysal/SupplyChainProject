<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@include file="includes/header.jsp"%>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<div class="container">
		<div class="card w-50 mx-auto my-5 bg-gradient-light">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/retailer/login"
					method="post">
					<div class="form-group">
						<label>Email Address</label> <input type="text" name="name"
							class="form-control" placeholder="Your Email Address..." required>
					</div>

					<div class="form-group">
						<label>Password</label> <input type="text" name="password"
							class="form-control" placeholder="*******" required>
					</div>

					<!-- Submit button -->
					<div class="col-md-4 mx-auto my-2 px-3">
					<button type="submit"
						class="btn btn-primary btn-block">Sign in</button>
						</div>
				</form>
				<!-- Register buttons -->
				<div class="text-center">
					<p>
						Not a member? <a href="RetailerRegister.jsp">Register</a>
					</p>

				</div>
			</div>
		</div>
	</div>
	<%@include file="includes/footer.jsp"%>
</body>
</html>