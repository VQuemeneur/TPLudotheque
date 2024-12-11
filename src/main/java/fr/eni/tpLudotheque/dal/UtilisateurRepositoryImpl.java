package fr.eni.tpLudotheque.dal;

import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.tpLudotheque.bo.Utilisateur;


@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepository {

	private JdbcTemplate jdbcTemplate;

	public UtilisateurRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	
	@Override
	public Optional<Utilisateur> findUtilisateurByLogin(String login) {
		String sql = "select id, login, password, role from utilisateur where login=?";
		Utilisateur utilisateur = this.jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Utilisateur.class),
				login);
		return Optional.ofNullable(utilisateur);
	}
}
