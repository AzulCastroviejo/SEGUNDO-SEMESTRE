package Ejercicio4;

public class Producto4 extends Elemento{
    private String nombre;
    private double precio;

    public Producto4() {
    }

    public Producto4(int codigo, String nombre, double precio) {
        super(codigo);
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
