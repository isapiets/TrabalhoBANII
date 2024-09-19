package Floricultura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ItensDaVendaController {

    public void createItemDaVenda(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo Item da Venda: ");
        System.out.print("ID do Item da Venda: ");
        int idItemDaVenda = input.nextInt();
        System.out.print("ID da Venda: ");
        int idVenda = input.nextInt();
        System.out.print("ID do Produto: ");
        int idProduto = input.nextInt();
        System.out.print("Quantidade: ");
        int quantidade = input.nextInt();
        ItensDaVendaBean itemDaVenda = new ItensDaVendaBean(idItemDaVenda, idVenda, idProduto, quantidade);
        ItensDaVendaModel.create(itemDaVenda, con);
        System.out.println("Item da Venda criado com sucesso!!");
    }

    public void deleteItemDaVenda(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID do Item da Venda que deseja deletar: ");
        int idItemDaVenda = input.nextInt();
        ItensDaVendaModel.delete(idItemDaVenda, con);
        System.out.println("Item da Venda deletado com sucesso!!");
    }

    public void updateItemDaVenda(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID do Item da Venda que deseja atualizar: ");
        int idItemDaVenda = input.nextInt();
        System.out.print("Novo ID da Venda: ");
        int idVenda = input.nextInt();
        System.out.print("Novo ID do Produto: ");
        int idProduto = input.nextInt();
        System.out.print("Nova Quantidade: ");
        int quantidade = input.nextInt();
        ItensDaVendaBean itemDaVenda = new ItensDaVendaBean(idItemDaVenda, idVenda, idProduto, quantidade);
        ItensDaVendaModel.update(itemDaVenda, con);
        System.out.println("Item da Venda atualizado com sucesso!!");
    }

    public void listItensDaVenda(Connection con) throws SQLException {
        HashSet<ItensDaVendaBean> itensDaVenda = ItensDaVendaModel.listAll(con);
        Iterator<ItensDaVendaBean> it = itensDaVenda.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}