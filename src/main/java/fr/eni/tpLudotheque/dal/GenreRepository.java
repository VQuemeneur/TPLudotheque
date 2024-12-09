package fr.eni.tpLudotheque.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.tpLudotheque.bo.Genre;

public interface GenreRepository {

	List<Genre> findAllGenres();

	Optional<Genre> getById(int genreId);

}
