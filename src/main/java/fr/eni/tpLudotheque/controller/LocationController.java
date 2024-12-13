package fr.eni.tpLudotheque.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.eni.tpLudotheque.bo.Client;
import fr.eni.tpLudotheque.bo.DetailLocation;
import fr.eni.tpLudotheque.bo.Exemplaire;
import fr.eni.tpLudotheque.bo.Location;
import fr.eni.tpLudotheque.services.ClientService;
import fr.eni.tpLudotheque.services.ExemplaireService;

import fr.eni.tpLudotheque.services.LocationService;
import jakarta.validation.Valid;

@Controller
public class LocationController {

	private ClientService clientService;
	private LocationService locationService;
	private ExemplaireService exemplaireService;

	public LocationController(ClientService clientService, LocationService locationService,
			ExemplaireService exemplaireService) {
		super();
		this.clientService = clientService;
		this.locationService = locationService;
		this.exemplaireService = exemplaireService;
	}

	@ModelAttribute("location")
	public Location createLocation() {
		Location l = new Location();
		return l;
	}

	@GetMapping({ "/client/{numeroClient}/location" })
	public String location(@PathVariable("numeroClient") int numeroClient, Model model) {
		Client client = clientService.findClientById(numeroClient);
		if (client == null) {
			throw new IllegalArgumentException("Client non trouvé !");
		}

		Location location = new Location();
		location.setClient(client);

		// Ajouter une entrée vide pour permettre la saisie
		DetailLocation detailLocation = new DetailLocation();
		detailLocation.setExemplaire(new Exemplaire());
		// detailLocation.setNumeroLigne.add(detailLocation);
		model.addAttribute("location", location);

		return "location";
	}

	/**
	 * Méthode non fonctionnelle, ne permet pas d'enregistrer les exemplaires pour
	 * l'instant
	 * 
	 * @param numeroClient
	 * @param codebarre
	 * @param location
	 * @param resultat
	 * @param modele
	 * @param redirectAttr
	 * @return
	 */
	@PostMapping({ "/client/{numeroClient}/location" })
	public String ajouterLocation(@PathVariable("numeroClient") int numeroClient,
			@RequestParam("codebarre") String codebarre, @Valid @ModelAttribute("location") Location location,
			BindingResult resultat, Model modele, RedirectAttributes redirectAttr) {
		Client client = clientService.findClientById(numeroClient);
		if (client == null) {
			throw new IllegalArgumentException("Client non trouvé !");
		}

		// Associate the client with the location
		location.setClient(client);

		// Exemplaire exemplaire =
		// exemplaireService.findExemplairetByCodebarre(codebarre);

		if (resultat.hasErrors()) {
			Optional<Location> locations = locationService.findLocationsByClientId(numeroClient);
			modele.addAttribute("locations", locations);
			return "location";
		}

		// Ajouter le code-barre à l'exemplaire de la location
		Exemplaire exemplaire = new Exemplaire();
		exemplaire.setCodebarre(codebarre);

		DetailLocation detailLocation = new DetailLocation();
		detailLocation.setExemplaire(exemplaire);

		if (resultat.hasErrors()) {
			Optional<Location> locations = locationService.findLocationsByClientId(numeroClient);
			modele.addAttribute("locations", locations);

			return "location";

		}
		int numeroLocation = locationService.ajouterLocation(location, detailLocation);

		detailLocation.setNumeroLocation(numeroLocation);

		return "location";
	}

}
