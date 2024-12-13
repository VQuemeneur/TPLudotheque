package fr.eni.tpLudotheque.services;

import java.util.Optional;

import fr.eni.tpLudotheque.bo.DetailLocation;
import fr.eni.tpLudotheque.bo.Location;

public interface LocationService {

	int ajouterLocation(Location location, DetailLocation detailLocation);

	Optional<Location> findLocationsByClientId(int numeroClient);

}
