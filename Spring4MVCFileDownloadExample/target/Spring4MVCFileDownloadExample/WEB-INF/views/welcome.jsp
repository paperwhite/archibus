<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Spring 4 MVC File Download Example</title>
	<link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"></link>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"></link>
</head>
<body>
	<div class="form-container">
		<h1>Welcome to FileDownloader Example</h1>
		<form method="POST" enctype="multipart/form-data" action="/download">
		File to upload: <input type="file" name="file" ><br /> <br /> 
	<!--	<a href="<c:url value='/download' />"Download This File</a>-->
	<!--  	<button type="submit" name="your_name" value="your_value">Go</button>-->
		
		<input type="submit"
			value="Download" name="action"> Press here to upload the file!
		
		</form>
		
		
	</div> 
</body>
</html>
