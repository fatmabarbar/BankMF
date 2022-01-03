package bank.BankMF.metier;

import java.util.Collection;
import java.util.Objects;

public class Client {
	private  int Code;
	private String nom;
	private String prenom;
	private String email;
	public Client(int code, String nom, String prenom, String email) {
		super();
		Code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	public int getCode() {
		return Code;
	}
	public void setCode(int code) {
		Code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Client [Code=" + Code + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(Code);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Code == other.Code;
	}
	public Client(int code, String email) {
		super();
		Code = code;
		this.email = email;
	}
	
	
	
}
