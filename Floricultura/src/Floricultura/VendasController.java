package Floricultura;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class VendasController {

    public void createVenda(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar uma nova Venda: ");
        System.out.print("ID da Venda: ");
        int idVenda = input.nextInt();
        System.out.print("Total: ");
        double total = input.nextDouble();
        System.out.print("Data (yyyy-mm-dd): ");
        String dataStr = input.next();
        Date data = Date.valueOf(dataStr);
        System.out.print("ID do Cliente: ");
        int idCliente = input.nextInt();
        VendasBean venda = new VendasBean(idVenda, total, data, idCliente);
        VendasModel.create(venda, con);
        System.out.println("Venda criada com sucesso!!");
    }

    public void deleteVenda(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID da Venda que deseja deletar: ");
        int idVenda = input.nextInt();
        VendasModel.delete(idVenda, con);
        System.out.println("Venda deletada com sucesso!!");
    }

    public void updateVenda(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID da Venda que deseja atualizar: ");
        int idVenda = input.nextInt();
        System.out.print("Novo total: ");
        double total = input.nextDouble();
        System.out.print("Nova data (yyyy-mm-dd): ");
        String dataStr = input.next();
        Date data = Date.valueOf(dataStr);
        System.out.print("Novo ID do Cliente: ");
        int idCliente = input.nextInt();
        VendasBean venda = new VendasBean(idVenda, total, data, idCliente);
        VendasModel.update(venda, con);
        System.out.println("Venda atualizada com sucesso!!");
    }

    public void listVendas(Connection con) throws SQLException {
        HashSet<VendasBean> vendas = VendasModel.listAll(con);
        Iterator<VendasBean> it = vendas.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}