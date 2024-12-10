package fr.eni.tpLudotheque.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.tpLudotheque.bo.Utilisateur;
import fr.eni.tpLudotheque.dal.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {

	private UtilisateurRepository utilisateurRepo;

	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepo) {
		super();
		this.utilisateurRepo = utilisateurRepo;
	}

	@Override
	public Optional<Utilisateur> findUtilisateurByLogin(String login) {
		return utilisateurRepo.findUtilisateurByLogin(login);
	}

}
