package Floricultura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class FornecedoresModel {

    public static void create(FornecedoresBean fornecedor, Connection con) throws SQLException {
        String sql = "INSERT INTO fornecedores (id_fornecedor, nome, rua, numero, bairro, cidade, estado, email, telefone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, fornecedor.getIdFornecedor());
            pst.setString(2, fornecedor.getNome());
            pst.setString(3, fornecedor.getRua());
            pst.setInt(4, fornecedor.getNumero());
            pst.setString(5, fornecedor.getBairro());
            pst.setString(6, fornecedor.getCidade());
            pst.setString(7, fornecedor.getEstado());
            pst.setString(8, fornecedor.getEmail());
            pst.setString(9, fornecedor.getTelefone());
            pst.executeUpdate();
        }
    }

    public static void delete(int idFornecedor, Connection con) throws SQLException {
        String sql = "DELETE FROM fornecedores WHERE id_fornecedor = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, idFornecedor);
            pst.executeUpdate();
        }
    }

    public static void update(FornecedoresBean fornecedor, Connection con) throws SQLException {
        String sql = "UPDATE fornecedores SET nome = ?, rua = ?, numero = ?, bairro = ?, cidade = ?, estado = ?, email = ?, telefone = ? WHERE id_fornecedor = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, fornecedor.getNome());
            pst.setString(2, fornecedor.getRua());
            pst.setInt(3, fornecedor.getNumero());
            pst.setString(4, fornecedor.getBairro());
            pst.setString(5, fornecedor.getCidade());
            pst.setString(6, fornecedor.getEstado());
            pst.setString(7, fornecedor.getEmail());
            pst.setString(8, fornecedor.getTelefone());
            pst.setInt(9, fornecedor.getIdFornecedor());
            pst.executeUpdate();
        }
    }

    public static HashSet<FornecedoresBean> listAll(Connection con) throws SQLException {
        String sql = "SELECT id_fornecedor, nome, rua, numero, bairro, cidade, estado, email, telefone FROM fornecedores";
        HashSet<FornecedoresBean> fornecedores = new HashSet<>();
        try (PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                FornecedoresBean fornecedor = new FornecedoresBean(
                    rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4),
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)
                );
                fornecedores.add(fornecedor);
            }
        }
        return fornecedores;
    }
}