package Floricultura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ProdutosController {

    // Método para criar um novo produto
    public void createProduto(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo Produto: ");
        System.out.print("ID do Produto: ");
        int idProduto = input.nextInt();
        input.nextLine(); // Limpar o buffer
        System.out.print("Descrição: ");
        String descricao = input.nextLine();
        System.out.print("Preço Unitário: ");
        double precoUnitario = input.nextDouble();
        System.out.print("Quantidade em Estoque: ");
        int qtdEstoque = input.nextInt();
        System.out.print("ID da Categoria: ");
        int idCategoria = input.nextInt();

        ProdutosBean produto = new ProdutosBean(idProduto, descricao, precoUnitario, qtdEstoque, idCategoria);
        try {
            ProdutosModel.create(produto, con);
            System.out.println("Produto criado com sucesso!!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar produto: " + e.getMessage());
        }
    }

    // Método para excluir um produto
    public void deleteProduto(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID do Produto que deseja deletar: ");
        int idProduto = input.nextInt();

        try {
            ProdutosModel.delete(idProduto, con);
            System.out.println("Produto deletado com sucesso!!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar produto: " + e.getMessage());
        }
    }

    // Método para atualizar um produto
    public void updateProduto(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID do Produto que deseja atualizar: ");
        int idProduto = input.nextInt();
        input.nextLine(); // Limpar o buffer
        System.out.print("Nova Descrição: ");
        String descricao = input.nextLine();
        System.out.print("Novo Preço Unitário: ");
        double precoUnitario = input.nextDouble();
        System.out.print("Nova Quantidade em Estoque: ");
        int qtdEstoque = input.nextInt();
        System.out.print("Novo ID da Categoria: ");
        int idCategoria = input.nextInt();

        ProdutosBean produto = new ProdutosBean(idProduto, descricao, precoUnitario, qtdEstoque, idCategoria);
        try {
            ProdutosModel.update(produto, con);
            System.out.println("Produto atualizado com sucesso!!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e.getMessage());
        }
    }

    // Método para listar todos os produtos
    public void listProdutos(Connection con) throws SQLException {
        HashSet<ProdutosBean> produtos = ProdutosModel.listAll(con);
        Iterator<ProdutosBean> it = produtos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}