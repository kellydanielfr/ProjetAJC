package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Context;
import model.*;

@WebServlet("/salarie")
public class ServletSalarie extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Conge> conges = Context.getInstance().getDaoConge().demandeSalarie(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("demandes", conges);
		this.getServletContext().getRequestDispatcher("/WEB-INF/salarie.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tache = request.getParameter("btnAnnuler");
		Conge conge = Context.getInstance().getDaoConge().findById(Integer.parseInt(request.getParameter("id_conge")));
		if (tache.equals("Annuler")) {
			Context.getInstance().getDaoConge().delete(conge);
		}
		int idCompte=((Compte) request.getSession().getAttribute("compte")).getId();
		response.sendRedirect("salarie?id="+ idCompte);
		
	}
}
