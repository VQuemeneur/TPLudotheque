package fr.eni.tpLudotheque.bo;

import java.util.Objects;

public class Genre {
	private int numeroGenre;
	private String libelle;
	
	public Genre() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Genre(int numeroGenre, String libelle) {
		super();
		this.numeroGenre = numeroGenre;
		this.libelle = libelle;
	}



	public int getNumeroGenre() {
		return numeroGenre;
	}

	public void setNumeroGenre(int numeroGenre) {
		this.numeroGenre = numeroGenre;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "Genre [numeroGenre=" + numeroGenre + ", libelle=" + libelle + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(libelle, numeroGenre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		return Objects.equals(libelle, other.libelle) && numeroGenre == other.numeroGenre;
	}

}
