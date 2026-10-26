package modelo;

public class Gato {
    private int id;
    private String raza;
    private String nombre;
    private int precio;

    public Gato() {
    }

    //el constructir con los dates
    public Gato(int id, String raza, String nombre, int precio) {
        this.id = id;
        this.raza = raza;
        this.nombre = nombre;
        this.precio = precio;
    }

    //getters y setters para acceder a los datos
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRaza() { return raza; }
    public void setRaza(String raza) { this.raza = raza; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getPrecio() { return precio; }
    public void setPrecio(int precio) { this.precio = precio; }
}