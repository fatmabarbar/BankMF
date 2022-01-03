package bank.BankMF.metier;

import java.util.Date;
import java.util.Objects;

public class Compte {
	private int codeCompte;
	private Date dateCreation ;
	private double solde;
    private Client Client;
	public Compte(int codeCompte, Date dateCreation, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
	}
	public Compte(int codeCompte, double solde) {
		super();
		this.codeCompte = codeCompte;
		this.solde = solde;
	}
	public Compte(int codeCompte, Date dateCreation, double solde, Client Client) {
		super();
		this.codeCompte = codeCompte;
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.Client = Client;
	}
	
	
	public int getCodeCompte() {
		return codeCompte;
	}
	public void setCodeCompte(int codeCompte) {
		this.codeCompte = codeCompte;
	}
	public Client getClient() {
		return Client;
	}
	public void setClient(Client eClient) {
		this.Client = Client;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	@Override
	public String toString() {
		return "Compte [codeCompte=" + codeCompte + ", dateCreation=" + dateCreation + ", solde=" + solde
				+ ", codeClient=" + Client + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(codeCompte);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		return codeCompte == other.codeCompte;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
