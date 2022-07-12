package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;
import automatizado.page.GooglePO;


public class GoogleTest extends BateTest {
    

    private static GooglePO googlePage;

    @BeforeClass
    public static void preperarTestes(){
        googlePage = new GooglePO(driver); 
    }

    @Test
    public void TC001_deveSerPossivelPequisarNoGoogleOTextoBatataFrita(){
  
        googlePage.pesquisar("Batata frita");

        String resultado = googlePage.obterResultadoDaPesquisa();

        assertTrue(resultado, resultado.contains("Aproximadamente"));
    }

    @Test
    public void TC002_deveSerPossivelPequisarNoGoogleOTextoNutella(){
    
        googlePage.pesquisar("Nutella");

        String resultado = googlePage.obterResultadoDaPesquisa();

        assertTrue(resultado, resultado.contains("resultados"));

    }

}
