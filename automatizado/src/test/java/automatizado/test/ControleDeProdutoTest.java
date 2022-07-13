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
    public void TC003_DeveSerPossivelCadastrarUmProdutoSemPreencherTodosOsCampos() {
        
        String mensagem = "Todos os campos são obrigatórios para o cadastro!";
        controleProdutoPage.btnAdicionar.click();
        
        //Aqui cria o objeto para adicionar a tela
        ProdutoBuilder produtoBuilder = new ProdutoBuilder(controleProdutoPage);
              
        //Aqui estamos testando se o produto é add sem código
        produtoBuilder
        .addCodigo("")
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());
               
        //Aqui estamos testando se o produto é add sem quantidade
        produtoBuilder
        .addQuantidade(null)
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        //Aqui estamos testando se o produto é add sem nome 
        produtoBuilder
        .addNome("")
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());
        
        //Aqui estamos testando se o produto é add sem valor 
        produtoBuilder
        .addValor(null)
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        //Aqui estamos testando se o produto é add sem data 
        produtoBuilder
        .addData("")
        .builder();

        assertEquals(mensagem, controleProdutoPage.spanMensagem.getText());

        //controleProdutoPage.btnAdicionar.click();
        //controleProdutoPage.btnAdicionar.click();
        //Aqui vamos capturar a mensagem de ERRO.
        //String mensagem = controleProdutoPage.s   panMensagem.getText();

        //assertEquals("Todos os campos são obrigatórios para o cadastro!", controleProdutoPage.spanMensagem.getText());
    }
}
