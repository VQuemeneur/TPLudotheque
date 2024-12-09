package fr.eni.tpLudotheque.bo;

import java.util.Objects;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Client {
	//@GeneratedValue(strategy = GenerationType.UUID)
	//private UUID id;
	private int numeroClient;
	@NotNull(message = "saisie du nom obligatoire")
	private String nom;
	@NotNull(message = "saisie du prénom obligatoire")
	private String prenom;	
	@Email
	@NotNull(message = "saisie du mail obligatoire")
	private String email;
	@NotNull(message = "saisie de la rue obligatoire")
	private String rue;
	@NotNull
	@Size(max = 5, message = "saisie incorrecte, taille trop importante")
	private String codePostal;
	@NotNull
	private String ville;
	@NotNull
	@Size(max = 10, message = "saisie incorrecte, taille trop importante")
	private String telephone;
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getNumeroClient() {
		return numeroClient;
	}


	public void setNumeroClient(int numeroClient) {
		this.numeroClient = numeroClient;
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


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	@Override
	public String toString() {
		return "Client [numeroClient=" + numeroClient + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email
				+ ", rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville + ", telephone=" + telephone + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(numeroClient);
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
		return numeroClient == other.numeroClient;
	}
	
	

}
