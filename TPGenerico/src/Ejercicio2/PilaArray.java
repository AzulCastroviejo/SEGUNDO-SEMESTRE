package Ejercicio2;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PilaArray <E>{
    private List<E> lista;
    private int cantidad;

    public PilaArray( int cantidad) {
        this.cantidad = cantidad;
        this.lista = new ArrayList<>();
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void agregarLista(E ingreso){
        if(lista.size() < cantidad){
            lista.add(ingreso);
        }else {
            System.out.println("La lista ya esta llena");
        }
    }

    public void mostrarLista(){
        int i = lista.size()-1;
        System.out.println("-----------Lista apilada--------------");
        while (i >= 0){
            System.out.println("E : "+lista.get(i));
            System.out.println("-------------------------------");
            i--;
        }
    }

}

