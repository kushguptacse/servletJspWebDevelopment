<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>My Menu</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<h2>View Searched Items</h2>
	<ul>
	<c:forEach items="${menuItems}" var="menuItem">
			<li>${menuItem.description}</li>
		</c:forEach>
	</ul>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>