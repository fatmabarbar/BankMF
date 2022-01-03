package bank.BankMF.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SConnection {
	private static String url = "jdbc:mysql://localhost:3306/db_bank";
	private static String utilisateur= "root";
	private static String motPasse="";
	private static Connection cnx;
	//=============== getInstance() ============================
	public static Connection getInstance()
	{
	try {
	if(cnx==null || cnx.isClosed()) {
	Class.forName("com.mysql.jdbc.Driver");
	cnx=DriverManager.getConnection(url,utilisateur,motPasse);
	System.out.println("Connexion � la base de donn�es ");
	}
	}
	catch (ClassNotFoundException e) {
	System.out.println("Classe Driver introuvable");
	}
	catch (SQLException e) {
	System.out.println("L'�tablissement de la connexion a �chou�.");
	}
	return cnx;
	}
	static void close() throws SQLException {
	try {
	if(cnx != null && !cnx.isClosed())
	cnx.close();
	}catch(SQLException e) {
	e.printStackTrace();
	}
	}
}
