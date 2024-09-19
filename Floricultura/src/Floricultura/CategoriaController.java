package Floricultura;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class CategoriaController {

    public void createCategoria(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Insira os seguintes dados para criar uma nova Categoria: ");
        System.out.print("ID da Categoria: ");
        int idCategoria = input.nextInt();
        System.out.print("Nome da Categoria: ");
        String nome = input.next();
        CategoriaBean categoria = new CategoriaBean(idCategoria, nome);
        CategoriaModel.create(categoria, con);
        System.out.println("Categoria criada com sucesso!!");
    }

    public void deleteCategoria(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID da Categoria que deseja deletar: ");
        int idCategoria = input.nextInt();
        CategoriaModel.delete(idCategoria, con);
        System.out.println("Categoria deletada com sucesso!!");
    }

    public void updateCategoria(Connection con) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("Insira o ID da Categoria que deseja atualizar: ");
        int idCategoria = input.nextInt();
        System.out.print("Novo nome da Categoria: ");
        String nome = input.next();
        CategoriaBean categoria = new CategoriaBean(idCategoria, nome);
        CategoriaModel.update(categoria, con);
        System.out.println("Categoria atualizada com sucesso!!");
    }

    public void listCategorias(Connection con) throws SQLException {
        HashSet<CategoriaBean> categorias = CategoriaModel.listAll(con);
        Iterator<CategoriaBean> it = categorias.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
}