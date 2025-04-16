public class Main {
    public static void main(String[] args) throws myException {

        boolean x ;
        Auto auto = new Auto(110);
        auto.acelera(5);
        Matricula matricula1 = new Matricula(123456, 26);
        Chofer chofer1= new Chofer("Santi", matricula1);
        x=chofer1.verificar(30);
        if( x ){
            Camion camion = new Camion(130);
            System.out.println("Se creo el camion correctamente ");
            camion.acelera(10);
        }else {
            System.out.println("No se creo camion");
        }


    }
}