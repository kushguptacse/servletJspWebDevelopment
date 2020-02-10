<%@ page import="data.MenuDao"%>
<%@ page import="data.MenuDaoFactory"%>
<%@ page import="domain.MenuItem"%>
<%@ page import="java.util.List"%>
<html>
<head>
<title>My Menu</title>
</head>
<body>
	<%
		MenuDao menuDao = MenuDaoFactory.getMenuDao();
		List<MenuItem> menuItems = menuDao.getFullMenu();
	%>
	<jsp:include page="/header.jsp"></jsp:include>
	<h2>Menu</h2>
	<ul>
		<%
			for (MenuItem menuItem : menuItems) {
		%>
		<li><%=menuItem%></li>
		<%
			}
		%>
	</ul>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>