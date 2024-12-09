package fr.eni.tpLudotheque.services;

import java.util.List;

import org.springframework.stereotype.Service;


import fr.eni.tpLudotheque.bo.Client;
import fr.eni.tpLudotheque.bo.Jeu;
import fr.eni.tpLudotheque.dal.GenreRepository;
import fr.eni.tpLudotheque.dal.JeuRepository;
import jakarta.validation.Valid;

@Service
public class JeuServiceImpl implements JeuService {
	
	private JeuRepository jeuRepo;
	private GenreRepository genreRepo;
	

	public JeuServiceImpl(JeuRepository jeuRepo, GenreRepository genreRepo) {
		super();
		this.jeuRepo = jeuRepo;
		this.genreRepo = genreRepo;
	}



	@Override
	public List<Jeu> findAllJeux() {
		// TODO Auto-generated method stub
		return jeuRepo.findAllJeux();
	}



	@Override
	public void ajouterJeu(Jeu jeu) {
		jeuRepo.ajouterJeu(jeu);
		
	}



	@Override
	public Jeu findJeuById(int numeroJeu) {
		Jeu jeu = jeuRepo.findById(numeroJeu);
		return jeu;
	}

}
