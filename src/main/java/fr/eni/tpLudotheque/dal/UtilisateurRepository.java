package fr.eni.tpLudotheque.dal;

import java.util.Optional;

import fr.eni.tpLudotheque.bo.Utilisateur;

public interface UtilisateurRepository {

	Utilisateur findByLogin(String user);

	Optional<Utilisateur> findUtilisateurByLogin(String login);

}
