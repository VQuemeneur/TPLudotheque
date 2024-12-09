package fr.eni.tpLudotheque.controller;

import java.util.Optional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import fr.eni.tpLudotheque.bo.Genre;
import fr.eni.tpLudotheque.dal.GenreRepository;

@Component
public class StringToGenreConverter implements Converter<String, Genre> {

	private GenreRepository genreRepo;

	public StringToGenreConverter(GenreRepository genreRepo) {
		super();
		this.genreRepo = genreRepo;
	}

	@Override
	public Genre convert(String strGenreId) {
		int genreId = Integer.parseInt(strGenreId);

		Optional<Genre> optGenre = genreRepo.getById(genreId);

		if (optGenre.isPresent()) {

			return optGenre.get();
		}

		throw new RuntimeException("Genre " + strGenreId + " non trouvé");

	}

}
