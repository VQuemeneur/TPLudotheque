package fr.eni.tpLudotheque.dal;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.tpLudotheque.bo.Exemplaire;
import fr.eni.tpLudotheque.exceptions.CodeBarreDejaExistantException;

class ExemplaireRowMapper implements RowMapper<Exemplaire> {

	@Override
	public Exemplaire mapRow(ResultSet rs, int rowNum) throws SQLException {
		Exemplaire exemplaire = new Exemplaire();
		exemplaire.setNumeroExemplaire(rs.getInt("numeroExemplaire"));
		exemplaire.setCodebarre(rs.getString("codebarre"));
		exemplaire.setLouable(rs.getBoolean("louable"));
		exemplaire.setNumeroJeu(rs.getInt("numeroJeu"));
		return exemplaire;
	}
}

@Repository
public class ExemplaireRepositoryImpl implements ExemplaireRepository {

	Logger logger = LoggerFactory.getLogger(ExemplaireRepositoryImpl.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	public ExemplaireRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override

	public void ajouterExemplaire(Exemplaire exemplaire) throws CodeBarreDejaExistantException {
		String sql = "INSERT INTO exemplaire (codebarre, louable, numeroJeu) VALUES(:codebarre, :louable, :jeu.numeroJeu)";

		try {
			namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(exemplaire));

		} catch (DuplicateKeyException duplicateKeyException) {
			throw new CodeBarreDejaExistantException(duplicateKeyException);
		}
	}

	@Override
	public Exemplaire findById(int numeroExemplaire) {
		String sql = "select numeroExemplaire, codebarre, louable, numeroJeu from exemplaire where numeroexemplaire = ?";
		Exemplaire exemplaire = jdbcTemplate.queryForObject(sql, new ExemplaireRowMapper(), numeroExemplaire);
		return exemplaire;
	}

	@Override
	public void update(Exemplaire exemplaire) {
		Exemplaire oldExemplaire = findById(exemplaire.getNumeroExemplaire());

		String sql = "UPDATE exemplaire " + "SET " + " codebarre = ?," + " louable = ?," + " numeroJeu = ?" + " WHERE "
				+ " numeroexemplaire = ?;";
		int rowsAffected = jdbcTemplate.update(sql, exemplaire.getCodebarre(), exemplaire.isLouable(),
				exemplaire.getJeu().getNumeroJeu(), exemplaire.getNumeroExemplaire());

	}

	// ajouter la recherche des jeux louables
	@Override
	public Exemplaire findExemplaireByCodebarre(String codebarre) {
		String sql = "select numeroExemplaire, codebarre, louable, numeroJeu from exemplaire where codebarre = ?";
		Exemplaire exemplaire = jdbcTemplate.queryForObject(sql, new ExemplaireRowMapper(), codebarre);
		return exemplaire;
	}

}
