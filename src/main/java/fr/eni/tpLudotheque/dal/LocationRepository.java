package fr.eni.tpLudotheque.dal;

import java.util.Optional;

import fr.eni.tpLudotheque.bo.DetailLocation;
import fr.eni.tpLudotheque.bo.Location;

public interface LocationRepository {

	int ajouterLocation(Location location, DetailLocation detailLocation);

	Optional<Location> findLocationsByClientId(int numeroClient);

}
