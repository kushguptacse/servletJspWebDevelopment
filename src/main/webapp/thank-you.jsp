<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<html>
<head>
<title>Thank you</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<h1>My Restaurant</h1>
	Thank you - your order has been received. You need to pay 
	<f:formatNumber currencyCode="${currency}" value="${total}" type="currency"/>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>