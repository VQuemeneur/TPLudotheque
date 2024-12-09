package fr.eni.tpLudotheque.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.eni.tpLudotheque.bo.Client;
import fr.eni.tpLudotheque.bo.Exemplaire;
import fr.eni.tpLudotheque.bo.Jeu;
import fr.eni.tpLudotheque.exceptions.CodeBarreDejaExistantException;
import fr.eni.tpLudotheque.services.ExemplaireService;
import jakarta.validation.Valid;

@Controller
public class ExemplaireController {

	private ExemplaireService exemplaireService;

	public ExemplaireController(ExemplaireService exemplaireService) {
		super();
		this.exemplaireService = exemplaireService;
	}

	@ModelAttribute("exemplaire")
	public Exemplaire createExemplaire() {
		Exemplaire e = new Exemplaire();
		return e;
	}

	@GetMapping("/jeu/{numeroJeu}/ajouterExemplaire")
	public String ajouterExemplaire(@PathVariable("numeroJeu") int numeroJeu, Model model) {
		System.out.println("Je vais ajouter un nouvel exemplaire");
		model.addAttribute("exemplaire", new Exemplaire());
		return "ajoutExemplaire";

	}

	@PostMapping("/jeu/{numeroJeu}/ajouterExemplaire")
	public String ajouterExemplaire(@PathVariable("numeroJeu") int numeroJeu, @Valid Exemplaire exemplaire,
			BindingResult resultat, Model modele, RedirectAttributes redirectAttr) {
		
		// Vérification des erreurs de validation
		if (resultat.hasErrors()) {
			modele.addAttribute("org.springframework.validation.BindingResult.exemplaire", resultat);
			modele.addAttribute("exemplaire", exemplaire);
			return "ajoutExemplaire";
		}		
		try {
			exemplaireService.ajouterExemplaire(exemplaire);
		} catch (CodeBarreDejaExistantException e) {
			redirectAttr.addFlashAttribute("erreur", "codebarre déjà existant");
			return "ajoutExemplaire";
		}
		System.out.println("exemplaire ajouté " + exemplaire.toString());
		return "redirect:/jeu/" + exemplaire.getNumeroJeu();
		
	}

	@GetMapping("/jeu/{numeroJeu}/{numeroExemplaire}")
	public String afficherExemplaire(@PathVariable("numeroJeu") int numeroJeu,
			@PathVariable("numeroExemplaire") int numeroExemplaire, Model model) {

		Exemplaire exemplaireMod = exemplaireService.findExemplairetById(numeroExemplaire);
		if (exemplaireMod == null) {
			throw new IllegalArgumentException("Exemplaire introuvable avec l'ID : " + numeroExemplaire);
		}

		Jeu jeu = exemplaireMod.getJeu(); // Obtenez l'objet `Jeu` associé
		if (jeu == null) {
			jeu = new Jeu();
			jeu.setNumeroJeu(numeroJeu); // Définit un jeu vide si absent
		}
		System.out.println("exemplaire à modifier " + exemplaireMod.toString());
		model.addAttribute("exemplaire", exemplaireMod);
		model.addAttribute("jeu", jeu);
		return "modifExemp";
	}

	@PostMapping("/jeu/{numeroJeu}/{numeroExemplaire}")
	public String modifierExemplaire(@PathVariable("numeroJeu") int numeroJeu,
			@PathVariable("numeroExemplaire") int numeroExemplaire,
			@ModelAttribute("exemplaire") Exemplaire exemplaire) {
		Exemplaire exemplaireMod = exemplaireService.findExemplairetById(numeroExemplaire);
		exemplaire.setNumeroExemplaire(numeroExemplaire);

		exemplaireService.modifierExemplaire(exemplaire);
		System.out.println("Exemplaire modifié");
		return "redirect:/jeu/{numeroJeu}"; // Redirige vers le détail
	}

}
