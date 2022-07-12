package automatizado.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement btnEntrar;

    @FindBy(css = "form.form-login>div.alert>span")
    public WebElement spanMensagem;

    

    /**
     * Construtor padrão para criação de uma nova instância da página de login.
     * @param driver driver da página de login.
     */
    public LoginPO(WebDriver driver) {
        super(driver);  
        
    }

    public String obterMensagem() {
        return spanMensagem.getText();
    }
    
}
