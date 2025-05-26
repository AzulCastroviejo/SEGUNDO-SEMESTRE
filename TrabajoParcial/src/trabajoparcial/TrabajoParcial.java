/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package trabajoparcial;

import java.sql.*;

public class TrabajoParcial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        IngresoAutor nuevo =  new IngresoAutor();
        Controlador control = new Controlador(menu, nuevo);
        control.iniciarMenu();
    }
    
}
