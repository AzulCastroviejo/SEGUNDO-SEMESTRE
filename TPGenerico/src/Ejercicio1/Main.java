package Ejercicio1;

import Ejercicio1.Operaciones;
import Ejercicio1.OperacionesDouble;

public class Main {
    public static void main(String[] args) {
        Operaciones operacion =new Operaciones();
        OperacionesDouble operacionD =new OperacionesDouble();
        System.out.println(operacion.sumar(8,9));
        System.out.println(operacion.multiplicar(8,9));
        System.out.println(operacionD.sumar(23.6 , 85.6));
        System.out.println(operacionD.multiplicar(85.6,96.3));
    }
}