package automatizado.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Classe base que sevre de herança para todas as classes de testes
 */

public abstract class BaseTest {
    
    /** Driver do navegador da página atual */
    protected static WebDriver driver;
    /** Caminho base da URL do sistema a ser testado */
    private static final String URL_BASE = "file:///C:/Users/Carlos/Meu%20Drive/Programa%C3%A7%C3%A3o/Teste%20Automatizado/sistema/login.html";
    /** Caminho relativo do driver ao projeto referente ao PEF */
    private static final String CAMINHO_DRIVER = "src/test/java/automatizado/resource/chromedriver-v1030506053.exe";
    
    /** 
     * Método para iniciar o driver do navegador antes de qualquer classe de teste.
     */
    @BeforeClass
    public static void iniciar() {
        System.setProperty("webdriver.chrome.driver", CAMINHO_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_BASE);
    }

    /**
     * Método para finalizar o driver do navegador depois de qualquer classe de teste.
     */
    @AfterClass
    public static void finalizar() {
        driver.quit();
    }
}
