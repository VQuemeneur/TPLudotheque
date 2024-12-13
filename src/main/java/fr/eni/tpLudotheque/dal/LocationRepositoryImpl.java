package fr.eni.tpLudotheque.dal;

import java.sql.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.eni.tpLudotheque.bo.DetailLocation;
import fr.eni.tpLudotheque.bo.Location;

/**
 * Classe non terminée, méthode non fonctionnelle
 */
@Repository
public class LocationRepositoryImpl implements LocationRepository {
	Logger logger = LoggerFactory.getLogger(LocationRepositoryImpl.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public LocationRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Transactional
	@Override
	public int ajouterLocation(Location newLocation, DetailLocation detailLocation) {
		logger.debug("avant insert into location...");

		// Convertir LocalDate en java.sql.Date
		Date dateDebutLocation = java.sql.Date.valueOf(newLocation.getDateDebutLocation());

		// Création de la location
		String sqlLocation = "INSERT INTO location (dateDebutLocation, paye, prixTotal, numeroClient) "
				+ "VALUES (:dateDebutLocation, :paye, :prixTotal, :client.numeroClient)";
		KeyHolder locationKeyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sqlLocation, new BeanPropertySqlParameterSource(newLocation),
				locationKeyHolder, new String[] { "numerolocation" });
		Integer cleLocation = locationKeyHolder.getKeyAs(Integer.class);

		logger.info("apres insert into jeux...cleJeu=" + cleLocation);

		return cleLocation;
	}

	// Création du détail de location
//		DetailLocation detail = new DetailLocation();

//		// Étape 2 : Récupérer l'exemplaire correspondant au code-barre
//		String sqlExemplaire = "SELECT numeroExemplaire, codebarre, louable, numeroJeu FROM exemplaire WHERE codebarre = :codebarre";
//		Map<String, Object> params = new HashMap<>();
//		params.put("codebarre", codebarre);
//
//		Exemplaire exemplaire = namedParameterJdbcTemplate.queryForObject(sqlExemplaire, params, (rs, rowNum) -> {
//		    Exemplaire ex = new Exemplaire();
//		    ex.setNumeroExemplaire(rs.getInt("numeroExemplaire"));
//		    ex.setCodebarre(rs.getString("codebarre"));
//		    ex.setLouable(rs.getBoolean("louable"));
//		    ex.setNumeroJeu(rs.getInt("numeroJeu"));
//		    return ex;
//		});
//
//		// Étape 3 : Valider l'existence de l'exemplaire
//		if (exemplaire == null) {
//		    throw new IllegalArgumentException("Aucun exemplaire trouvé pour le code-barre fourni.");
//		}
//
//		// Étape 4 : Associer l'exemplaire et insérer les données
//		detail.setExemplaire(exemplaire);
//		detail.setNumeroLocation(cleLocation);
//
//		Map<String, Object> detailParams = new HashMap<>();
//		detailParams.put("dateRetour", detail.getDateRetour());
//		detailParams.put("tarifLocation", detail.getTarifLocation());
//		detailParams.put("numeroExemplaire", exemplaire.getNumeroExemplaire());
//		detailParams.put("numeroLocation", cleLocation);
//
//		String sqlDetailLocation = "INSERT INTO detailLocation (dateRetour, tarifLocation, numeroExemplaire, numeroLocation) "
//		        + "VALUES (:dateRetour, :tarifLocation, :numeroExemplaire, :numeroLocation)";
//		namedParameterJdbcTemplate.update(sqlDetailLocation, new MapSqlParameterSource(detailParams));
//
//		logger.debug("Après insert into detailLocation...");
//		return cleLocation;
//
//
//	}

	@Override
	public Optional<Location> findLocationsByClientId(int numeroClient) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
