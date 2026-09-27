public class Produto {

    private int id;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(int id, String nome, int quantidade, double preco) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int novoQuantidade) {
        this.quantidade = novoQuantidade;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double novoPreco) {
        this.preco = novoPreco;
    }

    public int getId() {
        return this.id;
    }
}




