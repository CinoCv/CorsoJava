package analisiboolean;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NavigazionePagine extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String parameter = req.getParameter("ciao");
		try {
			int valore = Integer.parseInt(parameter);
			RequestDispatcher requestObj = req.getRequestDispatcher("/new.jsp");
			double quadrato = Math.pow(valore, 2);

			req.setAttribute("quadrato", quadrato);
			requestObj.forward(req, resp);
		} catch (NumberFormatException e) {
			RequestDispatcher requestObj = req.getRequestDispatcher("/altra.jsp");
			req.setAttribute("stringa", parameter.toUpperCase());
			requestObj.forward(req, resp);
		}

	}
}
