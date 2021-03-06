package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    //#region Região dos WebElements
    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement btnEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;
    //#endregion Região dos WebElements
    
    //#region Construtor
    /**
     * Construtor padrão para criação de uma nova instância da página de login.
     * @param driver driver da página de login.
     */
    public LoginPO(WebDriver driver) {
        super(driver);  
    }
    //#endregion COnstrutor

    //#region Métodos
    /**
     * Método que obtem a mensagem disparada na tela.
     * @return Texto da mensagem.
     */
    public String obterMensagem() {
        return spanMensagem.getText();
    }
    
    /**
     * Método que tenta executar a ação de logar no sistema
     * @param email E-mail para tentativa de login
     * @param senha Senha para tentativa de login
     */
    public void executarAcaoDeLogar(String email, String senha) {
        escrever(inputEmail, email);
        escrever(inputSenha, senha);
        btnEntrar.click(); 
    }
    //#endregion Métodos
    
}
