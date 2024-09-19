package Floricultura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class CategoriaModel {

    public static void create(CategoriaBean categoria, Connection con) throws SQLException {
        String sql = "INSERT INTO categoria (id_categoria, nome) VALUES (?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, categoria.getIdCategoria());
            pst.setString(2, categoria.getNome());
            pst.executeUpdate();
        }
    }

    public static void delete(int idCategoria, Connection con) throws SQLException {
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, idCategoria);
            pst.executeUpdate();
        }
    }

    public static void update(CategoriaBean categoria, Connection con) throws SQLException {
        String sql = "UPDATE categoria SET nome = ? WHERE id_categoria = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, categoria.getNome());
            pst.setInt(2, categoria.getIdCategoria());
            pst.executeUpdate();
        }
    }

    public static HashSet<CategoriaBean> listAll(Connection con) throws SQLException {
        String sql = "SELECT id_categoria, nome FROM categoria";
        HashSet<CategoriaBean> categorias = new HashSet<>();
        try (PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                CategoriaBean categoria = new CategoriaBean(rs.getInt(1), rs.getString(2));
                categorias.add(categoria);
            }
        }
        return categorias;
    }
}