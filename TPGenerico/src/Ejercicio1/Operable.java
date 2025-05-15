package Ejercicio1;

public interface Operable <T extends Number>{
    Number sumar(T a, T b);
    Number restar(T a, T b);
    Number multiplicar(T a, T b);
    Number dividir(T a, T b);

}
