package fr.eni.tpLudotheque.bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Jeu {
	
	private int numeroJeu;
	@NotBlank
	private String titre;
	@NotBlank
	@Size(max = 13)
	private String reference;
	private String description;
	private double tarifJournee;
	private int ageMin;
	private int duree;
	
	private List<Genre> genres;
	private List<Exemplaire> exemplaires;
	
	public Jeu() {
		super();
		genres=new ArrayList<>();
		exemplaires= new ArrayList<>();
	}
	
	public Jeu(Integer numeroJeu) {
		this();
		this.numeroJeu = numeroJeu;
	}

	public Jeu(int numeroJeu, @NotBlank String titre, @NotBlank @Size(max = 13) String reference, String description,
			double tarifJournee, int ageMin, int duree, List<Genre> genres, List<Exemplaire> exemplaires) {
		super();
		this.numeroJeu = numeroJeu;
		this.titre = titre;
		this.reference = reference;
		this.description = description;
		this.tarifJournee = tarifJournee;
		this.ageMin = ageMin;
		this.duree = duree;
		this.genres = genres;
		this.exemplaires = exemplaires;
	}

	public int getNumeroJeu() {
		return numeroJeu;
	}


	public void setNumeroJeu(int numeroJeu) {
		this.numeroJeu = numeroJeu;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre(String titre) {
		this.titre = titre;
	}


	public String getReference() {
		return reference;
	}


	public void setReference(String reference) {
		this.reference = reference;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getTarifJournee() {
		return tarifJournee;
	}


	public void setTarifJournee(double tarifJournee) {
		this.tarifJournee = tarifJournee;
	}


	public int getAgeMin() {
		return ageMin;
	}


	public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}


	public int getDuree() {
		return duree;
	}


	public void setDuree(int duree) {
		this.duree = duree;
	}


	public List<Genre> getGenres() {
		return genres;
	}

	public void addGenre(Genre genre) {
		this.genres.add(genre);
	}

	public void setGenres(List<Genre> genres) {
		this.genres = genres;
	}


	public List<Exemplaire> getExemplaires() {
		return exemplaires;
	}
	
	public void addExemplaire(Exemplaire exemplaire) {
		this.exemplaires.add(exemplaire);
	}

	public void setExemplaires(List<Exemplaire> exemplaires) {
		this.exemplaires = exemplaires;
	}

	@Override
	public String toString() {
		return "Jeu [numeroJeu=" + numeroJeu + ", titre=" + titre + ", reference=" + reference + ", description="
				+ description + ", tarifJournee=" + tarifJournee + ", ageMin=" + ageMin + ", duree=" + duree
				+ ", genres=" + genres + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(ageMin, description, duree, genres, numeroJeu, reference, tarifJournee, titre);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jeu other = (Jeu) obj;
		return ageMin == other.ageMin && Objects.equals(description, other.description) && duree == other.duree
				&& Objects.equals(genres, other.genres) && numeroJeu == other.numeroJeu
				&& Objects.equals(reference, other.reference)
				&& Double.doubleToLongBits(tarifJournee) == Double.doubleToLongBits(other.tarifJournee)
				&& Objects.equals(titre, other.titre);
	}


	
}
