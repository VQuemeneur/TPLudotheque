package fr.eni.tpLudotheque.services;

import fr.eni.tpLudotheque.bo.Exemplaire;
import jakarta.validation.Valid;

public interface ExemplaireService {

	void ajouterExemplaire(Exemplaire exemplaire) ;

	Exemplaire findExemplairetById(int numeroExemplaire);

	void modifierExemplaire(Exemplaire exemplaire);

	boolean isCodebarreUnique( Exemplaire exemplaire);

	String codebarreValide(Exemplaire exemplaire);





	

}
