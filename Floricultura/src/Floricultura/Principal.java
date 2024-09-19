package Floricultura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        try {
            Connection con = Conecta.criarConexao();
            int op = 0;
            do {
                op = menu();
                try {
                    switch (op) {
                        case 1:
                            new CategoriaController().createCategoria(con);
                            break;
                        case 2:
                            new CategoriaController().deleteCategoria(con);
                            break;
                        case 3:
                            new CategoriaController().updateCategoria(con);
                            break;
                        case 4:
                            new CategoriaController().listCategorias(con);
                            break;
                        case 5:
                            new ProdutosController().createProduto(con);
                            break;
                        case 6:
                            new ProdutosController().deleteProduto(con);
                            break;
                        case 7:
                            new ProdutosController().updateProduto(con);
                            break;
                        case 8:
                            new ProdutosController().listProdutos(con);
                            break;
                        case 9:
                            new FornecedoresController().createFornecedor(con);
                            break;
                        case 10:
                            new FornecedoresController().deleteFornecedor(con);
                            break;
                        case 11:
                            new FornecedoresController().updateFornecedor(con);
                            break;
                        case 12:
                            new FornecedoresController().listFornecedores(con);
                            break;
                        case 13:
                            new VendasController().createVenda(con);
                            break;
                        case 14:
                            new VendasController().deleteVenda(con);
                            break;
                        case 15:
                            new VendasController().updateVenda(con);
                            break;
                        case 16:
                            new VendasController().listVendas(con);
                            break;
                        case 17:
                            new ItensDaVendaController().createItemDaVenda(con);
                            break;
                        case 18:
                            new ItensDaVendaController().deleteItemDaVenda(con);
                            break;
                        case 19:
                            new ItensDaVendaController().updateItemDaVenda(con);
                            break;
                        case 20:
                            new ItensDaVendaController().listItensDaVenda(con);
                            break;
                        case 21:
                            new FornecedoresProdutosController().createFornecedoresProdutos(con);
                            break;
                        case 22:
                            new FornecedoresProdutosController().deleteFornecedoresProdutos(con);
                            break;
                        case 23:
                            new FornecedoresProdutosController().listFornecedoresProdutos(con);
                            break;
                        case 24:
                            new RelatorioController().gerarRelatorioProdutosPorFornecedor(con);
                            break;
                        case 25:
                            new RelatorioController().gerarRelatorioVendasPorCliente(con);
                            break;
                        case 26:
                            new RelatorioController().gerarRelatorioItensDaVenda(con);
                            break;
                        case 27:
                            new ClientesController().createCliente(con);
                            break;
                        case 28:
                            new ClientesController().deleteCliente(con);
                            break;
                        case 29:
                            new ClientesController().updateCliente(con);
                            break;
                        case 30:
                            new ClientesController().listClientes(con);
                            break;
                        default:
                            System.out.println("Saindo...");
                            break;
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                    continue;
                }
            } while (op > 0 && op < 31);
            con.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static int menu() {
        System.out.println("");
        System.out.println("Informe o número da opção que desejas executar: ");
        System.out.println("1 - Inserir uma nova Categoria");
        System.out.println("2 - Excluir uma Categoria");
        System.out.println("3 - Atualizar uma Categoria");
        System.out.println("4 - Listar todas as Categorias");
        System.out.println("5 - Inserir um novo Produto");
        System.out.println("6 - Excluir um Produto");
        System.out.println("7 - Atualizar um Produto");
        System.out.println("8 - Listar todos os Produtos");
        System.out.println("9 - Inserir um novo Fornecedor");
        System.out.println("10 - Excluir um Fornecedor");
        System.out.println("11 - Atualizar um Fornecedor");
        System.out.println("12 - Listar todos os Fornecedores");
        System.out.println("13 - Inserir uma nova Venda");
        System.out.println("14 - Excluir uma Venda");
        System.out.println("15 - Atualizar uma Venda");
        System.out.println("16 - Listar todas as Vendas");
        System.out.println("17 - Inserir um novo Item da Venda");
        System.out.println("18 - Excluir um Item da Venda");
        System.out.println("19 - Atualizar um Item da Venda");
        System.out.println("20 - Listar todos os Itens da Venda");
        System.out.println("21 - Inserir uma nova relação Fornecedor-Produto");
        System.out.println("22 - Excluir uma relação Fornecedor-Produto");
        System.out.println("23 - Listar todas as relações Fornecedor-Produto");
        System.out.println("24 - Gerar Relatório de Produtos por Fornecedor");
        System.out.println("25 - Gerar Relatório de Vendas por Cliente");
        System.out.println("26 - Gerar Relatório de Itens da Venda");
        System.out.println("27 - Inserir um novo Cliente");
        System.out.println("28 - Excluir um Cliente");
        System.out.println("29 - Atualizar um Cliente");
        System.out.println("30 - Listar todos os Clientes");
        System.out.println("Digite qualquer outro valor para sair");
        System.out.print("Sua opção: ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }
}