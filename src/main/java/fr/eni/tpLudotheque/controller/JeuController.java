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

import fr.eni.tpLudotheque.bo.Jeu;

import fr.eni.tpLudotheque.services.JeuService;
import jakarta.validation.Valid;

@Controller
public class JeuController {

	private JeuService jeuService;

	public JeuController(JeuService jeuService) {
		super();
		this.jeuService = jeuService;

	}

	@ModelAttribute("jeu")
	public Jeu createJeu() {
		Jeu j = new Jeu();
		return j;
	}

	@GetMapping({ "/jeu" })
	public String accueil(Model model) {
		List<Jeu> jeux = jeuService.findAllJeux();
		System.out.println("affichage des jeux en BDD");

		model.addAttribute("jeux", jeux);
		return "jeu";
	}

	@GetMapping("/jeu/creer")
	public String ajouterJeu(Model model) {
		System.out.println("Je vais ajouter un nouveau jeu");
		model.addAttribute("jeu", new Jeu()); // Initialise un objet jeu pour le formulaire

		return "ajoutJeu";
	}

	@PostMapping("/jeu/creer")
	public String ajouterJeu(@Valid Jeu jeu, BindingResult resultat, Model modele, RedirectAttributes redirectAttr) {
		// if (resultat.hasErrors()) {

		// return "ajoutJeu"; // Retourne le formulaire avec les erreurs
		// }
		System.out.println("jeu ajouté " + jeu.toString());
		System.out.println("genre " + jeu.getGenres());
		jeuService.ajouterJeu(jeu);
		return "redirect:/jeu";

	}

	@GetMapping("/jeu/{numeroJeu}")
	public String afficherDetailJeu(@PathVariable("numeroJeu") int numeroJeu, Model model) {
		Jeu jeu = jeuService.findJeuById(numeroJeu); // Charge le client depuis le service
		model.addAttribute("jeu", jeu);

		return "detailJeu"; // Retourne la page detailClient.html
	}

}
