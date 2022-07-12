package automatizado.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import automatizado.Page.GooglePO;

public class GoogleTest extends BaseTest {

    private static GooglePO googlePage;

    @BeforeClass    
    public static void prepararTestes() {
        googlePage = new GooglePO(driver);
    }
    @Test
    public void TC001_devePesquisarNoGoogleOTextoHotwheels() {
        

        //WebElement inputPesquisa = driver.findElement(By.name("q"));
        //googlePage.inputPesquisa.sendKeys("Hotwheels" + Keys.ENTER);

        googlePage.pesquisar("Hotwheels");

        String resultado = googlePage.obterResultadoDaPesquisa();
        
        assertTrue(resultado, resultado.contains("Aproximadamente"));
               

    }
    @Test
    public void TC002_devePesquisarNoGoogleOTextoRisiaKristinne() {
        

        //WebElement inputPesquisa = driver.findElement(By.name("q"));
        //googlePage.inputPesquisa.sendKeys("Risia Kristinne" + Keys.ENTER);
        googlePage.pesquisar("Risia Kristinne");
        
        String resultado = googlePage.obterResultadoDaPesquisa();
        
        assertTrue(resultado, resultado.contains("resultados"));

        
    }
}
