package bank.BankMF.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bank.BankMF.metier.Compte;

public class CompteDao {
	public  static void ouvrirCompte(Compte cmp){
		Connection cnx=SConnection.getInstance();

		try{
			String req = "insert into compte(codeCompte, dateCreation , solde, Client) values(?,?,?,?)";
			PreparedStatement sta=cnx.prepareStatement(req);
			sta.setInt(1,cmp.getCodeCompte());
			sta.setObject(2,cmp.getDateCreation());
			sta.setDouble(3,cmp.getSolde());
			sta.setObject(4,cmp.getClient().getCode());
			
			sta.execute();
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}


	}
	public static Boolean updatecompte ( float solde, int CodeCompte){
		Connection cnx=SConnection.getInstance();

		try{
					String req = "update compte set Solde = ? where codeCompte = ?";
					PreparedStatement sta=cnx.prepareStatement(req);
					sta.setFloat(1, solde);
				    sta.setInt(2,CodeCompte);
					return sta.executeUpdate()>0;
				}catch(SQLException e){
					System.out.println(e.getMessage());
				}
		return false;
			}
	public static  Compte consulterCompte(int codeCompte) {

		Connection cnx=SConnection.getInstance();
		Compte c=null;
		 try {
			  PreparedStatement stm=cnx.prepareStatement("select solde from compte where codeCompte=?" );
			  stm.setInt(1, codeCompte);
			  ResultSet set=stm.executeQuery();
			  //Collection c1=null;
			  boolean exist=set.next();
			  if(exist)
				  c=new Compte (codeCompte,set.getDouble(1));
		  
			  else 
				  System.out.println("le compte "+codeCompte+"n'existe pas dans le systeme ");
		  
		  }catch(SQLException e) {
			  e.printStackTrace();  
		  }		
	      System.out.println(c);

		  return c;
	}
	

	public static boolean SupprimerCompte(int codeCompte)
	{		Connection cnx=SConnection.getInstance();
			boolean b=true;
			try{

				String req = "delete from compte where codeCompte = ?";
				PreparedStatement sta=cnx.prepareStatement(req);
				sta.setInt(1,codeCompte);
				b=sta.execute();
			}catch(SQLException e){
				System.out.println(e.getMessage());
			}
			return b;
		}

	
}
