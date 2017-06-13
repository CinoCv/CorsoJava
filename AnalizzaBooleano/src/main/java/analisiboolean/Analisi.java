package analisiboolean;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Analisi extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String attribute = (String) request.getParameter("testo");
		if (attribute == null) {
			out.print("<html><body>");
			out.print("<h1>Aggiungi ?testo=valore al link per analizzarlo (sostituisci *valore*)</h1>");
			out.print("</body></html>");
		} else if (attribute != null && (attribute.equals("false") || attribute.equals("true"))) {
			out.print("<html><body>");
			out.print("<h1>Hai inserito un valore booleano: " + attribute + "</h1>");
			out.print("</body></html>");

		} else {
			out.print("<html><body>");
			out.print("<h1>Il valore inserito non risulta essere booleano.\nHai inserito: " + attribute + "</h1>");
			out.print("</body></html>");
		}

	}

}
