package org.example.cliente;

import org.example.auto.Auto;

import java.util.List;

public interface ClienteDAO {

    int crear(Cliente cliente);
    // Read
    Cliente buscarPorId(int id);
    List<Cliente> listarTodosClientes();
    // Update
    boolean actualizar(Cliente cliente);

    // Delete
    boolean eliminar(int id);
}
