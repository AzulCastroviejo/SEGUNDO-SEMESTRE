public class Chofer {
    private String nombre;
    public Matricula matricula;

    public Chofer(String nombre) {
        this.nombre = nombre;
    }

    public Chofer(String nombre, Matricula matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean verificar(int fechaActual){
       boolean x = true;
        try {
            if(matricula.fechaVto > fechaActual){
                throw new matriculaVencida("matricula vencida");
            }else {
                System.out.println("La matricula de : "+ nombre +" esta al dia");
            }
        }catch (matriculaVencida mv){
            x = false;
            System.out.println(mv.getMessage());
        }finally {
            return x;
        }


    }
}
