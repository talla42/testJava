package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pagina;
import service.BuscadorService;
import service.BuscadorServiceFactory;

/**
 * Servlet implementation class Buscar
 */
@WebServlet("/Buscar")
public class Buscar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BuscadorService service = BuscadorServiceFactory.getBuscadorService();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		String clave = req.getParameter("clave");

		out.println("<html><body>");

		for (Pagina pagina : service.buscar(clave)) {
			out.println("<a href='" + pagina.getUrl() + "'>");
			out.println(pagina.getTitulo());
			out.println("</a></br>");
		}

		out.println("</body></html>");
	}

}
