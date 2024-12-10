package fr.eni.tpLudotheque.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.eni.tpLudotheque.bo.Client;
import fr.eni.tpLudotheque.bo.Utilisateur;

class UtilisateurRowMapper implements RowMapper<Utilisateur> {

	@Override
	public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setUtilisateurId(rs.getInt("utilisateurId"));
		utilisateur.setLogin(rs.getString("login"));
		utilisateur.setPassword(rs.getString("password"));
		utilisateur.setRole(rs.getString("role"));

		return utilisateur;
	}

}

@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepository {

	private JdbcTemplate jdbcTemplate;

	public UtilisateurRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Utilisateur findByLogin(String login) {
		String sql = "select id, login, password, role from utilisateur where login = ?";
		Utilisateur utilisateur = jdbcTemplate.queryForObject(sql, new UtilisateurRowMapper(), login);
		return utilisateur;
	}

	@Override
	public Optional<Utilisateur> findUtilisateurByLogin(String login) {
		String sql = "select id, login, password, role from utilisateur where login=?";
		Utilisateur utilisateur = this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Utilisateur.class),
				login);
		return Optional.ofNullable(utilisateur);
	}
}
