package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		
		request.setAttribute("today", LocalDate.now());
		request.setAttribute("aujourdhui", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/salarie.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCompte=((Compte) request.getSession().getAttribute("compte")).getId();
		if(request.getParameterMap().containsKey("btnAnnuler")) {
			Conge conge = Context.getInstance().getDaoConge().findById(Integer.parseInt(request.getParameter("id_conge")));
			Context.getInstance().getDaoConge().delete(conge);
		}else if(request.getParameterMap().containsKey("btnAjouter")) {
			LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebut"));
			LocalDate dateFin = LocalDate.parse(request.getParameter("dateFin"));
			TypeConge type = TypeConge.valueOf(request.getParameter("type"));
			String motif = request.getParameter("motif");
			
			if(motif.isEmpty()) {
				motif = "";
			}
			
			
			Salarie compte=(Salarie) request.getSession().getAttribute("compte");
			compte = Context.getInstance().getDaoSalarie().save(compte);
			Conge conge = new Conge(compte, type, dateDebut, dateFin, motif);
			Context.getInstance().getDaoConge().save(conge);
		}
		response.sendRedirect("salarie?id="+ idCompte);
	}
}
