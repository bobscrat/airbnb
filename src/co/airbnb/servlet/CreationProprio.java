package co.airbnb.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.airbnb.beans.ProprietaireBean;
import co.airbnb.DAO.ProprietaireDAO;




@WebServlet("/CreationProprio")
public class CreationProprio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CreationProprio(){
		super();
	}
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		this.getServletContext().getRequestDispatcher( "/WEB-INF/proprietaire.jsp" ).forward( request, response );
	}
	
	public void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		//Instancie un nouveau proprio et set le nom, prenom et tel
		ProprietaireBean proprio = new ProprietaireBean();
			proprio.setNom(request.getParameter("inputNom"));
			proprio.setPrenom(request.getParameter("inputPrenom"));
			proprio.setTelephone(request.getParameter("inputTel"));
		
		ProprietaireDAO proprioDAO = new ProprietaireDAO();
			proprioDAO.ouvrirConnexion();
			proprioDAO.ajouterProprietaire(proprio);
			proprioDAO.fermerConnexion();
		
		this.getServletContext().getRequestDispatcher("/CreationLogement").forward(request, response);
	}
}
