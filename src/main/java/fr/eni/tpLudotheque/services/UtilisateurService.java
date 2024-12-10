package fr.eni.tpLudotheque.services;

import java.util.Optional;

import fr.eni.tpLudotheque.bo.Utilisateur;

public interface UtilisateurService {

	Optional<Utilisateur> findUtilisateurByLogin(String login);

}
