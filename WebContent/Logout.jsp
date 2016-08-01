<%

HttpSession ssn = request.getSession(false);

response.setHeader("Cache-control", "no-cache, no-store");
response.setHeader("Pragma", "no-cache");
response.setHeader("Expires", "-1");

if(ssn!=null){
	ssn.removeAttribute("name");
	ssn.invalidate();
	response.sendRedirect("/onlineShopping/Login.jsp");
}
%>