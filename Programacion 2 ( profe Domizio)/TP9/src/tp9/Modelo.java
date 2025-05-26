/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp9;

import java.io.Serializable;
import java.sql.*; 

/**
 *
 * @author pcast
 */
public class Modelo implements Serializable  {
    
    private String nombre;
    private String carrera;

    public Modelo() {
    }

    public Modelo(String nombre, String carrera) {
        this.nombre = nombre;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
}
