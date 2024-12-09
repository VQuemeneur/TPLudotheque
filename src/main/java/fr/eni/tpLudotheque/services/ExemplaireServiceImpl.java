package fr.eni.tpLudotheque.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import fr.eni.tpLudotheque.bo.Exemplaire;
import fr.eni.tpLudotheque.dal.ExemplaireRepository;
import fr.eni.tpLudotheque.dal.ExemplaireRepositoryImpl;
import jakarta.validation.Valid;

@Service
public class ExemplaireServiceImpl implements ExemplaireService{
	
	Logger logger = LoggerFactory.getLogger(ExemplaireServiceImpl.class);

	private ExemplaireRepository exemplaireRepo;
	
	
	public ExemplaireServiceImpl(ExemplaireRepository exemplaireRepo) {
		super();
		this.exemplaireRepo = exemplaireRepo;
	}


	@Override
	public void ajouterExemplaire(Exemplaire exemplaire)  {
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


	@Override
	public boolean isCodebarreUnique(Exemplaire exemplaire) {
		exemplaireRepo.isCodebarreUnique(exemplaire);
		return false;
	}
	
	public String codebarreValide(Exemplaire exemplaire) {
		
		  try {
		        // Vérification de l'unicité du code-barre
		        if (exemplaireRepo.isCodebarreUnique(exemplaire)) {
		            return exemplaire.getCodebarre();
		        } else {
		            throw new IllegalArgumentException("Le code-barre " + exemplaire.getCodebarre() + " est déjà utilisé.");
		        }
		    } catch (Exception e) {
		        // Log de l'erreur pour le suivi
		        logger.error("Erreur lors de la validation du code-barre : ", e);

		        // Renvoyer le message d'erreur ou une exception personnalisée
		        throw new RuntimeException("Une erreur s'est produite lors de la validation du code-barre : " + e.getMessage());
		    }
	}


}