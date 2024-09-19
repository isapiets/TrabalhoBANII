package Floricultura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class ItensDaVendaModel {

    public static void create(ItensDaVendaBean itemDaVenda, Connection con) throws SQLException {
        String sql = "INSERT INTO itensdavenda (id_itemdavenda, id_venda, id_produto, quantidade) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, itemDaVenda.getIdItemDaVenda());
            pst.setInt(2, itemDaVenda.getIdVenda());
            pst.setInt(3, itemDaVenda.getIdProduto());
            pst.setInt(4, itemDaVenda.getQuantidade());
            pst.executeUpdate();
        }
    }

    public static void delete(int idItemDaVenda, Connection con) throws SQLException {
        String sql = "DELETE FROM itensdavenda WHERE id_itemdavenda = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, idItemDaVenda);
            pst.executeUpdate();
        }
    }

    public static void update(ItensDaVendaBean itemDaVenda, Connection con) throws SQLException {
        String sql = "UPDATE itensdavenda SET id_venda = ?, id_produto = ?, quantidade = ? WHERE id_itemdavenda = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, itemDaVenda.getIdVenda());
            pst.setInt(2, itemDaVenda.getIdProduto());
            pst.setInt(3, itemDaVenda.getQuantidade());
            pst.setInt(4, itemDaVenda.getIdItemDaVenda());
            pst.executeUpdate();
        }
    }

    public static HashSet<ItensDaVendaBean> listAll(Connection con) throws SQLException {
        String sql = "SELECT id_itemdavenda, id_venda, id_produto, quantidade FROM itensdavenda";
        HashSet<ItensDaVendaBean> itensDaVenda = new HashSet<>();
        try (PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                ItensDaVendaBean itemDaVenda = new ItensDaVendaBean(
                    rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4)
                );
                itensDaVenda.add(itemDaVenda);
            }
        }
        return itensDaVenda;
    }
}