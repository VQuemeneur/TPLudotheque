package fr.eni.tpLudotheque.bo;

import java.time.LocalDate;
import java.util.Objects;

public class DetailLocation {
	int noLigne;
	LocalDate dateRetour;
	double tarifLocation;
	Jeu jeu;
	
	public DetailLocation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetailLocation(int noLigne, LocalDate dateRetour, double tarifLocation, Jeu jeu) {
		super();
		this.noLigne = noLigne;
		this.dateRetour = dateRetour;
		this.tarifLocation = tarifLocation;
		this.jeu = jeu;
	}

	public int getNoLigne() {
		return noLigne;
	}

	public void setNoLigne(int noLigne) {
		this.noLigne = noLigne;
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

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	@Override
	public String toString() {
		return "DetailLocation [noLigne=" + noLigne + ", dateRetour=" + dateRetour + ", tarifLocation=" + tarifLocation
				+ ", jeu=" + jeu + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dateRetour, jeu, noLigne, tarifLocation);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DetailLocation other = (DetailLocation) obj;
		return Objects.equals(dateRetour, other.dateRetour) && Objects.equals(jeu, other.jeu)
				&& noLigne == other.noLigne
				&& Double.doubleToLongBits(tarifLocation) == Double.doubleToLongBits(other.tarifLocation);
	}
	
	
}
