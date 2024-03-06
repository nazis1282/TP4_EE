package web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import dao.IProjetDao;
import dao.ProjetDaoImpl;
import metier.entities.Projet;

@WebServlet(name = "cs", urlPatterns = { "/controleur", "*.do" })
public class ControleurServlet extends HttpServlet {
	IProjetDao metier;

	@Override
	public void init() throws ServletException {
		metier = new ProjetDaoImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		if (path.equals("/index.do")) {
			request.getRequestDispatcher("projets.jsp").forward(request, response);
		} else if (path.equals("/chercher.do")) {
			String motCle = request.getParameter("motCle");
			ProjetModele model = new ProjetModele();
			model.setMotCle(motCle);
			List<Projet> prods = metier.projetsParMC(motCle);
			model.setProjets(prods);
			request.setAttribute("model", model);
			request.getRequestDispatcher("projets.jsp").forward(request, response);
		} else if (path.equals("/saisie.do")) {
			request.getRequestDispatcher("saisieProjet.jsp").forward(request, response);
		} else if (path.equals("/save.do") && request.getMethod().equals("POST")) {
			String nom = request.getParameter("nom");
			double cout = Double.parseDouble(request.getParameter("cout"));
			Projet p = metier.save(new Projet(nom, cout));
			request.setAttribute("projet", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		} else if (path.equals("/supprimer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			metier.deleteProjet(id);
			response.sendRedirect("chercher.do?motCle=");
		} else if (path.equals("/editer.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			Projet p = metier.getProjet(id);
			request.setAttribute("projet", p);
			request.getRequestDispatcher("editerProjet.jsp").forward(request, response);
		} else if (path.equals("/update.do")) {
			Long id = Long.parseLong(request.getParameter("id"));
			String nom = request.getParameter("nom");
			double cout = Double.parseDouble(request.getParameter("cout"));
			Projet p = new Projet();
			p.setIdProjet(id);
			p.setNomProjet(nom);
			p.setCout(cout);
			metier.updateProjet(p);
			request.setAttribute("projet", p);
			request.getRequestDispatcher("confirmation.jsp").forward(request, response);
		} else {
			response.sendError(Response.SC_NOT_FOUND);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}