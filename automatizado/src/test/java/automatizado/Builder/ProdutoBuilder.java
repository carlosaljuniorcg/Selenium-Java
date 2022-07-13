package automatizado.Builder;

public class ProdutoBuilder {
    public String codigo = "0001";
    public String nome = "Produto padrão";
    public Integer quantidade = 1;
    public Double valor = 1.0;
    public String data = "01/01/2022";

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

}
