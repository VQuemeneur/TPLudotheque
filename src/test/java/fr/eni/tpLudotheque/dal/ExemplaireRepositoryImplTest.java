package fr.eni.tpLudotheque.dal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import fr.eni.tpLudotheque.bo.Exemplaire;
import fr.eni.tpLudotheque.bo.Jeu;
import fr.eni.tpLudotheque.services.ExemplaireService;

@SpringBootTest
public class ExemplaireRepositoryImplTest {
	
	@MockitoBean
	private ExemplaireRepository exemplaireRepository;
	
	@Autowired
	private ExemplaireService exemplaireService;
	
	
	
	
	
}
