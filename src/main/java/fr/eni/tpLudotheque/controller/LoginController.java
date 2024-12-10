package fr.eni.tpLudotheque.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class LoginController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/login")
	public String login() {
	
		return "login";
	}

	@GetMapping("/chiffre")
	public String chiffre() {
		System.out.println( passwordEncoder.encode("password"));
		
		return "redirect:/jeu";
	}
}

