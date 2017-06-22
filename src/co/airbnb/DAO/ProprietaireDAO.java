package co.airbnb.DAO;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.airbnb.beans.ProprietaireBean;

public class ProprietaireDAO extends Database{

	public ProprietaireDAO(){
		super();
	
	}
	
	public void ajouterProprietaire(ProprietaireBean proprio){
		String querySql =  "INSERT INTO `Proprio` (`nom`,`prenom`, `telephone`) VALUES " + 
				"('"+ proprio.getNom() + "', '" + proprio.getPrenom() + 
				"', '" + proprio.getTelephone() + "')";
		
		try {
			stmt.executeUpdate(querySql);
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	
	
	public ArrayList<ProprietaireBean> recupererListeProprietaire(){
		
		ArrayList<ProprietaireBean> listeProprio = new ArrayList<ProprietaireBean>();
		
		
		String querySql = "SELECT * from Proprio";
		
		
		try{
			resultat = stmt.executeQuery(querySql);
			
			//parcours de chaque ligne de ma table proprio
			while(resultat.next()){
				//recuperation des champs de l'nregistrement dans la base
				int id = resultat.getInt("id");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				String tel = resultat.getString("telephone");
				
				
				//creation d'une instance d'un proprio avec les champs recupéré en parametre
				ProprietaireBean proprio = new ProprietaireBean();
				proprio.setId(id);
				proprio.setNom(nom);
				proprio.setPrenom(prenom);
				proprio.setTelephone(tel);
				
				//ajout d'un proprio dans la liste
				listeProprio.add(proprio);
			}

		} catch (SQLException e){
			e.printStackTrace();
		}
	
		return listeProprio;
	}
	
	public void supprimerProprio(){
		
	}
	
}
