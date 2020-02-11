<html>
<head>
<title>Current Time</title>
</head>
<body>
    <jsp:include page="/header.jsp"></jsp:include>
	Hello <%=request.getAttribute("user")%>
	<br/>
	Current Time <%=request.getAttribute("date") %>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>