
package trabajoparcial;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {
    public  Menu menu;
    public IngresoAutor ingreso;
    public Autor autor;
    public Mostrar mostrar;

    public Controlador() {
    }

    public Controlador(Menu menu, IngresoAutor ingreso) {
        this.menu = menu;
        this.ingreso = ingreso;
    }
    public Controlador(Menu menu, Autor autor) {
        this.menu = menu;
        this.autor= autor;
    }
     public Controlador(Mostrar mostrar, Autor autor) {
        this.mostrar = mostrar;
        this.autor= autor;
    }

    public Controlador( IngresoAutor ingreso, Autor autor) {
      
        this.ingreso = ingreso;
        this.autor = autor;
    }
    
    public Controlador(Menu menu, IngresoAutor ingreso, Autor autor) {
        this.menu = menu;
        this.ingreso = ingreso;
        this.autor = autor;
    }
    
    public Controlador(Menu menu, IngresoAutor ingreso, Autor autor , Mostrar mostrar) {
        this.menu = menu;
        this.ingreso = ingreso;
        this.autor = autor;
        this.mostrar = mostrar;
    }

    public void iniciarMenu(){
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     public void guardarAutor() throws FileNotFoundException, IOException, SQLException{
         System.out.println("Ingresa a guardarAutor()");
        // settteamos los datos al autor
        autor.nombre = ingreso.Nombre.getText();
        autor.pseudonimo = ingreso.Pseudonimo.getText();
        autor.dni = Integer.parseInt(ingreso.dni.getText());
        
        // creamos la query para insertar en la base de datos
        String query= "insert into persona(nombre , dni) values (?,?)";
        String query2 = "insert into autor(pseudonimo , idPersona ) values (?,?)";
        Connection con = MySQLConnection.conectar();
            // enviamos la query de insert a la DB
            
        try (PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);){//Statement.RETURN_GENERATED_KEYS -> sirve para traer el id de persona 
          
            //SETEAMOS LOS DATOS A LOS VALORES DEL INSERT
            ps.setString(1, autor.nombre);
            ps.setInt(2, autor.dni);
            ps.executeUpdate();
        try( ResultSet rs = ps.getGeneratedKeys()){
             int idPersona = 0;
            if(rs.next()){
                idPersona = rs.getInt(1); 
            }
           
               
        try( PreparedStatement pAutor = con.prepareStatement(query2)){
           
            pAutor.setString(1, autor.pseudonimo);
            pAutor.setInt(2, idPersona);
                
            pAutor.executeUpdate();
            System.out.println("se SUBIO A LA DB EL AUTOR CON "+idPersona);
           
            rs.close();
            ps.close();
            pAutor.close();
        }catch(SQLException ex){
            System.out.println("Error al insertar dato en DB");
            ex.printStackTrace();
            
        }
     
        
    }
        }
     }
     
   
     
     public DefaultTableModel mostrarAutores(DefaultTableModel tabla){
         
         String queryMostrar = "SELECT * FROM persona , autor where persona.idPersona = autor.idPersona ";
         
         try{
              Connection  con = MySQLConnection.conectar();
              PreparedStatement ps = con.prepareStatement(queryMostrar);
              ResultSet rs = ps.executeQuery();
             
              while(rs.next()){
                  autor.dni = rs.getInt("dni");
                  autor.nombre = rs.getString("nombre");
                  autor.pseudonimo = rs.getString("pseudonimo");
                  String texto = ("Nombre : "+rs.getString("nombre")+ " pseudonimo : "+rs.getString("pseudonimo")+ "dni : "+rs.getInt("dni"));
                  mostrar.nombreAutor.setText(texto);
                    Object[]fila = {rs.getInt("idPersona"), rs.getString("nombre"),rs.getInt("dni"),rs.getString("pseudonimo")}; 
                  tabla.addRow(fila);
//                  System.out.println("dni : "+rs.getInt("dni"));
//                  System.out.println("nombre : "+rs.getString("nombre"));
//                  System.out.println("pseudonimo : "+rs.getString("pseudonimo"));
                 
                  
                  //mostrar.nombreAutor.setText("Nombre : "+autor.nombre + " DNI : "+autor.dni + " Pseudonimo : "+autor.pseudonimo);
                  
                  // mostrar.setVisible(true);
              }
              
         }catch(SQLException ex){
              System.out.println("Error al BUSCAR dato en DB");
             ex.printStackTrace();
             
         }
        return tabla;
         
     }

   
    public ArrayList<Autor> mostrarLista(){
        ArrayList<Autor> lista = new ArrayList<>();
        String queryMostrar = "SELECT * FROM persona , autor where persona.idPersona = autor.idPersona ";
         
         try{
              Connection  con = MySQLConnection.conectar();
              PreparedStatement ps = con.prepareStatement(queryMostrar);
              ResultSet rs = ps.executeQuery();
             
              while(rs.next()){
                  autor.dni = rs.getInt("dni");
                  autor.nombre = rs.getString("nombre");
                  autor.pseudonimo = rs.getString("pseudonimo");
                  lista.add(autor);
                  System.out.println("nom"+autor.nombre);
                                    System.out.println("dni"+autor.dni);
                                System.out.println("pse"+autor.pseudonimo);

                  //String texto = ("Nombre : "+rs.getString("nombre")+ " pseudonimo : "+rs.getString("pseudonimo")+ "dni : "+rs.getInt("dni"));
                  
//                  System.out.println("dni : "+rs.getInt("dni"));
//                  System.out.println("nombre : "+rs.getString("nombre"));
//                  System.out.println("pseudonimo : "+rs.getString("pseudonimo"));
//                  mostrar.dniAutor.setText( String.valueOf(autor.dni));
//                  mostrar.nombreAutor.setText(autor.nombre);
//                  mostrar.pseudonimoAutor.setText(autor.pseudonimo);
//                   mostrar.setVisible(true);
              }
              return lista;
         }catch(SQLException ex){
              System.out.println("Error al BUSCAR dato en DB");
             ex.printStackTrace();
             
         }
        return null;
         
     }
}
    
    
