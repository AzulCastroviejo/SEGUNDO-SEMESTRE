package Ejercicio3;

public class Alimento extends Producto{
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Alimento() {
    }

    public Alimento(String nombre, Double precio) {
        super(nombre, precio);
    }

    public Alimento(String nombre, Double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }
}
