import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println("Iniciando o Sistema de Gerenciamento de Inventario");

        Conexao.criarTabela();
        List<Produto> estoque = Conexao.listarProdutos();
        System.out.println("Total de produtos no estoque: " + estoque.size());
        //Produto produto1 = new Produto(1, "Teclado Mecanico", 15, 250.50);
        //Conexao.inserirProduto(produto1);

        // Produto produto2 = new Produto(2, "Webcam", 3, 190.90);
        //Conexao.inserirProduto(produto2);

        // Produto produto3 = new Produto(3, "Monitor", 6, 470.90);
        // Conexao.inserirProduto(produto3);

        // List<Produto> estoque = new ArrayList<>();
        // estoque.add(produto1);
        //estoque.add(produto2);
        //estoque.add(produto3);
        //System.out.println("Total de produtos no estoque: " + estoque.size());

        System.out.println("LISTA DE PRODUTOS");

        for (Produto item : estoque) {
            System.out.println("ID: " + item.getId() + " | Nome: " + item.getNome() + " | R$ " + item.getPreco());
        }

        System.out.println("\n--- ATUALIZANDO O PRECO DO MONITOR ---");

        Conexao.atualizarPreco(3, 520.00);
        estoque = Conexao.listarProdutos();



        System.out.println("\n--- NOVA LISTA DE PRODUTOS ---");

        for (Produto item : estoque) {
            System.out.println("ID: " + item.getId() + " | Nome: " + item.getNome() + " | R$ " + item.getPreco());

        }

        System.out.println("\n--- REMOVENDO O TECLADO MECANICO ---");
        Conexao.deletarProduto(1);
        estoque = Conexao.listarProdutos();

        System.out.println("Total de produtos no estoque: " + estoque.size());

        System.out.println("\n--- LISTA FINAL DE PRODUTOS ---");


        for (Produto item : estoque) {
            System.out.println("ID: " + item.getId() + " | Nome: " + item.getNome() + " | R$ " + item.getPreco());


        }
    }
}










