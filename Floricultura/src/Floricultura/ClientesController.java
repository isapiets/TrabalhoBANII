package Floricultura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class ClientesController {

    public void createCliente(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo Cliente: ");
        System.out.print("ID do Cliente: ");
        int idCliente = input.nextInt();
        System.out.print("Nome: ");
        String nome = input.next();
        System.out.print("Sobrenome: ");
        String sobrenome = input.next();
        System.out.print("Telefone: ");
        String telefone = input.next();
        System.out.print("Email: ");
        String email = input.next();
        System.out.print("CPF: ");
        long cpf = input.nextLong();
        ClientesBean cliente = new ClientesBean(idCliente, nome, sobrenome, telefone, email, cpf);
        ClientesModel.create(cliente, con);
        System.out.println("Cliente criado com sucesso!!");
    }

    public void deleteCliente(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID do Cliente que deseja deletar: ");
        int idCliente = input.nextInt();
        ClientesModel.delete(idCliente, con);
        System.out.println("Cliente deletado com sucesso!!");
    }

    public void updateCliente(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID do Cliente que deseja atualizar: ");
        int idCliente = input.nextInt();
        System.out.print("Novo nome: ");
        String nome = input.next();
        System.out.print("Novo sobrenome: ");
        String sobrenome = input.next();
        System.out.print("Novo telefone: ");
        String telefone = input.next();
        System.out.print("Novo email: ");
        String email = input.next();
        System.out.print("Novo CPF: ");
        long cpf = input.nextLong();
        ClientesBean cliente = new ClientesBean(idCliente, nome, sobrenome, telefone, email, cpf);
        ClientesModel.update(cliente, con);
        System.out.println("Cliente atualizado com sucesso!!");
    }

    public void listClientes(Connection con) throws SQLException {
        HashSet<ClientesBean> clientes = ClientesModel.listAll(con);
        Iterator<ClientesBean> it = clientes.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}