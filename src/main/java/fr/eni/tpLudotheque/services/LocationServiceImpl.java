package fr.eni.tpLudotheque.services;

import java.util.Optional;

import fr.eni.tpLudotheque.dal.LocationRepository;
import org.springframework.stereotype.Service;

import fr.eni.tpLudotheque.bo.DetailLocation;
import fr.eni.tpLudotheque.bo.Location;

@Service
public class LocationServiceImpl implements LocationService {

	private LocationRepository locationRepo;

	public LocationServiceImpl(LocationRepository locationRepo) {
		super();
		this.locationRepo = locationRepo;
	}

	@Override
	public Optional<Location> findLocationsByClientId(int numeroClient) {

		return locationRepo.findLocationsByClientId(numeroClient);
	}

	@Override
	public int ajouterLocation(Location location, DetailLocation detailLocation) {

		return locationRepo.ajouterLocation(location, detailLocation);
	}

}
