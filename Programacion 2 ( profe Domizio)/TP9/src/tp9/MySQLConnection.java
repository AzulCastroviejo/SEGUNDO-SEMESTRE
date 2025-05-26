/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tp9;

import java.sql.*;

public class MySQLConnection {
    
     static String url = "jdbc:mysql://localhost:3307/ej";
     static String usuario = "root";
     static String contraseña = "root";
     
     public static Connection conectar(){
         
         Connection con = null;
         try{
             con= DriverManager.getConnection(url,usuario, contraseña);
             System.out.println("Conexion exitosa");
         }catch(SQLException e){
             e.printStackTrace();
         }
         
         return con;
     }
}
