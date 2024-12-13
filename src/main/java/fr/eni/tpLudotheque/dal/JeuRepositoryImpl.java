package fr.eni.tpLudotheque.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.eni.tpLudotheque.bo.Exemplaire;
import fr.eni.tpLudotheque.bo.Genre;
import fr.eni.tpLudotheque.bo.Jeu;

class JeuRowMapper implements RowMapper<Jeu> {

	@Override
	public Jeu mapRow(ResultSet rs, int rowNum) throws SQLException {
		Jeu jeu = new Jeu();
		jeu.setNumeroJeu(rs.getInt("numeroJeu"));
		jeu.setTitre(rs.getString("titre"));
		jeu.setDescription(rs.getString("description"));
		jeu.setReference(rs.getString("reference"));
		jeu.setTarifJournee(rs.getInt("tarifJournee"));
		jeu.setAgeMin(rs.getInt("ageMin"));
		jeu.setDuree(rs.getInt("duree"));

		return jeu;
	}

}

record JeuGenreDto(Integer numeroJeu, Integer numeroGenre) {
};

@Repository
public class JeuRepositoryImpl implements JeuRepository {
	Logger logger = LoggerFactory.getLogger(JeuRepositoryImpl.class);

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public JeuRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Jeu> findAllJeux() {
		String sql = "SELECT numeroJeu, titre, reference, description, tarifJournee, ageMin, duree FROM jeu ";

		List<Jeu> jeux = jdbcTemplate.query(sql, new JeuRowMapper());

		return jeux;
	}

	@Override
	@Transactional
	public void ajouterJeu(Jeu newJeu) {
		logger.debug("avant insert into jeux...");

		String sql = "INSERT INTO jeu (titre, reference, description, tarifJournee, ageMin, duree) VALUES(:titre, :reference, :description, :tarifJournee, :ageMin, :duree)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(newJeu), keyHolder,
				new String[] { "numerojeu" });
		Integer cleJeu = keyHolder.getKeyAs(Integer.class);
		logger.debug("apres insert into jeux...cleJeu=" + cleJeu);

		List<JeuGenreDto> jeuGenreDtos = newJeu.getGenres().stream()
				.map(genre -> new JeuGenreDto(cleJeu, genre.getNumeroGenre())).toList();

		logger.debug("avant insert into jeu_genre...");
		sql = "insert into jeu_genre (numeroJeu, numeroGenre) values (:numeroJeu,:numeroGenre)";
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(jeuGenreDtos);
		this.namedParameterJdbcTemplate.batchUpdate(sql, batchArgs);
		logger.debug("après insert into jeu_genre...");
	}

	@Override
	public Jeu findById(int numeroJeu) {
		String sql = "select numeroJeu, titre, reference, description, tarifJournee, ageMin, duree from jeu where numerojeu = ?";
		Jeu jeu = jdbcTemplate.queryForObject(sql, new JeuRowMapper(), numeroJeu);

		List<Genre> genres = getGenresByNoJeu(jeu.getNumeroJeu());
		jeu.setGenres(genres);
		List<Exemplaire> exemplaires = getExemplairesByNoJeu(jeu.getNumeroJeu());
		jeu.setExemplaires(exemplaires);
		return jeu;

	}

	private List<Exemplaire> getExemplairesByNoJeu(int numeroJeu) {
		String sql = "select numeroExemplaire, codebarre, louable, numeroJeu " + " from exemplaire "
				+ " where numeroJeu = ? ";
		List<Exemplaire> exemplaires = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Exemplaire.class),
				numeroJeu);
		return exemplaires;
	}

	@Override
	public List<Genre> getGenresByNoJeu(Integer numeroJeu) {
		String sql = "select genre.numeroGenre as numeroGenre, libelle "
				+ " from jeu_genre inner join genre on  jeu_genre.numeroGenre = genre.numeroGenre"
				+ " where jeu_genre.numeroJeu = ? ";
		List<Genre> genres = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Genre.class), numeroJeu);

		return genres;
	}

}
