<html>
	<head>
		<title>MyRestaurant - please log in</title>
	</head>
	<body>
	<jsp:include page="/header.jsp"></jsp:include>
		<h1>My Restaurant</h1>
		<h2>Please log in</h2>
		<form action="j_security_check" method="POST">
			Username: <input type="text" name="j_username" /> 
			Password: <input type="password" name="j_password" />
			<input type="submit" value="login" />
		</form>
	<jsp:include page="/footer.jsp"></jsp:include>
	</body>
</html>