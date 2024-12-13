package fr.eni.tpLudotheque.dal;

import fr.eni.tpLudotheque.bo.Exemplaire;
import fr.eni.tpLudotheque.exceptions.CodeBarreDejaExistantException;

public interface ExemplaireRepository {

	void ajouterExemplaire(Exemplaire exemplaire) throws CodeBarreDejaExistantException;

	Exemplaire findById(int numeroExemplaire);

	void update(Exemplaire exemplaire);

	Exemplaire findExemplaireByCodebarre(String codebarre);

//	boolean isCodebarreUnique(Exemplaire exemplaire);

}
