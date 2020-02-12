<%@ page import="domain.MenuItem"%>
<%@ page import="java.util.List"%>
<html>
<head>
<title>My Menu</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<h2>Items</h2>
	<ul>
		<%
			for (MenuItem menuItem : (List<MenuItem>) request.getAttribute("menuItems")) {
		%>
		<li><%=menuItem.getDescription()%></li>
		<%
			}
		%>
	</ul>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>