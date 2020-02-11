<html>
<head>
<title>Restaurant - find your favourite dish</title>
</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<h1>Restaurant</h1>
	<h2>Find your favorite dish</h2>
	<form action="searchResults" method="GET">
		Find all dishes containing : <input type="text" name="searchTerm"
			id="searchTerm" /> <input type="submit" value="search" />
	</form>
	<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>