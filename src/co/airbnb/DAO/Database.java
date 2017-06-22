package co.airbnb.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	protected String url = "jdbc:mysql://localhost/airbnb";
	protected String login = "root";
	protected String password = "admin";
	protected Connection connect = null;
	protected Statement stmt = null;
	protected ResultSet resultat = null;
	
	protected String querySql;
	
	//methode qui permet de se connecter à la BDD
	public void ouvrirConnexion() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connect = DriverManager.getConnection(url, login, password);
		
			stmt = connect.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	
	
	public void fermerConnexion() {
		try {
			connect.close();
			stmt.close();
        } catch (SQLException e) {
                e.printStackTrace();
          }
    }
	
}


