<%@page import="java.util.HashMap"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tutti i paesi</title>
</head>
<body>
<form action="tuttiPaesiCittaPost" method="post">
<select name="paese">
 

	<% List<String> listaCodici = (List<String>) request.getAttribute("listaCodici");
	for (String codici : listaCodici) { %>
	<option value="<%=codici%>"> <%=codici %></option>
	<% } %>
			
			</select>
				<input type="submit" value="Invia">
			</form>
</body>
</html>