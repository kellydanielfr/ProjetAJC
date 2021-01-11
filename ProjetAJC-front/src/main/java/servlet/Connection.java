package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Context;
import model.Manager;
import model.Compte;
import model.Salarie;

@WebServlet("/home")
public class Connection extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Si l'utilisateur est d�j� connect�, on le redirige vers la bonne page
		//Sinon, on affiche l'ecran de connexion
		if(request.getSession().getAttribute("typeCompte")=="admin")
		{
			response.sendRedirect("emp");
		}
		else if(request.getSession().getAttribute("typeCompte")=="employe")
		{
			int idCompte=((Compte) request.getSession().getAttribute("compte")).getId();
			response.sendRedirect("emp?id="+idCompte);

		}
		else
		{
			this.getServletContext().getRequestDispatcher("/accueil.jsp").forward(request, response);
		}


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login=request.getParameter("login");
		String password = request.getParameter("password");
		Compte c = Context.getInstance().getDaoCompte().connect(login, password);

		if(c instanceof Manager) 
		{
			request.getSession().setAttribute("compte", c);
			request.getSession().setAttribute("typeCompte", "admin");
			response.sendRedirect("emp");
		}
		else if(c instanceof Salarie) 
		{
			request.getSession().setAttribute("compte", c);
			request.getSession().setAttribute("typeCompte", "employe");
			response.sendRedirect("emp?id="+c.getId());
		}
		else 
		{
			request.setAttribute("error", "Identifiants invalides");
			doGet(request,response);
		}
	}

}
