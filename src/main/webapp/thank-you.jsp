<html>
<head>
<title>Thank you</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<h1>My Restaurant</h1>
	Thank you - your order has been received. You need to pay $<%=session.getAttribute("total")%>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>