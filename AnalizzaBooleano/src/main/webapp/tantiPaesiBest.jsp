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
<form action="CittaPaesi">
<select name="paese">
 <% HashMap<String,String> listaCodiciYeah = new HashMap<String,String>();
 try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/world?useSSL=false", "Davide",
							"CorsoJava2017");

					Statement createStatement = connection.createStatement();
					ResultSet resultSet = createStatement
								.executeQuery("SELECT c.Name, c.Code FROM world.country c;");

					while (resultSet.next()) {
						String countryNames = resultSet.getString("c.name");
						String countryCodes = resultSet.getString("c.Code");
						listaCodiciYeah.put( countryCodes, countryNames);
					}

				} catch (ClassNotFoundException e) {
					out.print("<h1>ClassNotFoundException</h1>");
					e.printStackTrace();
				} catch (SQLException e) {
					out.print("<h1>SQLException</h1>");
					e.printStackTrace();
				} %>

	<%
	for (String codici : listaCodiciYeah.keySet()) { %>
	<option value="<%=codici%>"> <%=listaCodiciYeah.get(codici) %> </option><br>
	<%} %>
			
			</select>
				<input type="submit" value="Invia">
			</form>
</body>
</html>