package Floricultura;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecta {

    private static final String URL = "jdbc:postgresql://localhost:5432/floricultura";
    private static final String USER = "postgres";
    private static final String PASSWORD = "nif@nif22";

    public static Connection criarConexao() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver"); // Certifique-se de que o driver JDBC está registrado
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}