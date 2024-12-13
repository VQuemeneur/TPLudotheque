package fr.eni.tpLudotheque.bo;

import java.util.Objects;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Exemplaire {
	private int numeroExemplaire;
	@Size(min = 13, max = 13, message = "Le codebarre doit contenir exactement 13 caractères")
	@NotNull
	private String codebarre;
	private boolean louable;
	private Jeu jeu;
	
	public Exemplaire() {
		super();
		this.jeu = new Jeu();

	}

	public Exemplaire(int numeroExemplaire, String codebarre, boolean louable, Jeu jeu) {
		super();
		this.numeroExemplaire = numeroExemplaire;
		this.codebarre = codebarre;
		this.louable = louable;
		this.jeu = jeu;
	}

	public int getNumeroExemplaire() {
		return numeroExemplaire;
	}

	public void setNumeroExemplaire(int numeroExemplaire) {
		this.numeroExemplaire = numeroExemplaire;
	}

	public String getCodebarre() {
		return codebarre;
	}

	public void setCodebarre(String codebarre) {
		this.codebarre = codebarre;
	}

	public boolean isLouable() {
		return louable;
	}

	public void setLouable(boolean louable) {
		this.louable = louable;
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	public int getNumeroJeu() {
		return jeu != null ? jeu.getNumeroJeu() : 0; // Retourne l'identifiant du jeu
	}

	public void setNumeroJeu(int numeroJeu) {
		if (this.jeu == null) {
			this.jeu = new Jeu();
		}
		this.jeu.setNumeroJeu(numeroJeu); // Met à jour l'identifiant du jeu
	}

	@Override
	public String toString() {
		return "Exemplaire [numeroExemplaire=" + numeroExemplaire + ", codebarre=" + codebarre + ", louable=" + louable
				+ ", jeu=" + jeu + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(codebarre, jeu, louable, numeroExemplaire);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exemplaire other = (Exemplaire) obj;
		return Objects.equals(codebarre, other.codebarre) && Objects.equals(jeu, other.jeu) && louable == other.louable
				&& numeroExemplaire == other.numeroExemplaire;
	}

}
