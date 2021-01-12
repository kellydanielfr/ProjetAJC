package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Context;
import model.Service;
import model.Conge;

@WebServlet("/manager")
public class ServletManager extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Conge> demandeAttente = Context.getInstance().getDaoConge().demandeAttente();
		List<Service> services = Context.getInstance().getDaoService().findAll();
		request.setAttribute("demandes", demandeAttente);
		request.setAttribute("services", services);
		this.getServletContext().getRequestDispatcher("/WEB-INF/manager.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameterMap().containsKey("btnReponse")) {
			String tache = request.getParameter("btnReponse");
			Conge conge = Context.getInstance().getDaoConge().findById(Integer.parseInt(request.getParameter("id_conge")));
			if (tache.equals("Valider")) {
				conge.Valider();
			}else if (tache.equals("Refuser")) {
				conge.Refuser(request.getParameter("motif"));
			}
			Context.getInstance().getDaoConge().save(conge);
			doGet(request,response);
		}else if(request.getParameterMap().containsKey("btnFiltre")) {
			LocalDate dateDebut = LocalDate.parse(request.getParameter("dateDebutFiltre"));
			LocalDate dateFin = LocalDate.parse(request.getParameter("dateFinFiltre"));
			Integer idService = Integer.parseInt(request.getParameter("service"));
			
			List<Conge> listDate = Context.getInstance().getDaoConge().findAllFilterByDate(dateDebut, dateFin);
			request.setAttribute("demandes", listDate);
			this.getServletContext().getRequestDispatcher("/WEB-INF/manager.jsp").forward(request, response);
		}
		
	}
}
