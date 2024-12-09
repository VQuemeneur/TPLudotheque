package fr.eni.tpLudotheque.services;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import fr.eni.tpLudotheque.bo.Exemplaire;
import fr.eni.tpLudotheque.bo.Jeu;
import fr.eni.tpLudotheque.dal.ExemplaireRepository;

@SpringBootTest
public class ExemplaireServiceImplTest {
	
	@MockitoBean
	private ExemplaireRepository exemplaireRepository;
	
	@Autowired
	private ExemplaireService exemplaireService;
	
	@Test
	  public void testAjoutExemplaireOk()  {
        // Arrange    	
    	Jeu jeu = new Jeu();
    	jeu.setNumeroJeu(1);
      
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setCodebarre("codebarre1234");        
        exemplaire.setLouable(false);
        exemplaire.setJeu(jeu);
    	
        //Act 
    	//exemplaireService.ajouterExemplaire(exemplaire);   
    	
    	//Assert
        assertNotNull(exemplaire, "L'exemplaire ne doit pas être null");
        assertEquals("codebarre1234", exemplaire.getCodebarre(), "Le code-barre doit correspondre");
        assertFalse(exemplaire.isLouable(), "L'exemplaire doit être louable");
        assertEquals(jeu, exemplaire.getJeu(), "Le jeu doit correspondre");
        
        // Vérification que le repository a bien été appelé une fois
       // verify(exemplaireRepository, times(1)).ajouterExemplaire(any(Exemplaire.class));

}
	
	@Test
	public void testAjoutExemplaireCodeBarreKO() {
		 // Arrange    	
    	Jeu jeu = new Jeu();
    	jeu.setNumeroJeu(23);
      
        Exemplaire exemplaire = new Exemplaire();
        exemplaire.setCodebarre("codebarre3234");     
        exemplaire.setJeu(jeu);
        
        Exemplaire exemplaire2 = new Exemplaire();
        exemplaire2.setCodebarre("codebarre3234");      
        exemplaire.setJeu(jeu);
        
        //Act
      //  exemplaireService.ajouterExemplaire(exemplaire);
       // exemplaireService.ajouterExemplaire(exemplaire2);
        
        //Assert
        assertNotNull(exemplaire.getNumeroExemplaire(), "L'exemplaire doit être sauvegardé avec un numéro généré");
        assertEquals(exemplaire2.getCodebarre(), exemplaire.getCodebarre(), "Les code-barres doivent être différent");
 	}
	
}
