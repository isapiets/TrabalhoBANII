package Floricultura;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class VendasModel {

    public static void create(VendasBean venda, Connection con) throws SQLException {
        String sql = "INSERT INTO vendas (id_venda, total, data, id_cliente) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, venda.getIdVenda());
            pst.setDouble(2, venda.getTotal());
            pst.setDate(3, venda.getData());
            pst.setInt(4, venda.getIdCliente());
            pst.executeUpdate();
        }
    }

    public static void delete(int idVenda, Connection con) throws SQLException {
        String sql = "DELETE FROM vendas WHERE id_venda = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, idVenda);
            pst.executeUpdate();
        }
    }

    public static void update(VendasBean venda, Connection con) throws SQLException {
        String sql = "UPDATE vendas SET total = ?, data = ?, id_cliente = ? WHERE id_venda = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setDouble(1, venda.getTotal());
            pst.setDate(2, venda.getData());
            pst.setInt(3, venda.getIdCliente());
            pst.setInt(4, venda.getIdVenda());
            pst.executeUpdate();
        }
    }

    public static HashSet<VendasBean> listAll(Connection con) throws SQLException {
        String sql = "SELECT id_venda, total, data, id_cliente FROM vendas";
        HashSet<VendasBean> vendas = new HashSet<>();
        try (PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                VendasBean venda = new VendasBean(
                    rs.getInt(1), rs.getDouble(2), rs.getDate(3), rs.getInt(4)
                );
                vendas.add(venda);
            }
        }
        return vendas;
    }
}