package bank.BankMF;

import java.sql.SQLException;
import java.util.Date;

import bank.BankMF.dao.ClientDao;
import bank.BankMF.dao.CompteDao;
import bank.BankMF.metier.Client;
import bank.BankMF.metier.Compte;

public class Test {
	public static void main(String[] args) throws SQLException{
		// TODO Auto-generated method stub
		Client
		c1= new Client(222,"barbar","fatma","fatmabarbar1@gmail.com");
		Client c2= new Client(252,"barbar","fatma","fatmabarbar@gmail.com");
		Client c3= new Client(233,"ghatasi","mariem","fatmabarbar1@gmail.com");
		Client c4= new Client(283,"fffdfdd","mnhjhjhh","hhjjikooo1@gmail.com");
		Client c5= new Client(299,"ghatassi","mariem","mariem12ghs @gmail.com");

Date dt1=new Date(2021, 02, 03);
Date dt2=new Date(2020, 02, 03);
Date dt3=new Date(2021, 05, 03);

Compte d1= new Compte(123,dt1,123.3,c1);
Compte d3= new Compte(444,dt2,155.3,c2);
Compte d2= new Compte(122,dt3,125.3,c3);

CompteDao dao1= new CompteDao();
ClientDao d = new ClientDao();


d.ajouterclient(c1);
d.ajouterclient(c2);
d.ajouterclient(c3);
d.ajouterclient(c4);
d.ajouterclient(c5);
dao1.ouvrirCompte(d1);
dao1.ouvrirCompte(d3);
dao1.ouvrirCompte(d2);

//c4.setEmail();
//d.updateclient("fatmabarbar@yahoo.fr" , 299);
//dao1.updatecompte(d2,555);
//dao1.SupprimerCompte(122);
//dao1.consulterCompte(123);
//d.SupprimerClient(233);
d.findById(222);

	}
}
