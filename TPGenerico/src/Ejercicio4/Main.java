package Ejercicio4;

import Ejercicio3.Almacen;

public class Main {
    public static void main(String[] args) {
        /*Se desea implementar una clase Almacen que pueda almacenar elementos de cualquier tipo que sean superclases
        de Producto. Esta clase debe tener un método para añadir elementos al almacén y otro método para imprimir los
        elementos almacenados.

Implementa el método imprimirElementos de la clase Almacen utilizando un comodín <? super T> para permitir imprimir una
lista de elementos sin importar el tipo específico.
*/
        Almacen4<Elemento>almacen = new Almacen4<>();
        Producto4 alfombra = new Producto4(2 , "alfombra",25200.36);
        Producto4 pantuflas = new Producto4(3, "pantufla", 2500.36);
        Producto4 almohada = new Producto4(4,"almohada" ,15000.00);
        Producto4 frazada= new Producto4(5,"frazada", 48580.26);
        Producto4 sabana = new Producto4(6,"sabana",18265.02 );
        Producto4 colcha = new Producto4(7,"colcha" ,8532.25);
        Elemento el1= new Elemento(11);
        Elemento el2= new Elemento(12);
        Elemento el3= new Elemento(13);
        Elemento el4= new Elemento(14);
        almacen.almacenar(pantuflas);

        almacen.almacenar(almohada);
        almacen.almacenar(frazada);
        almacen.almacenar(sabana);
        almacen.almacenar(colcha);
        almacen.almacenar(el1);
        almacen.almacenar(el2);
        almacen.almacenar(el3);
        almacen.almacenar(el4);
        almacen.almacenar(alfombra);

        almacen.mostrar();

    }
}
