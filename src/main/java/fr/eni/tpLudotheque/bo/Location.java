package fr.eni.tpLudotheque.bo;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Location {
	int numeroLocation;
	LocalDate dateDebutLocation;
	boolean paye;
	double prixTotal;
	DetailLocation detailLocation;
	Client client;
	
	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Location(int numeroLocation, LocalDate dateDebutLocation, boolean paye, double prixTotal,
			DetailLocation detailLocation, Client client) {
		super();
		this.numeroLocation = numeroLocation;
		this.dateDebutLocation = dateDebutLocation;
		this.paye = paye;
		this.prixTotal = prixTotal;
		this.detailLocation = detailLocation;
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

	public DetailLocation getDetailLocation() {
		return detailLocation;
	}

	public void setDetailLocation(DetailLocation detailLocation) {
		this.detailLocation = detailLocation;
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
				+ paye + ", prixTotal=" + prixTotal + ", detailLocation=" + detailLocation + ", client=" + client + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(client, dateDebutLocation, detailLocation, numeroLocation, paye, prixTotal);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Location other = (Location) obj;
		return Objects.equals(client, other.client) && Objects.equals(dateDebutLocation, other.dateDebutLocation)
				&& Objects.equals(detailLocation, other.detailLocation) && numeroLocation == other.numeroLocation
				&& paye == other.paye && Double.doubleToLongBits(prixTotal) == Double.doubleToLongBits(other.prixTotal);
	}
	
	
	
	
}
