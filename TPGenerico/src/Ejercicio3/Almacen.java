package Ejercicio3;

import java.util.ArrayList;

public class Almacen<T extends Producto> {
    private ArrayList<T>productos ;

    public Almacen() {
        this.productos = new ArrayList<>();
    }
    public void almacenar(T producto){
        this.productos.add(producto);
    }
    public void mostrar( ){
        for (T  producto:productos) {
            System.out.println("Producto : "+producto.getNombre());
            System.out.println("Precio : $"+producto.getPrecio());
            System.out.println("Tipo de producto - "+producto.getClass());
            System.out.println("-----------------------");

        }
    }
}
