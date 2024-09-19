package Floricultura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class FornecedoresProdutosController {

    public void createFornecedoresProdutos(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar uma nova relação Fornecedor-Produto: ");
        System.out.print("ID do Fornecedor: ");
        int idFornecedor = input.nextInt();
        System.out.print("ID do Produto: ");
        int idProduto = input.nextInt();
        FornecedoresProdutosBean fornecedoresProdutos = new FornecedoresProdutosBean(idFornecedor, idProduto);
        FornecedoresProdutosModel.create(fornecedoresProdutos, con);
        System.out.println("Relação Fornecedor-Produto criada com sucesso!!");
    }

    public void deleteFornecedoresProdutos(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID do Fornecedor da relação que deseja deletar: ");
        int idFornecedor = input.nextInt();
        System.out.print("Insira o ID do Produto da relação que deseja deletar: ");
        int idProduto = input.nextInt();
        FornecedoresProdutosModel.delete(idFornecedor, idProduto, con);
        System.out.println("Relação Fornecedor-Produto deletada com sucesso!!");
    }

    public void listFornecedoresProdutos(Connection con) throws SQLException {
        HashSet<FornecedoresProdutosBean> fornecedoresProdutos = FornecedoresProdutosModel.listAll(con);
        Iterator<FornecedoresProdutosBean> it = fornecedoresProdutos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}