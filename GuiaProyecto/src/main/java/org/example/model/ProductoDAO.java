package org.example.model;
import org.example.model.Producto;
import java.util.List;

public interface ProductoDAO {
    // Create
    int crear(Producto producto);
    // Read
    Producto buscarPorId(int id);
    List<Producto> listarTodos();
    // Update
    boolean actualizar(Producto producto);

    // Delete
    boolean eliminar(int id);

}
