<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
input[type=text],input[type=password] {
	width: 80%;
	float: right;
	padding: 12px 20px;
	box-sizing: border-box;
}
</style>
</head>
<body>
<center>
    <h1>User Login</h1>
    <form name="frm" action="userShopping.jsp" method="post">
        <font size="5">Name:</font> 
        <input type="text" name="name" placeholder="UserName" required/>
        <br><br>
        <font size="5">Password: </font>
        <input type="password" name="password" placeholder="password" required/>
        <br><br>
        <br>
        <input type="submit" name="btn" value="LOGIN" />
    </form>
</center>
</body>
</html>