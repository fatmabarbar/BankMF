package bank.BankMF.metier;

import java.time.LocalDate;

public class Operation {
	private Long numero;
	private LocalDate dateOperation;
	private double montant;
	private Compte compte;
	public Operation(Long numero, LocalDate dateOperation, double montant) {
		super();
		this.numero = numero;
		this.dateOperation = dateOperation;
		this.montant = montant;
	}
	public Operation(Long numero, LocalDate dateOperation, double montant, Compte compte) {
		super();
		this.numero = numero;
		this.dateOperation = dateOperation;
		this.montant = montant;
		this.compte = compte;
	}
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public LocalDate getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(LocalDate dateOperation) {
		this.dateOperation = dateOperation;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
}
