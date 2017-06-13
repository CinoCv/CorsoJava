package analisiboolean;

	import java.io.IOException;
	import java.io.PrintWriter;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	public class TuttiPaesiCittaPost extends HttpServlet {
		private static final long serialVersionUID = 1L;
			@Override
			protected void doGet(HttpServletRequest requestPaesi, HttpServletResponse responsePaesi)
					throws ServletException, IOException {
				PrintWriter out = responsePaesi.getWriter();

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/world?useSSL=false", "root", "banana");

					Statement createStatement = connection.createStatement();
					ResultSet resultSet = createStatement
								.executeQuery("SELECT c.Name, c.Code FROM world.country c;");

					List<String> listaPaesi = new ArrayList<String>();
					List<String> listaCodici = new ArrayList<String>();

					while (resultSet.next()) {
						String countryNames = resultSet.getString("c.Name");
						String countryCodes = resultSet.getString("c.Code");
						listaPaesi.add(countryNames);
						listaCodici.add(countryCodes);
					}

					requestPaesi.setAttribute("listaCodici", listaCodici);
					RequestDispatcher requestObj = requestPaesi.getRequestDispatcher("/tantiPaesiPost.jsp");
					requestObj.forward(requestPaesi, responsePaesi);


				} catch (ClassNotFoundException e) {
					out.print("<h1>ClassNotFoundException</h1>");
					e.printStackTrace();
				} catch (SQLException e) {
					out.print("<h1>SQLException</h1>");
					e.printStackTrace();
				}
			}
			
			@Override
			protected void doPost(HttpServletRequest requestPaesi, HttpServletResponse responsePaesi)
					throws ServletException, IOException {
				String parameter = requestPaesi.getParameter("paese");
				PrintWriter out = responsePaesi.getWriter();

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/world?useSSL=false", "root", "banana");

					PreparedStatement prepared = connection
							.prepareStatement("SELECT c.name FROM world.city c where c.countrycode = ?;");
					prepared.setString(1, parameter);
					ResultSet resultSet = prepared.executeQuery();
					out.print("<h1>Hai selezionato: " + parameter + "</h1>");

					List<String> listaCitta = new ArrayList<String>();

					while (resultSet.next()) {
						String cityName = resultSet.getString("c.name");

						listaCitta.add(cityName);
					}

					requestPaesi.setAttribute("list", listaCitta);
					RequestDispatcher requestObj = requestPaesi.getRequestDispatcher("/risultatiCitta.jsp");
					requestObj.forward(requestPaesi, responsePaesi);

				} catch (ClassNotFoundException e) {
					out.print("<h1>ClassNotFoundException</h1>");
					e.printStackTrace();
				} catch (SQLException e) {
					out.print("<h1>SQLException</h1>");
					e.printStackTrace();
				}
			}
			
		}
