package dao;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Gato;

public class GatoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    //este método - traer todos los gatos registrados en la tabla
    public List<Gato> listar() {
        List<Gato> lista = new ArrayList<>();
        String sql = "SELECT * FROM Gatos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Gato gato = new Gato();
                gato.setId(rs.getInt("id"));
                gato.setRaza(rs.getString("raza"));
                gato.setNombre(rs.getString("nombre"));
                gato.setPrecio(rs.getInt("precio"));
                lista.add(gato);
            }
        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }
        return lista;
    }

    //metodo q guarda un nuevo gato
    public boolean agregar(Gato gato) {
        String sql = "INSERT INTO Gatos (raza, nombre, precio) VALUES (?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, gato.getRaza());
            ps.setString(2, gato.getNombre());
            ps.setInt(3, gato.getPrecio());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("Error al agregar: " + e.getMessage());
            return false;
        }
    }
}