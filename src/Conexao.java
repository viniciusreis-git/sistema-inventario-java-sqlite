import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:inventario.db");
            System.out.println("Conexao com o banco SQLite estabelecida com sucesso!");
            return conn;

        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }

    public static void criarTabela() {

        String sql = "CREATE TABLE IF NOT EXISTS produtos (" +
                "id INTEGER PRIMARY KEY, " +
                "nome VARCHAR(30), " +
                "quantidade INTEGER, " +
                "preco DECIMAL(10,2)" +
                ");";

        try {
            Connection conn = conectar();
            java.sql.Statement stmt = conn.createStatement();

            stmt.execute(sql);
            System.out.println("Tabela 'produtos'criada (ou ja existia) com sucesso!");

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao criar a tabela: " + e.getMessage());
        }

    }

    public static void inserirProduto(Produto produto) {
        String sql = "INSERT INTO produtos (id, nome, quantidade, preco) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = conectar();
            java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, produto.getId());
            pstmt.setString(2, produto.getNome());
            pstmt.setInt(3, produto.getQuantidade());
            pstmt.setDouble(4, produto.getPreco());

            pstmt.executeUpdate();
            System.out.println("Produto salvo no banco: " + produto.getNome());

            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erro ao salvar o produto '" + produto.getNome() + "': " + e.getMessage());
        }
    }


    public static java.util.List<Produto> listarProdutos() {

        java.util.List<Produto> lista = new java.util.ArrayList<>();

        String sql = "SELECT * FROM produtos";
        try {
            Connection conn = conectar();
            java.sql.Statement stmt = conn.createStatement();
            java.sql.ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int quantidade = rs.getInt("quantidade");
                double preco = rs.getDouble("preco");

                Produto p = new Produto(id, nome, quantidade, preco);
                lista.add(p);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao buscar produtos: " + e.getMessage());
        }
        return lista;
    }

    public static void atualizarPreco(int id, double novoPreco) {
        String sql = "UPDATE produtos SET preco = ? WHERE id = ?";
        try {
            Connection conn = conectar();
            java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setDouble(1, novoPreco);
            pstmt.setInt(2, id);

            pstmt.executeUpdate();
            System.out.println("Preco atualizado no banco de dados!");

            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Eroo ao atualizar preco: " + e.getMessage());

        }
    }

    public static void deletarProduto(int id) {

        String sql = "DELETE FROM produtos WHERE id = ?";
        try {
            Connection conn = conectar();
            java.sql.PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Produto removido do banco de dados!");

            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Eroo ao deletar produto " + e.getMessage());


        }
    }

}
