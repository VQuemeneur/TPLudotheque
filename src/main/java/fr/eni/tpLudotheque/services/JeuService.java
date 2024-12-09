package fr.eni.tpLudotheque.services;

import java.util.List;

import fr.eni.tpLudotheque.bo.Jeu;
import jakarta.validation.Valid;

public interface JeuService {

	List<Jeu> findAllJeux();

	void ajouterJeu(@Valid Jeu jeu);

	Jeu findJeuById(int numeroJeu);

}
