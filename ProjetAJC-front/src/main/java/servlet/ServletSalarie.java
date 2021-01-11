package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Context;
import model.Salarie;
import model.PC;

@WebServlet("/emp")
public class Servlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		if(id !=null) 
		{
			Salarie e = Context.getInstance().getDaoSalarie().findById(Integer.parseInt(id));
			request.setAttribute("emp", e);
			this.getServletContext().getRequestDispatcher("/WEB-INF/employe.jsp").forward(request, response);
		}
		else 
		{
			List<Salarie> employes = Context.getInstance().getDaoSalarie().findAll();



			request.setAttribute("employes", employes);

			this.getServletContext().getRequestDispatcher("/pc").forward(request, response);
		}


	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tache = request.getParameter("btnForm");
		if(tache.equals("Ajouter")) 
		{
			Integer idPC = Integer.parseInt(request.getParameter("id_pc"));
			String login = request.getParameter("login");
			String password =request.getParameter("password");
			String mail = request.getParameter("mail");

			PC pc = Context.getInstance().getDaoPC().findById(idPC);
			Salarie e = new Salarie(login, password, mail, pc);
			Context.getInstance().getDaoSalarie().save(e);
			response.sendRedirect("emp");
		}
		else if(tache.equals("Modifier")) 
		{
			Integer id = Integer.parseInt(request.getParameter("id_emp"));
			Integer idPC = Integer.parseInt(request.getParameter("id_pc"));
			String login = request.getParameter("login");
			String password =request.getParameter("password");
			String mail = request.getParameter("mail");

			PC pc = Context.getInstance().getDaoPC().findById(idPC);
			Salarie e = Context.getInstance().getDaoSalarie().findById(id);
			e.setLogin(login);
			e.setMail(mail);
			e.setPassword(password);
			e.setPc(pc);

			Context.getInstance().getDaoSalarie().save(e);

			if(request.getSession().getAttribute("compte") instanceof Salarie) 
			{
				response.sendRedirect("emp?id="+id);
			}
			else 
			{
				response.sendRedirect("emp");
			}
		}
		else if(tache.equals("Supprimer")) 
		{
			doDelete(request,response);

		}


	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Integer id = Integer.parseInt(request.getParameter("id_emp"));
		Salarie e = Context.getInstance().getDaoSalarie().findById(id);
		Context.getInstance().getDaoSalarie().delete(e);
		response.sendRedirect("emp");
	}
}
