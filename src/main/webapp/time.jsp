<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<html>
<head>
<title>Current Time</title>
</head>
<body>
	<jsp:include page="/header.jsp" />
	<c:if test="${user != null}">
		Hello ${user} 
    </c:if>
	<br /> Current Time
	<span id="date"> <f:formatDate type="both" value="${date}" />
	</span>
	<jsp:include page="/footer.jsp" />
</body>
</html>