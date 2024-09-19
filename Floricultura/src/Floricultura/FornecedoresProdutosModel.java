package Floricultura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class FornecedoresProdutosModel {

    // Método para criar uma nova relação Fornecedor-Produto
    public static void create(FornecedoresProdutosBean fornecedoresProdutos, Connection con) throws SQLException {
        String sql = "INSERT INTO fornecedoresprodutos (id_fornecedor, id_produto) VALUES (?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, fornecedoresProdutos.getIdFornecedor());
            pst.setInt(2, fornecedoresProdutos.getIdProduto());
            pst.executeUpdate();
        }
    }

    // Método para deletar uma relação Fornecedor-Produto
    public static void delete(int idFornecedor, int idProduto, Connection con) throws SQLException {
        String sql = "DELETE FROM fornecedoresprodutos WHERE id_fornecedor = ? AND id_produto = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, idFornecedor);
            pst.setInt(2, idProduto);
            pst.executeUpdate();
        }
    }

    // Método para listar todas as relações Fornecedor-Produto
    public static HashSet<FornecedoresProdutosBean> listAll(Connection con) throws SQLException {
        String sql = "SELECT id_fornecedor, id_produto FROM fornecedoresprodutos";
        HashSet<FornecedoresProdutosBean> fornecedoresProdutos = new HashSet<>();
        try (PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                int idFornecedor = rs.getInt("id_fornecedor");
                int idProduto = rs.getInt("id_produto");
                FornecedoresProdutosBean fornecedorProduto = new FornecedoresProdutosBean(idFornecedor, idProduto);
                fornecedoresProdutos.add(fornecedorProduto);
            }
        }
        return fornecedoresProdutos;
    }
}