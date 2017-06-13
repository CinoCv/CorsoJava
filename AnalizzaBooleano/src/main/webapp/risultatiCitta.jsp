<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista Città</title>
</head>
<body>
	Qui stamperò i risultati: <br>



	<% List<String> list = (List<String>) request.getAttribute("list");
	for (String citta : list) { %>
	<%=citta%> <br>
	<% } %>




</body>
</html>