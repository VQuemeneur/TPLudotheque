package fr.eni.tpLudotheque.bo;

import java.util.Objects;

public class Utilisateur {
	int utilisateurId;
	String login;
	String password;
	String role;
	
	public Utilisateur() {
		super();
		
	}

	public Utilisateur(int utilisateurId, String login, String password, String role) {
		super();
		this.utilisateurId = utilisateurId;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public int getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(int utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Utilisateur [utilisateurId=" + utilisateurId + ", login=" + login + ", password=" + password + ", role="
				+ role + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(login, password, role, utilisateurId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return Objects.equals(login, other.login) && Objects.equals(password, other.password)
				&& Objects.equals(role, other.role) && utilisateurId == other.utilisateurId;
	}

	
}
