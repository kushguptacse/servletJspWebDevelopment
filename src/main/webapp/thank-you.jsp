<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<html>
<head>
<title>Thank you</title>
<script type="text/javascript">
	function updateStatus() {
		var request = new XMLHttpRequest();
		request.onreadystatechange = function() {
			if (this.readyState == 4) {
				var json = JSON.parse(this.responseText);
				document.getElementById("status").innerHTML = json.status;
				document.getElementById("time").innerHTML = "last updated - "
						+ json.time;
			}
		}
		request.open("GET", "updateStatus?id=${orderId}", true);
		request.send();
	}
	window.setInterval(function() {
		updateStatus();
	}, 2000);
</script>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<h1>My Restaurant</h1>
	<p>
		Thank you - your order has been received. You need to pay
		<f:formatNumber currencyCode="${currency}" value="${total}"
			type="currency" />
	</p>
	<p>
		Current Order status is : <span id="status">${status}</span> <input
			type="button" value="refresh status" onclick="updateStatus()" />
	</p>
	<p id="time"/>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>