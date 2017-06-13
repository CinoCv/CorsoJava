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
    
    

 <%
ResultSet resultSet;
try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/world?useSSL=false", "Davide",
					"CorsoJava2017");
			Statement createStatement = connection.createStatement();
			resultSet = createStatement.executeQuery("SELECT c.name, c.code FROM world.country c;");
			PrintWriter stamp = response.getWriter();
			stamp.print(" <!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><title>Tutti i paesi</title></head><body><form action=\"CittaPaesi\"><select name=\"paese\">");
			
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String code = resultSet.getString("code");
				stamp.print("<option value=\"" + code + "\">" + code + " " + name + "</option><br>");
				}
			stamp.print(" </select><input type=\"submit\" value=\"Invia\"></form></body></html>");
			
} catch (ClassNotFoundException e) {
	out.print("<h1>ClassNotFoundException</h1>");
	e.printStackTrace();
} catch (SQLException e) {
	out.print("<h1>SQLException</h1>");
	e.printStackTrace();
}
			
			

			
			
			
			%> 