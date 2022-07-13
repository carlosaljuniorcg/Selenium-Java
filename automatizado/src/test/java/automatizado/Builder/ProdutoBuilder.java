package automatizado.Builder;

import org.openqa.selenium.WebDriver;

import automatizado.Page.ControleDeProdutoPO;

public class ProdutoBuilder {
    private String codigo = "0001";
    private String nome = "Produto padrão";
    private Integer quantidade = 1;
    private Double valor = 1.0;
    private String data = "01/01/2022";

    private ControleDeProdutoPO controleDeProdutoPO;

    public ProdutoBuilder(ControleDeProdutoPO controleDeProdutoPO) {
        this.controleDeProdutoPO = controleDeProdutoPO;
    }

    public ProdutoBuilder addCodigo(String codigo) {
        this.codigo = codigo;
        return this; //Retornando a propria instância
    }

    public ProdutoBuilder addNome(String nome) {
        this.nome = nome;
        return this; //Retornando a propria instância
    }

    public ProdutoBuilder addQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return this;
    }

    public ProdutoBuilder addValor(Double valor) {
        this.valor = valor;
        return this;
    }

    public ProdutoBuilder addData(String data) {
        this.data = data;
        return this;
    }

    public void builder() {
        
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputCodigo, codigo);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputNome, nome);
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputQuantidade, quantidade.toString());
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputValor, valor.toString());
        controleDeProdutoPO.escrever(controleDeProdutoPO.inputData, data);

        controleDeProdutoPO.btnSalvar.click();

    }

}
