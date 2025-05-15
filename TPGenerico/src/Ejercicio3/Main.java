package Ejercicio3;

public class Main {
    public static void main(String[] args) {

        Almacen<Producto>almacenP = new Almacen<>();
        Producto pantuflas = new Producto("pantufla" ,2500.00 );
        Producto almohada = new Producto("almohada" , 6000.50);
        Producto frazada= new Producto("frazada" , 10000.60);
        Producto sabana = new Producto("sabana" , 8520.25);
        Producto colcha = new Producto("colcha" , 7890.63);
        almacenP.almacenar(pantuflas);
        almacenP.almacenar(almohada);
        almacenP.almacenar(frazada);
        almacenP.almacenar(sabana);
        almacenP.almacenar(colcha);

        Alimento carne = new Alimento("carne", 7500.52);
        Electronico licuadora = new Electronico("licuadora",28000.36);
        almacenP.almacenar(carne);
        almacenP.almacenar(licuadora);
        almacenP.mostrar();

    }
}
