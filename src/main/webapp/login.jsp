<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="includes/header.jsp"%>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form>
		<!-- Email input -->
		<div class="form-outline mb-4 mx-auto my-5">
			<input type="email" id="form2Example1" class="form-control" /> <label
				class="form-label" for="form2Example1">Email address</label>
		</div>

		<!-- Password input -->
		<div class="form-outline mb-4">
			<input type="password" id="form2Example2" class="form-control" /> <label
				class="form-label" for="form2Example2">Password</label>
		</div>

		<!-- 2 column grid layout for inline styling -->
		<div class="row mb-4">
			<div class="col d-flex justify-content-center">
				<!-- Checkbox -->
				<div class="form-check">
					<input class="form-check-input" type="checkbox" value=""
						id="form2Example31" checked /> <label class="form-check-label"
						for="form2Example31"> Remember me </label>
				</div>
			</div>

			<div class="col">
				<!-- Simple link -->
				<a href="#!">Forgot password?</a>
			</div>
		</div>

		<!-- Submit button -->
		<button type="button" class="btn btn-primary btn-block mb-4">Sign
			in</button>

		<!-- Register buttons -->
		<div class="text-center">
			<p>
				Not a member? <a href="#!">Register</a>
			</p>
			<p>or sign up with:</p>
			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="bi bi-facebook"></i>
			</button>

			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="bi bi-google"></i>
			</button>

			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="bi bi-twitter"></i>
			</button>

			<button type="button" class="btn btn-link btn-floating mx-1">
				<i class="bi bi-github"></i>
			</button>
		</div>
	</form>
	<%@include file="includes/footer.jsp"%>
</body>
</html>