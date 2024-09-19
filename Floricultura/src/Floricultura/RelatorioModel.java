package Floricultura;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RelatorioModel {

    public List<RelatorioBean> gerarRelatorioProdutosPorFornecedor(Connection conn) throws SQLException {
        String sql = "SELECT f.nome AS fornecedor, p.descricao AS produto " +
                     "FROM fornecedores f " +
                     "JOIN fornecedoresprodutos fp ON f.id_fornecedor = fp.id_fornecedor " +
                     "JOIN produtos p ON fp.id_produto = p.id_produto";
        List<RelatorioBean> relatorios = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                RelatorioBean bean = new RelatorioBean();
                bean.setFornecedor(rs.getString("fornecedor"));
                bean.setProduto(rs.getString("produto"));
                relatorios.add(bean);
            }
        }
        return relatorios;
    }

    public List<RelatorioBean> gerarRelatorioVendasPorCliente(Connection conn) throws SQLException {
        String sql = "SELECT c.nome AS cliente, v.id_venda, v.total " +
                     "FROM vendas v " +
                     "JOIN clientes c ON v.id_cliente = c.id_cliente";
        List<RelatorioBean> relatorios = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                RelatorioBean bean = new RelatorioBean();
                bean.setCliente(rs.getString("cliente"));
                bean.setVendaId(rs.getInt("id_venda"));
                bean.setTotal(rs.getDouble("total"));
                relatorios.add(bean);
            }
        }
        return relatorios;
    }

    public List<RelatorioBean> gerarRelatorioItensDaVenda(Connection conn) throws SQLException {
        String sql = "SELECT v.id_venda, p.descricao AS produto, i.quantidade " +
                     "FROM itensdavenda i " +
                     "JOIN produtos p ON i.id_produto = p.id_produto " +
                     "JOIN vendas v ON i.id_venda = v.id_venda";
        List<RelatorioBean> relatorios = new ArrayList<>();
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                RelatorioBean bean = new RelatorioBean();
                bean.setVendaId(rs.getInt("id_venda"));
                bean.setProduto(rs.getString("produto"));
                bean.setQuantidade(rs.getInt("quantidade"));
                relatorios.add(bean);
            }
        }
        return relatorios;
    }
}