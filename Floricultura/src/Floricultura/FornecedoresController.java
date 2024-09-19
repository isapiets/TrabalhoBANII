package Floricultura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class FornecedoresController {

    public void createFornecedor(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar um novo Fornecedor: ");
        System.out.print("ID do Fornecedor: ");
        int idFornecedor = input.nextInt();
        input.nextLine(); // Limpar buffer
        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Rua: ");
        String rua = input.nextLine();
        System.out.print("Número: ");
        int numero = input.nextInt();
        input.nextLine(); // Limpar buffer
        System.out.print("Bairro: ");
        String bairro = input.nextLine();
        System.out.print("Cidade: ");
        String cidade = input.nextLine();
        System.out.print("Estado: ");
        String estado = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Telefone: ");
        String telefone = input.nextLine();
        FornecedoresBean fornecedor = new FornecedoresBean(idFornecedor, nome, rua, numero, bairro, cidade, estado, email, telefone);
        FornecedoresModel.create(fornecedor, con);
        System.out.println("Fornecedor criado com sucesso!!");
    }

    public void deleteFornecedor(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID do Fornecedor que deseja deletar: ");
        int idFornecedor = input.nextInt();
        FornecedoresModel.delete(idFornecedor, con);
        System.out.println("Fornecedor deletado com sucesso!!");
    }

    public void updateFornecedor(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID do Fornecedor que deseja atualizar: ");
        int idFornecedor = input.nextInt();
        input.nextLine(); // Limpar buffer
        System.out.print("Novo nome: ");
        String nome = input.nextLine();
        System.out.print("Nova rua: ");
        String rua = input.nextLine();
        System.out.print("Novo número: ");
        int numero = input.nextInt();
        input.nextLine(); // Limpar buffer
        System.out.print("Novo bairro: ");
        String bairro = input.nextLine();
        System.out.print("Nova cidade: ");
        String cidade = input.nextLine();
        System.out.print("Novo estado: ");
        String estado = input.nextLine();
        System.out.print("Novo email: ");
        String email = input.nextLine();
        System.out.print("Novo telefone: ");
        String telefone = input.nextLine();
        FornecedoresBean fornecedor = new FornecedoresBean(idFornecedor, nome, rua, numero, bairro, cidade, estado, email, telefone);
        FornecedoresModel.update(fornecedor, con);
        System.out.println("Fornecedor atualizado com sucesso!!");
    }

    public void listFornecedores(Connection con) throws SQLException {
        HashSet<FornecedoresBean> fornecedores = FornecedoresModel.listAll(con);
        Iterator<FornecedoresBean> it = fornecedores.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}