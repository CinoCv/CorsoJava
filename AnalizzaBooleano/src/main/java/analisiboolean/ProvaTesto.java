package analisiboolean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProvaTesto extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String attribute = (String) request.getParameter("testo");

			try {
				int parseInt = Integer.parseInt(attribute);

				out.print("<html><body>");
				out.print("<h1>Hai inserito un numero: " + attribute + "</h1>");
				out.print("</body></html>");

			} catch (NumberFormatException exp) {
				if (attribute.equals("")) {
					out.print("<html><body>");
					out.print("<h1>Non hai inserito nulla :(</h1>");
					out.print("</body></html>");

				} else {
					out.print("<html><body>");
					out.print("<h1>Hai inserito un testo: " + attribute + "</h1>");
					out.print("</body></html>");

				}
			}
		} catch (NullPointerException exp) {
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print("<html><body>");
			out.print("<h1>C'è stato un errore nell'invio, non hai inizializzato il testo</h1>");
			out.print(
					"<img src=\"http://it.personal-travels.com/wp-content/uploads/sites/3/2014/12/Simpson.jpg\" alt=\"Faccia Triste :(\" style=\"width:950px;height:700px\">");
			out.print("</body></html>");
		}
	}
}