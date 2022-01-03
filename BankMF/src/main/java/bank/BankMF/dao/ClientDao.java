package bank.BankMF.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.BankMF.metier.Client;
import bank.BankMF.metier.Compte;

public class ClientDao {
	public static Client findById(int code) throws SQLException {
		Connection cnx = SConnection.getInstance();
		Client c = null;
		// Collection<Compte> comptes=new ArrayList<Compte>();
		try {
			PreparedStatement stm = cnx.prepareStatement("select nom,prenom,email from client where code=?");
			stm.setInt(1, code);
			ResultSet set = stm.executeQuery();
			// Collection c1=null;
			boolean exist = set.next();
			if (exist)
				c = new Client(code, set.getString("nom"), set.getString("prenom"), set.getString("email"));

			else
				System.out.println("le client " + code + "n'existe pas dans le systeme ");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(c);

		return c;

	}

	public static void ajouterclient(Client cmp) {
		Connection cnx = SConnection.getInstance();

		try {
			String req = ("insert into client(code, nom , prenom, email) values(?,?,?,?)");
			PreparedStatement sta = cnx.prepareStatement(req);
			sta.setInt(1, cmp.getCode());
			sta.setString(2, cmp.getNom());
			sta.setString(3, cmp.getPrenom());
			sta.setString(4, cmp.getEmail());

			sta.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}  

	public static Boolean updateclient(Client cmp ) {
		Connection cnx = SConnection.getInstance();

		try {
			String req = ("update client set email=?  where code =?");
			PreparedStatement pstm = cnx.prepareStatement(req);
			pstm.setInt(1,cmp.getCode());
			pstm.setString(2, cmp.getEmail());
			// pstm.setString(3,e.getPrenom());

			return pstm.executeUpdate()>0;
		} catch (SQLException a) {
			System.out.println(a.getMessage());
		}
return false;

	}

	/*
	 * public void delete (int a) throws SQLException {
	 * 
	 * Connection cnx=SConnection.getInstance(); try { PreparedStatement pstmt
	 * =cnx.prepareStatement("update client where code=?"); pstmt.setInt(1, a); int
	 * n=pstmt.executeUpdate(); if(n==1)
	 * System.out.println("le client "+a+" a ete archive avec succes"); else
	 * System.out.println("le client "+a+"n'existe pas ");
	 * 
	 * 
	 * }catch (SQLException e) { e.printStackTrace(); } }
	 */
	public static boolean SupprimerClient(int code) {
		Connection cnx = SConnection.getInstance();
		boolean b = true;
		try {

			String req = "delete from client where code = ?";
			PreparedStatement sta = cnx.prepareStatement(req);
			sta.setInt(1, code);
			b = sta.execute();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return b;
	}

	public Compte consulterCompte(int codeCompte) {
		Connection cnx = SConnection.getInstance();
		String req = "select * from compte where codeCompte=" + codeCompte;
		PreparedStatement s = null;
		Compte cpt = new Compte();

		try {
			s = cnx.prepareStatement(req);
			ResultSet resultats = s.executeQuery(req);
			resultats.next();
			cpt.setCodeCompte(resultats.getInt(1));
			cpt.setSolde(resultats.getLong(2));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cpt;

	}
}
