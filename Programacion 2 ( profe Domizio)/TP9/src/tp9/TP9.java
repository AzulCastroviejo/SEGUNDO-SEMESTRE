
package tp9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class TP9 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Modelo mod = new Modelo();
        VistaMenu menu = new VistaMenu();
        Controlador ctrl = new Controlador(menu,mod);
        //ArrayList<Modelo>estudiantes= new ArrayList();

        ctrl.iniciarMenu();
        menu.setVisible(true);
        
       
  
        
        // Recuperar objeto
        /*try( ObjectInputStream modeloRecuperado = new ObjectInputStream(new FileInputStream("modelo.dat"))){
            Modelo modeloR = (Modelo) modeloRecuperado.readObject();
            System.out.println("Nombre: " + modeloR.getNombre());
            System.out.println("Carrera: " + modeloR.getCarrera());
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

       // modeloRecuperado.close();*/
        
        //view.setVisible(true);
        
    }
    
}
