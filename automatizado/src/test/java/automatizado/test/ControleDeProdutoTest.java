package automatizado.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizado.Builder.ProdutoBuilder;
import automatizado.Page.ControleDeProdutoPO;
import automatizado.Page.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControleDeProdutoTest extends BaseTest {
    
    private static LoginPO loginPage;
    private static ControleDeProdutoPO controleProdutoPage;

    @BeforeClass    
    public static void prepararTestes() {
        loginPage = new LoginPO(driver);
        loginPage.executarAcaoDeLogar("admin@admin.com", "admin@123");

        controleProdutoPage = new ControleDeProdutoPO(driver);

        assertEquals(controleProdutoPage.obterTituloPagina(), "Controle de Produtos");
    }
    
    @Test
    public void TC001_deveAbrirModalDeControleDeProdutos() {
        controleProdutoPage.btnAdicionar.click();
        //TODO: Remover esse click assim que o sistema for corrigido.
        controleProdutoPage.btnAdicionar.click();
        String titulo = controleProdutoPage.tituloModal.getText();

        assertEquals("Produto", titulo);
        controleProdutoPage.btnSair.click();
        controleProdutoPage.btnSair.click();
    }

    /*@Test
    public void TC002_nãoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
        controleProdutoPage.btnAdicionar.click();

        controleProdutoPage.cadastrarProduto("0001", "Martelo", 10, 59.9, "");
        
        //Aqui vamos capturar a mensagem de ERRO.
        String mensagem = controleProdutoPage.spanMensagem.getText();

        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
    }*/

    @Test
    public void TC003_nãoDeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
        
        controleProdutoPage.btnAdicionar.click();

        ProdutoBuilder produtoBuilder = new ProdutoBuilder();
        controleProdutoPage.cadastrarProduto(produtoBuilder);
        //Aqui vamos capturar a mensagem de ERRO.
        String mensagem = controleProdutoPage.spanMensagem.getText();

        assertEquals("Todos os campos são obrigatórios para o cadastro!", mensagem);
    }
}
