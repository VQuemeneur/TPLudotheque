package fr.eni.tpLudotheque.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.eni.tpLudotheque.bo.Client;
import fr.eni.tpLudotheque.services.ClientService;
import jakarta.validation.Valid;

@Controller
public class ClientController {

	private ClientService clientService;

	public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

	@ModelAttribute("client")
	public Client createClient() {
		Client c = new Client();
		return c;
	}

	/**
	 * Méthode d'affichage initiale de la page
	 * 
	 * @param model
	 * @return le formulaire d'inscription (et la liste des clients)
	 */
	@GetMapping({ "/", "/ajoutClient" })
	public String accueil(Model model) {
		List<Client> clients = clientService.findAllClients();
		System.out.println("affichage de clients ??");
		model.addAttribute("clients", clients);
		return "formulaire";
	}

	/**
	 * Méthode qui ajoute un client
	 * 
	 * @param client
	 * @return redirige vers la même page
	 */
	@PostMapping("/ajoutClient")
	public String ajouterClient(@Valid @ModelAttribute("client") Client client, BindingResult resultat, Model modele,
			RedirectAttributes redirectAttr) {

		if (resultat.hasErrors()) {
			List<Client> clients = clientService.findAllClients();
			System.out.println("affichage de clients  333 ??");
			modele.addAttribute("clients", clients);
			return "formulaire";

		}
		clientService.ajouterClient(client);
		System.out.println("affichage de clients  222 ??");
		return "redirect:/ajoutClient";
	}

	/**
	 * Méthode qui redirige vers la page du détail d'un client
	 * 
	 * @param numeroClient
	 * @param model
	 * @return redirige vers le détail du client
	 */
	@GetMapping("/client/{numeroClient}")
	public String afficherDetailClient(@PathVariable("numeroClient") int numeroClient, Model model) {
		Client client = clientService.findClientById(numeroClient); // Charge le client depuis le service
		model.addAttribute("client", client);
		return "detailClient"; // Retourne la page detailClient.html
	}

	/**
	 * Méthode qui affiche la page de modification
	 * 
	 * @param numeroClient
	 * @param model
	 * @return
	 */
	@GetMapping("/client/modifier/{numeroClient}")
	public String afficherClient(@PathVariable("numeroClient") int numeroClient, Model model) {
		Client clientOpt = clientService.findClientById(numeroClient);
		model.addAttribute("client", clientOpt);
		System.out.println("Je vais modifier mon client");
		return "modifClient";
	}

	/**
	 * Méthode qui enregistre les modifs
	 * 
	 * @param client
	 * @return
	 */
	@PostMapping("/client/modifier/{numeroClient}")
	public String modifierClient(@PathVariable("numeroClient") int numeroClient,
			@ModelAttribute("client") Client client) {
		Client clientOpt = clientService.findClientById(numeroClient);
		client.setNumeroClient(numeroClient); // Reassigne l'ID au client

		clientService.modifierClient(client);
		System.out.println("Client modifié");
		return "detailClient"; // Redirige vers le détail
	}

	@GetMapping("/client/supprimer/{numeroClient}")
	public String supprimerClient(Model model, @PathVariable("numeroClient") int numeroClient) {
		System.out.println("Client modifié" + numeroClient);
		clientService.delete(numeroClient);

		return "redirect:/ajoutClient";

	}

}
