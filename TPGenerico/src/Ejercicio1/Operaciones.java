package Ejercicio1;

public class Operaciones implements Operable<Integer> {

    @Override
    public Number sumar(Integer a,Integer b) {
        Number x = a + b ;
        return a+b;
    }

    @Override
    public Number restar(Integer a, Integer b) {
        return a-b;
    }

    @Override
    public Number multiplicar(Integer a, Integer b) {
        return a*b;
    }

    @Override
    public Number dividir(Integer a, Integer b) {
        return a/b;
    }


}
