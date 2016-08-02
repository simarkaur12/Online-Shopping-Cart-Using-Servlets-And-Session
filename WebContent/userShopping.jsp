<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
select {
	width: 70%;
	padding: 16px 20px;
	border: none;
	float: right;
	border-radius: 4px;
	background-color: #f1f1f1;
}
</style>
</head>
<body>

<br><br>
	<form action="SaveToCart" method="post">
		<select id="items" multiple="multiple" name="items">
			<option value="select">Select</option>
			<option value="mobile,20000">Mobile,Cost=20000</option>
			<option value="laptop,50000">Laptop,Cost=50000</option>
			<option value="mouse,5000">Mouse,Cost=5000</option>
			<option value="pen,200">Pen,Cost=200</option>
		</select> <input type="submit" value="Add To Cart">
	</form>
<br><br>
	<form action="ShowCart" method="post">
		<input type="submit" value="Show All Items">
	</form>
<br><br>   
	<form action="Logout.jsp" method="post">
	   <input type="submit" value="Logout">
	</form>
</body>
</html>