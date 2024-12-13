package fr.eni.tpLudotheque.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eni.tpLudotheque.bo.Genre;
import fr.eni.tpLudotheque.dal.GenreRepository;

@Service("genreService")
public class GenreServiceImpl implements GenreService {

	private GenreRepository genreRepo;

	public GenreServiceImpl(GenreRepository genreRepo) {
		super();
		this.genreRepo = genreRepo;
	}

	@Override
	public List<Genre> findAllGenres() {

		return genreRepo.findAllGenres();
	}

}
