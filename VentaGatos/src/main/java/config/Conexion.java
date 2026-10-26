package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Aquí usamos el String de conexión adaptada a la base de datos
    private final String URL = "jdbc:sqlserver://localhost:1433;databaseName=VentaGatos;encrypt=true;trustServerCertificate=true";
    private final String USER = "JavaUser"; // El usuario de SQL
    private final String PASS = "password123"; // La contraseña que creamos
    
    public Connection getConnection() {
        Connection con = null;
        try {
            //aqui el driver de sql server
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conexión exitosa a la BD de Gatos");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }
        return con;
    }
}