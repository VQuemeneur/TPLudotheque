package fr.eni.tpLudotheque.bo;

import java.time.LocalDate;

public class Location {
	int numeroLocation;
	LocalDate dateDebutLocation;
	boolean paye;
	double prixTotal;

	Client client;

	public Location() {
		super();

	}

	public Location(int numeroLocation, LocalDate dateDebutLocation, boolean paye, double prixTotal, Client client) {
		super();
		this.numeroLocation = numeroLocation;
		this.dateDebutLocation = dateDebutLocation;
		this.paye = paye;
		this.prixTotal = prixTotal;
		this.client = client;
	}

	public int getNumeroLocation() {
		return numeroLocation;
	}

	public void setNumeroLocation(int numeroLocation) {
		this.numeroLocation = numeroLocation;
	}

	public LocalDate getDateDebutLocation() {
		return dateDebutLocation;
	}

	public void setDateDebutLocation(LocalDate dateDebutLocation) {
		this.dateDebutLocation = dateDebutLocation;
	}

	public boolean isPaye() {
		return paye;
	}

	public void setPaye(boolean paye) {
		this.paye = paye;
	}

	public double getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(double prixTotal) {
		this.prixTotal = prixTotal;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Location [numeroLocation=" + numeroLocation + ", dateDebutLocation=" + dateDebutLocation + ", paye="
				+ paye + ", prixTotal=" + prixTotal + ", client=" + client + "]";
	}

}
