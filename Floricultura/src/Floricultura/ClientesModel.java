package Floricultura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

public class ClientesModel {

    public static void create(ClientesBean cliente, Connection con) throws SQLException {
        String sql = "INSERT INTO clientes (id_cliente, nome, sobrenome, telefone, email, cpf) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, cliente.getIdCliente());
            pst.setString(2, cliente.getNome());
            pst.setString(3, cliente.getSobrenome());
            pst.setString(4, cliente.getTelefone());
            pst.setString(5, cliente.getEmail());
            pst.setLong(6, cliente.getCpf());
            pst.executeUpdate();
        }
    }

    public static void delete(int idCliente, Connection con) throws SQLException {
        String sql = "DELETE FROM clientes WHERE id_cliente = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, idCliente);
            pst.executeUpdate();
        }
    }

    public static void update(ClientesBean cliente, Connection con) throws SQLException {
        String sql = "UPDATE clientes SET nome = ?, sobrenome = ?, telefone = ?, email = ?, cpf = ? WHERE id_cliente = ?";
        try (PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setString(1, cliente.getNome());
            pst.setString(2, cliente.getSobrenome());
            pst.setString(3, cliente.getTelefone());
            pst.setString(4, cliente.getEmail());
            pst.setLong(5, cliente.getCpf());
            pst.setInt(6, cliente.getIdCliente());
            pst.executeUpdate();
        }
    }

    public static HashSet<ClientesBean> listAll(Connection con) throws SQLException {
        String sql = "SELECT id_cliente, nome, sobrenome, telefone, email, cpf FROM clientes";
        HashSet<ClientesBean> clientes = new HashSet<>();
        try (PreparedStatement pst = con.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                ClientesBean cliente = new ClientesBean(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getLong(6));
                clientes.add(cliente);
            }
        }
        return clientes;
    }
}