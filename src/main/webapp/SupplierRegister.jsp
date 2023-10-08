<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="<%=request.getContextPath() %>/supplier" method="post">
		Username: <input placeholder="Adınızı giriniz" name="name">

		Mail Address: <input type="email" placeholder="Mail Adresini giriniz"
			name="emailAddress"> Phone Number: <input type="tel"
			placeholder="Telefon numaranızı giriniz" name="phoneNumber">

		Password: <input type="password" placeholder="Şifrenizi giriniz"
			name="password"> <input type="submit" value="Save" />

	</form>











</body>
</html>