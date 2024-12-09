package fr.eni.tpLudotheque.services;

import fr.eni.tpLudotheque.bo.Exemplaire;
import fr.eni.tpLudotheque.exceptions.CodeBarreDejaExistantException;
import jakarta.validation.Valid;

public interface ExemplaireService {

	void ajouterExemplaire(Exemplaire exemplaire) throws CodeBarreDejaExistantException ;

	Exemplaire findExemplairetById(int numeroExemplaire);

	void modifierExemplaire(Exemplaire exemplaire);






	

}
