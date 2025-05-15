package Ejercicio4;

import java.util.ArrayList;

public class Almacen4<T> {

    private ArrayList<T> productos ;

    public Almacen4() {
        this.productos = new ArrayList<>();
    }
    public void almacenar(T producto){
        this.productos.add(producto);
    }
    public void mostrar(){
        for (Object producto:productos) {

            if (producto instanceof Producto4) {
                Producto4 p = (Producto4) producto;
                System.out.println(" Código: " + p.getCodigo());
                System.out.println(" Nombre: " + p.getNombre());
                System.out.println(" Precio: $" + p.getPrecio());
                System.out.println(" Identificador: " + p.getClass());
            } else if (producto instanceof Elemento) {
                Elemento elem = (Elemento) producto;
                System.out.println(" Código: " + elem.getCodigo());
                System.out.println(" Identificador: " + elem.getClass());
            }
            System.out.println("---------------------------------------------------");
        }
    }

}
