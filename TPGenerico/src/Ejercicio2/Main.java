package Ejercicio2;

public class Main {
    public static void main(String[] args) {

        PilaArray<String>strings= new PilaArray<>(5);
        strings.agregarLista("Plato");
        strings.agregarLista("Copa");
        strings.agregarLista("Tenedor");
        strings.agregarLista("Cuchillo");
        strings.agregarLista("Cuchara");


        strings.mostrarLista();

        PilaArray<Integer>integers= new PilaArray<>(8);
        integers.agregarLista(85);
        integers.agregarLista(75);
        integers.agregarLista(65);
        integers.agregarLista(55);
        integers.agregarLista(45);
        integers.agregarLista(35);
        integers.agregarLista(25);
        integers.agregarLista(15);

        integers.mostrarLista();






    }

}
