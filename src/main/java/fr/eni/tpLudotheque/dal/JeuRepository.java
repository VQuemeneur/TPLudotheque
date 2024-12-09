package fr.eni.tpLudotheque.dal;

import java.util.List;

import fr.eni.tpLudotheque.bo.Genre;
import fr.eni.tpLudotheque.bo.Jeu;
import jakarta.validation.Valid;

public interface JeuRepository {

	List<Jeu> findAllJeux();

	void ajouterJeu(@Valid Jeu jeu);

	Jeu findById(int numeroJeu);

	List<Genre> getGenresByNoJeu(Integer numeroJeu);

}
