package fr.eni.tpLudotheque.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.eni.tpLudotheque.bo.Genre;

class GenreRowMapper implements RowMapper<Genre> {

	@Override
	public Genre mapRow(ResultSet rs, int rowNum) throws SQLException {
		Genre genre = new Genre();
		genre.setNumeroGenre(rs.getInt("numeroGenre"));
		genre.setLibelle(rs.getString("libelle"));
		return genre;
	}

}

@Repository
public class GenreRepositoryImpl implements GenreRepository {

	private JdbcTemplate jdbcTemplate;

	public GenreRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Genre> findAllGenres() {
		String sql = "select numeroGenre, libelle from genre";
		List<Genre> genres = jdbcTemplate.query(sql, new GenreRowMapper());
		return genres.stream().toList();
	}

	@Override
	public Optional<Genre> getById(int genreId) {
		String sql = "select numeroGenre, libelle from genre where numerogenre = ?";
		Genre genre = jdbcTemplate.queryForObject(sql, new GenreRowMapper(), genreId);
		return Optional.ofNullable(genre);
	}

}
