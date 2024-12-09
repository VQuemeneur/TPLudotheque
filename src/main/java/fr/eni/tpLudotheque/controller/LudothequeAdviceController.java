package fr.eni.tpLudotheque.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = Controller.class)
public class LudothequeAdviceController {
	Logger logger = LoggerFactory.getLogger(LudothequeAdviceController.class);

	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex, Model modele) {
		logger.error(ex.getMessage());
		
		modele.addAttribute("body","erreur");

		return "formulaire";
	}

}
