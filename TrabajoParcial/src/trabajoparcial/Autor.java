
package trabajoparcial;


public class Autor extends Persona{
    public String pseudonimo;

    public Autor() {
    }

    public Autor(String pseudonimo, int dni, String nombre) {
        super(dni, nombre);
        this.pseudonimo = pseudonimo;
    }
    
}
