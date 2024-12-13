package fr.eni.tpLudotheque.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.tpLudotheque.bo.Jeu;
import fr.eni.tpLudotheque.dal.GenreRepository;
import fr.eni.tpLudotheque.dal.JeuRepository;

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
