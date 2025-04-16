public abstract class Vehiculo {
    public float velocidad;

    public Vehiculo(float velocidad) {
        this.velocidad = velocidad;
    }

    public void acelera(float acele) throws myException {

        try{
            if((velocidad +acele)> 120){
                throw new myException("Velocidad superada");
            }else{
                velocidad = velocidad+acele;
                System.out.println("Estas dentro del rango de la velocidad permitida: "+velocidad);
                System.out.println(" el vehiculo es : "+getClass());
            }
        }catch (myException my){
            System.out.println("ERROR "+my.getMessage());
            System.out.println(" el vehiculo es : "+getClass());
        }
    }
    public void frena(){

    }
}
