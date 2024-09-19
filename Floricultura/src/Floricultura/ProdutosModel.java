package Floricultura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class ProdutosModel {

    // Método para criar um novo produto
    public static void create(ProdutosBean produto, Connection con) throws SQLException {
        String sql = "INSERT INTO produtos (id_produto, descricao, preco_unitario, qtd_estoque, id_categoria) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, produto.getIdProduto());
            pst.setString(2, produto.getDescricao());
            pst.setDouble(3, produto.getPrecoUnitario());
            pst.setInt(4, produto.getQtdEstoque());
            pst.setInt(5, produto.getIdCategoria());
            pst.executeUpdate();
        }
    }

    // Método para excluir um produto
    public static void delete(int idProduto, Connection con) throws SQLException {
        String sql = "DELETE FROM produtos WHERE id_produto = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, idProduto);
            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Nenhum produto encontrado com o ID fornecido.");
            }
        }
    }

    // Método para atualizar um produto
    public static void update(ProdutosBean produto, Connection con) throws SQLException {
        String sql = "UPDATE produtos SET descricao = ?, preco_unitario = ?, qtd_estoque = ?, id_categoria = ? WHERE id_produto = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, produto.getDescricao());
            pst.setDouble(2, produto.getPrecoUnitario());
            pst.setInt(3, produto.getQtdEstoque());
            pst.setInt(4, produto.getIdCategoria());
            pst.setInt(5, produto.getIdProduto());
            int affectedRows = pst.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Nenhum produto encontrado com o ID fornecido.");
            }
        }
    }

    // Método para listar todos os produtos
    public static HashSet<ProdutosBean> listAll(Connection con) throws SQLException {
        String sql = "SELECT id_produto, descricao, preco_unitario, qtd_estoque, id_categoria FROM produtos";
        HashSet<ProdutosBean> produtos = new HashSet<>();
        try (PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                ProdutosBean produto = new ProdutosBean(
                    rs.getInt("id_produto"),
                    rs.getString("descricao"),
                    rs.getDouble("preco_unitario"),
                    rs.getInt("qtd_estoque"),
                    rs.getInt("id_categoria")
                );
                produtos.add(produto);
            }
        }
        return produtos;
    }
}