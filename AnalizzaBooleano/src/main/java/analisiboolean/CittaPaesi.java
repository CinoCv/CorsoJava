package analisiboolean;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CittaPaesi extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest requestPaesi, HttpServletResponse responsePaesi)
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

			// while (resultSet.next()) {
			// String cityName = resultSet.getString("c.name");
			// String countryName = resultSet.getString("c.countrycode");
			//
			// out.print("<h1>" + "Città: " + cityName + " Paese: " +
			// countryName);
			//
			// out.print("</h1></body></html>");
			// }

		} catch (ClassNotFoundException e) {
			out.print("<h1>ClassNotFoundException</h1>");
			e.printStackTrace();
		} catch (SQLException e) {
			out.print("<h1>SQLException</h1>");
			e.printStackTrace();
		}
	}
}
