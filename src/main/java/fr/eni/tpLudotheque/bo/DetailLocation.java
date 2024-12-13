package fr.eni.tpLudotheque.bo;

import java.time.LocalDate;

public class DetailLocation {
	int numeroLigne;
	LocalDate dateRetour;
	double tarifLocation;
	private Exemplaire exemplaire;
	int numeroLocation;

	public DetailLocation() {
		super();

	}

	public DetailLocation(int numeroLigne, LocalDate dateRetour, double tarifLocation, Exemplaire exemplaire,
			int numeroLocation) {
		super();
		this.numeroLigne = numeroLigne;
		this.dateRetour = dateRetour;
		this.tarifLocation = tarifLocation;
		this.exemplaire = exemplaire;
		this.numeroLocation = numeroLocation;

	}

	public int getNumeroLigne() {
		return numeroLigne;
	}

	public void setNumeroLigne(int numeroLigne) {
		this.numeroLigne = numeroLigne;
	}

	public LocalDate getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(LocalDate dateRetour) {
		this.dateRetour = dateRetour;
	}

	public double getTarifLocation() {
		return tarifLocation;
	}

	public void setTarifLocation(double tarifLocation) {
		this.tarifLocation = tarifLocation;
	}

	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	public int getNumeroLocation() {
		return numeroLocation;
	}

	public void setNumeroLocation(int numeroLocation) {
		this.numeroLocation = numeroLocation;
	}

	@Override
	public String toString() {
		return "DetailLocation [noLigne=" + numeroLigne + ", dateRetour=" + dateRetour + ", tarifLocation="
				+ tarifLocation + ", exemplaire=" + exemplaire + "]";
	}

}
