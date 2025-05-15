package Ejercicio1;

public class OperacionesDouble implements Operable<Double> {

    @Override
    public Number sumar(Double a, Double b) {
        return a+b;
    }

    @Override
    public Number restar(Double a, Double b) {
        return a-b;
    }

    @Override
    public Number multiplicar(Double a, Double b) {
        return a*b;
    }

    @Override
    public Number dividir(Double a, Double b) {
        return a/b;
    }
}
