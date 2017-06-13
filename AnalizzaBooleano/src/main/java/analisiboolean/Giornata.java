package analisiboolean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Giornata extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {

			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String attribute = (String) request.getParameter("risposta");

			out.print("<html><body>");
			out.print("<h1>Hai selezionato: " + attribute + "</h1>");

			String primo = (String) request.getParameter("primo");
			String secondo = (String) request.getParameter("secondo");
			String terzo = (String) request.getParameter("terzo");

			int somma = 0;
			if (primo != null) {
				somma += 1;
			}
			if (secondo != null) {
				somma += 1;
			}
			if (terzo != null) {
				somma += 1;
			}

			out.print("<h1>Hai selezionato: " + somma + " checkbox</h1>");

			String[] risp = request.getParameterValues("risp");
			out.print("<h1>La frase selezionata è: ");
			for (String str : risp) {
				out.print(str + " ");
			}

			out.print("</h1></body></html>");

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
