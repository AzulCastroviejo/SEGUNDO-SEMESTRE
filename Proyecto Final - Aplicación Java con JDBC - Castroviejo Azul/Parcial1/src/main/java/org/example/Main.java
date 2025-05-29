package org.example;

import org.example.auto.Auto;
import org.example.auto.AutoDAO;
import org.example.auto.AutoDAOImplement;
import org.example.cliente.Cliente;
import org.example.cliente.ClienteDAO;
import org.example.cliente.ClienteDAOImplement;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import java.util.logging.Logger;



public class Main {
    Scanner leer = new Scanner(System.in);


    private static final Logger logger = Logger.getLogger(Main.class.getName()); // Forma correcta


    public static void main(String[] args) {
        // Inicializar la base de datos
        DatabaseManager.initDatabase();
        logger.info("Inicio del Proyecto");
        System.out.println("=== DEMOSTRACIÓN DE OPERACIONES CRUD CON JDBC ===");
        menu();

    }

    public static void menu() {
        Scanner leer = new Scanner(System.in);
        String accion;
        do {
            System.out.println("------MENU------");
            System.out.println("Crear nuevo CLIENTE -> NC");
            System.out.println("Crear nuevo AUTO -> NA");
            System.out.println("Buscar auto por id  -> BAI");
            System.out.println("Listar autos -> LA");
            System.out.println("Listar clientes -> LC");
            System.out.println("Actualizar autos -> AA");
            System.out.println("Eliminar autos -> EA");
            System.out.println("Finalizar -> F");
            accion = leer.nextLine();

            switch (accion.toUpperCase()) {
                case "NC":
                    nuevoC();
                    break;
                case "NA":
                    nuevoAuto();
                    break;
                case "BAI":
                    Auto autoE = new Auto();
                    System.out.println("Ingresar el id de auto :");
                    int idBuscar = leer.nextInt();
                    autoE = buscarPorIdAuto(idBuscar);
                    break;
                case "LA":
                    listarAutos();
                    break;
                case "AA":
                    actualizarAuto();
                    break;
                case "EA":
                    eliminarAuto();
                    break;
                case "LC":
                    listarClientes();
                    break;
                case "F":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");

            }

        } while (!accion.equals("F"));


    }
        public static void nuevoAuto(){
            Scanner leer = new Scanner(System.in);
            AutoDAO autoDAO = new AutoDAOImplement();
            ClienteDAO clienteDAO = new ClienteDAOImplement();

            System.out.println("\n=== CREAR AUTO ===");
            System.out.println("Ingresar el modelo del auto : ");
            String modelo = leer.nextLine();
            System.out.println("Ingresar la marca : ");
            String marca = leer.nextLine();
            System.out.println("Ingresar el color : ");
            String color = leer.nextLine();
            System.out.println("Ingresar la patente : ");
            String patente = leer.nextLine();
            System.out.println("Ingrese el número de serie : ");
            int numeroSerie = leer.nextInt();
            System.out.println("Ingrese el precio del autor : $");
            Double precio = leer.nextDouble();
            Auto nuevoAuto = new Auto(modelo, marca, color, patente, numeroSerie, precio);
            int idGenerado = autoDAO.crear(nuevoAuto);


            System.out.println("Auto creado con ID: " + idGenerado);
            tipo(nuevoAuto);
        }
    public static void nuevoC(){
        Scanner leer = new Scanner(System.in);
        AutoDAO autoDAO = new AutoDAOImplement();
        ClienteDAO clienteDAO = new ClienteDAOImplement();

        // Crear cliente
        System.out.println("\n=== CREATE CLIENTE ===");
        System.out.println("Ingresa el nombre del nuevo cliente :");
        String nombre = leer.nextLine();
        System.out.println("Ingresa la patente del auto del cliente : ");
        String patenteCliente = leer.nextLine();
        Auto autoCliente = new Auto();
        autoCliente = autoDAO.buscarPorPatente(patenteCliente);

        Cliente nuevo = new Cliente(nombre, autoCliente.getId());
        int idGeneradoCliente = clienteDAO.crear(nuevo);

        System.out.println("Cliente creado con ID: " + idGeneradoCliente);
        tipo(nuevo);
    }
    public static void listarAutos(){
        AutoDAO autoDAO = new AutoDAOImplement();
        System.out.println("\nLista de todos los autos:");
        List<Auto> todosLosAutos = autoDAO.listarTodos();
        for (Auto a : todosLosAutos) {
            System.out.println("Modelo : " + a.getModelo());
            System.out.println("Marca : " + a.getMarca());
            System.out.println("Color : " + a.getColor());
            System.out.println("Patente : " + a.getPatente());
            System.out.println("Número de serie : " + a.getNumeroSerie());
            System.out.println("Precio : $" + a.getPrecio());
            System.out.println("--------------------------------------------------");
        }
    }
    public static void listarClientes(){
        ClienteDAO clienteDAO = new ClienteDAOImplement();
        System.out.println("Lista de los clientes ");
        List<Cliente> todosLosClientes = clienteDAO.listarTodosClientes();
        for (Cliente c:todosLosClientes) {
            System.out.println("Nombre : "+c.getNombre());
            System.out.println("--Auto--");
            Auto autoC = buscarPorIdAuto(c.getAuto_id());
            System.out.println("Id auto : "+c.getAuto_id());
            System.out.println();


        }
    }
    public static Auto  buscarPorIdAuto(int idBuscar) {
        AutoDAO autoDAO = new AutoDAOImplement();
        Scanner leer = new Scanner(System.in);

        Auto autoEncontrado = autoDAO.buscarPorId(idBuscar);

        System.out.println("Modelo : "+autoEncontrado.getModelo());
        System.out.println("Marca : "+autoEncontrado.getMarca());
        System.out.println("Color : "+autoEncontrado.getColor());
        System.out.println("Patente : "+autoEncontrado.getPatente());
        System.out.println("Numero de serie : "+autoEncontrado.getNumeroSerie());
        System.out.println("Precio : "+autoEncontrado.getPrecio());
        return autoEncontrado;

    }

    public static void actualizarAuto(){
        // UPDATE - Actualizar auto

        Scanner leer = new Scanner(System.in);
        AutoDAO autoDAO = new AutoDAOImplement();
        Auto autoEncontrado = new Auto();
        System.out.println("Ingresar el id de auto :");
        int idBuscar = leer.nextInt();
        autoEncontrado = buscarPorIdAuto(idBuscar);

        System.out.println("\n=== UPDATE ===");
        System.out.println("Ingresar el nuevo modelo :");
        autoEncontrado.setModelo(leer.nextLine());
        System.out.println("Ingresar la nueva Marca :");
        autoEncontrado.setMarca(leer.nextLine());
        System.out.println("Ingresar el nuevo color :");
        autoEncontrado.setColor(leer.nextLine());
        System.out.println("Ingresar la nueva patente:");
        autoEncontrado.setPatente(leer.nextLine());
        System.out.println("Ingresar el nuevo número de serie :");
        autoEncontrado.setNumeroSerie(leer.nextInt());
        System.out.println("Ingresar el nuevo precio : $");
        autoEncontrado.setPrecio(leer.nextDouble());

        boolean actualizado = autoDAO.actualizar(autoEncontrado);
        System.out.println("Auto actualizado: " + actualizado);

        // Verificar la actualización
        Auto autoActualizado = autoDAO.buscarPorId(autoEncontrado.getId());
        System.out.println("Auto después de actualizar: " + autoActualizado);
    }

public static void eliminarAuto()  {

    Scanner leer = new Scanner(System.in);
    AutoDAO autoDAO = new AutoDAOImplement();
    // DELETE - Eliminar producto
    System.out.println("\n=== DELETE ===");

        System.out.println("Ingresar el id del auto a eliminar :");
        int idOtroAuto = leer.nextInt();
        boolean eliminado = autoDAO.eliminar(idOtroAuto);
        System.out.println("Auto eliminado: " + eliminado);
        System.out.println("\nLista de autos después de eliminar:");
        autoDAO.listarTodos();

}
public static <T>void tipo(T t){

    System.out.println("El objeto creado desde el metodo generico "+t.toString());


}
}