package fr.eni.tpLudotheque.services;

import org.springframework.stereotype.Service;

import fr.eni.tpLudotheque.bo.Exemplaire;
import fr.eni.tpLudotheque.dal.ExemplaireRepository;
import fr.eni.tpLudotheque.exceptions.CodeBarreDejaExistantException;

@Service
public class ExemplaireServiceImpl implements ExemplaireService {

	private ExemplaireRepository exemplaireRepo;

	public ExemplaireServiceImpl(ExemplaireRepository exemplaireRepo) {
		super();
		this.exemplaireRepo = exemplaireRepo;
	}

	@Override
	public void ajouterExemplaire(Exemplaire exemplaire) throws CodeBarreDejaExistantException {
		exemplaireRepo.ajouterExemplaire(exemplaire);

	}

	@Override
	public Exemplaire findExemplairetById(int numeroExemplaire) {
		Exemplaire exemplaire = exemplaireRepo.findById(numeroExemplaire);
		return exemplaire;
	}

	@Override
	public void modifierExemplaire(Exemplaire exemplaire) {
		Exemplaire exemplaireExistant = exemplaireRepo.findById(exemplaire.getNumeroExemplaire());
		exemplaireRepo.update(exemplaire);
	}

}

 