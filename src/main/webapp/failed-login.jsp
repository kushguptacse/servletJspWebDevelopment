<html>
	<head>
		<title>My Restaurant - please log in</title>
	</head>
	<body>
	<jsp:include page="/header.jsp"></jsp:include>
		<h1>My Restaurant</h1>
		<h2>Sorry - we didn't recognise you - please try again...</h2>
		<form action="j_security_check" method="POST">
			Username: <input type="text" name="j_username" /> 
			Password: <input type="password" name="j_password" />
			<input type="submit" value="login" />
		</form>
		<jsp:include page="/footer.jsp"></jsp:include>
	</body>
</html>