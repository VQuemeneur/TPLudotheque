package fr.eni.tpLudotheque.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.tpLudotheque.bo.Client;

class ClientRowMapper implements RowMapper<Client> {

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client client = new Client();
		client.setNumeroClient(rs.getInt("numeroClient"));
		client.setNom(rs.getString("nom"));
		client.setPrenom(rs.getString("prenom"));
		client.setEmail(rs.getString("email"));
		client.setRue(rs.getString("rue"));
		client.setCodePostal(rs.getString("codepostal"));
		client.setVille(rs.getString("ville"));
		client.setTelephone(rs.getString("telephone"));
		return client;
	}

}

@Repository
public class ClientRepositoryImpl implements ClientRepository {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public ClientRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void ajouterClient(Client client) {
		String sql = "insert into client (nom, prenom, email, rue, codePostal, ville, telephone) values(:nom, :prenom, :email, :rue, :codePostal, :ville, :telephone)";
		int nbRows = namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(client));

		if (nbRows != 1) {
			throw new RuntimeException("aucune ligne n'a été ajoutée ???");
		}

	}

	@Override
	public List<Client> findAllClients() {
		String sql = "select numeroClient, nom, prenom, email, rue, codepostal, ville, telephone from client";
		List<Client> clients = jdbcTemplate.query(sql, new ClientRowMapper());

		return clients;
	}

	@Override
	public Client findById(Integer numeroClient) {
		String sql = "select numeroClient, nom, prenom, email, rue, codepostal, ville, telephone from client where numeroclient = ?";
		Client client = jdbcTemplate.queryForObject(sql, new ClientRowMapper(), numeroClient);
		return client;
	}

	@Override
	public void update(Client client) {
		Client oldClient = findById(client.getNumeroClient());

		String sql = "UPDATE client " + "SET " + "    nom = ?, " + "    prenom = ?, " + "    email = ?, "
				+ "    rue = ?, " + "    codePostal = ?, " + "    ville = ?, " + "    telephone = ? " + "WHERE "
				+ "    numeroClient = ?;";

		int rowsAffected = jdbcTemplate.update(sql, client.getNom(), client.getPrenom(), client.getEmail(),
				client.getRue(), client.getCodePostal(), client.getVille(), client.getTelephone(),
				client.getNumeroClient());

	}

	@Override
	public void delete(int numeroClient) {
		Client client = findById(numeroClient);
		System.out.println("numero du client " + numeroClient);
		String sql = "DELETE FROM client WHERE numeroClient = ?";

		int nbRows = jdbcTemplate.update(sql, numeroClient);

	}

}
