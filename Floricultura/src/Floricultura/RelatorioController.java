package Floricultura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class RelatorioController {

    private RelatorioModel relatorioModel = new RelatorioModel();

    public void gerarRelatorioProdutosPorFornecedor(Connection conn) {
        try {
            List<RelatorioBean> relatorios = relatorioModel.gerarRelatorioProdutosPorFornecedor(conn);
            System.out.println("Relatório de Produtos por Fornecedor:");
            for (RelatorioBean bean : relatorios) {
                System.out.println("Fornecedor: " + bean.getFornecedor() +
                                   ", Produto: " + bean.getProduto());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void gerarRelatorioVendasPorCliente(Connection conn) {
        try {
            List<RelatorioBean> relatorios = relatorioModel.gerarRelatorioVendasPorCliente(conn);
            System.out.println("Relatório de Vendas por Cliente:");
            for (RelatorioBean bean : relatorios) {
                System.out.println("Cliente: " + bean.getCliente() +
                                   ", Venda ID: " + bean.getVendaId() +
                                   ", Total: " + bean.getTotal());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void gerarRelatorioItensDaVenda(Connection conn) {
        try {
            List<RelatorioBean> relatorios = relatorioModel.gerarRelatorioItensDaVenda(conn);
            System.out.println("Relatório de Itens da Venda:");
            for (RelatorioBean bean : relatorios) {
                System.out.println("Venda ID: " + bean.getVendaId() +
                                   ", Produto: " + bean.getProduto() +
                                   ", Quantidade: " + bean.getQuantidade());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}