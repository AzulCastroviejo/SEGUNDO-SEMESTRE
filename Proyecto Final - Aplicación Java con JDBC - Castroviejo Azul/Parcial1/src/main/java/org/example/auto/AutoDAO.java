package org.example.auto;

import java.util.List;

public interface AutoDAO {

//o	Crear, leer (listar y buscar por ID), actualizar y eliminar registros.

    // Create
    int crear(Auto auto);
    // Read
    Auto buscarPorId(int id);
    Auto buscarPorPatente(String patente);
    List<Auto> listarTodos();
    // Update
    boolean actualizar(Auto auto);

    // Delete
    boolean eliminar(int id);

}
