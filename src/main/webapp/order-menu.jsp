<%@ page import="domain.MenuItem"%>
<%@ page import="java.util.List"%>
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
			<%
				for (MenuItem menuItem : (List<MenuItem>) request.getAttribute("menuItems")) {
			%>
			<li><%=menuItem %> <input type='text' name='item_<%=menuItem.getId()%>' /></li>
			<%
				}
			%>
		</ul>
		<input type='submit' />
	</form>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>