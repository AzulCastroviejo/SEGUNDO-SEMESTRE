/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author pcast
 */
public class Controlador implements ActionListener{
    private Vista vista;
    private VistaMenu menu;
    private Modelo model;
    
    public Controlador() {
    }

    public Controlador( VistaMenu menu, Modelo model) {
        
        this.menu = menu;
        this.model = model;
        //this.vista.Guardar.addActionListener(this);
       // this.menu.Menu.addActionListener(this);
       
        
    }

    public Controlador(Vista vista, Modelo model) {
        this.vista = vista;
        this.model = model;
    }
    

    public Controlador(Vista vista, VistaMenu menu, Modelo model) {
        this.vista = vista;
        this.menu = menu;
        this.model = model;
    }
    
    
     public void iniciarMenu(){
        menu.setTitle("Menu");
        menu.setLocationRelativeTo(null);
        
    }
    
   

    @Override
    public void actionPerformed(ActionEvent e) {
       
       menu.setVisible(true);
       
       
  
       //Llegue a que se guarden los datos y se vean en los txt de pruebas 
       //Falta que lo persista como ? no se je
 
               }
    public void guardarDato() throws FileNotFoundException, IOException{
        model.setNombre(vista.RecepcionNombre.getText());
       
        if(vista.jRadioButton1.isSelected()){
            model.setCarrera("Programacion");
       }
        if(vista.jRadioButton2.isSelected()){
         model.setCarrera("Ingenieria");
       }
        if(vista.jRadioButton3.isSelected()){
           model.setCarrera("Analisis");}
        ArrayList agregar = new ArrayList();
        agregar.add(model);
        // persistir
        ObjectOutputStream objetoGuardar = new ObjectOutputStream(new FileOutputStream("modelo.dat"));
        
        //objetoGuardar.writeObject(model);
        
        objetoGuardar.writeObject(agregar);
        
        objetoGuardar.close();
       
        vista.control.mostrarEstudiante(); 
        
    }
     
    public void mostrarDato() throws FileNotFoundException, IOException, ClassNotFoundException{
        // persistir
       
        
        ObjectInputStream objetoMostrar = new ObjectInputStream(new FileInputStream("modelo.dat"));
        
        ArrayList<Modelo>mostrarEstudiantes =  (ArrayList)objetoMostrar.readObject();
       // Modelo modeloMostrar = (Modelo)objetoMostrar.readObject(); 
        System.out.println("Viendo los objetos");
       
        for(Modelo model:mostrarEstudiantes){
            System.out.println("Nombre : "+ model.getNombre());
            System.out.println("Carrera : "+ model.getCarrera());
            System.out.println("-----------------------------------------------");
        }
        
        objetoMostrar.close();
    }
    
    public String mostrarCarpeta(){
        
        return new File("modelo.dat").getAbsolutePath();
    }
    
    public String mostrarUnidad(){
        
        return new File("modelo.dat").getAbsolutePath();
    }
      /*public void iniciarFormulario(){
          menu.setTitle("")
      }
      */
    
    /* public void iniciarFormulario(){
         
        vista.setTitle("Formulario");
        vista.setLocationRelativeTo(null);
    }*/
    
   /* public void formulario(ActionEvent e){
        menu.setVisible(false);
        
        vista.setVisible(true);
        model.setNombre(vista.RecepcionNombre.getText());
        //if(vista.Grupo.isSelected(jRadioButton1))){
         if(vista.jRadioButton1.isSelected()){
            model.setCarrera("Programacion");
       }
       if(vista.jRadioButton2.isSelected()){
         model.setCarrera("Ingenieria");
       }
       if(vista.jRadioButton3.isSelected()){
           model.setCarrera("Analisis");}
        
    }*/
    
    public void mostrarEstudiante(){
        System.out.println("Ingreso exitoso");
        System.out.println("Nombre : "+this.model.getNombre());
        System.out.println("Carrera : "+this.model.getCarrera());
    }
    
}
