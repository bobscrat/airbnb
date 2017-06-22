package co.airbnb.servlet;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.airbnb.beans.ProprietaireBean;
import co.airbnb.DAO.ProprietaireDAO;



@WebServlet("/CreationLogement")
public class CreationLogement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public CreationLogement(){
		super();
	}
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		
		ProprietaireDAO proprioDAO = new ProprietaireDAO();
		ArrayList<ProprietaireBean> maListe = null;
		
		proprioDAO.ouvrirConnexion();
		try{
		maListe = proprioDAO.recupererListeProprietaire();
		} catch (Exception e){
			System.out.println(e);
		}
		System.out.println(maListe);
		
		request.setAttribute("test", maListe);

		
		this.getServletContext().getRequestDispatcher( "/WEB-INF/logement.jsp" ).forward( request, response );
	}
	
	public void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		doGet(request, response);
		
	}
}
