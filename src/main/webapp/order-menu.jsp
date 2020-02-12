<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>My Menu</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<h1>Restaurant Menu</h1>
	<h2>Order Your Food</h2>
	<form action='orderReceived' method='POST'>
		<ul>
		<c:forEach items="${menuItems}" var="menuItem">
			<li>${menuItem} <input type='text' name='item_${menuItem.getId()}' /></li>
		</c:forEach>
		</ul>
		<input type='submit' />
	</form>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>