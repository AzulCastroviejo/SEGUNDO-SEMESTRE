package org.example.cliente;

import org.example.DatabaseManager;
import org.example.auto.Auto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImplement implements ClienteDAO{



    @Override
    public int crear(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int generatedId = -1;

        try {
            conn = DatabaseManager.getConnection();
            String sql = "INSERT INTO clientes (nombre, auto_id) VALUES (?, ? )";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, cliente.getNombre());
            stmt.setInt(2, cliente.getAuto_id());


            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar ResultSet
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseManager.closeResources(conn, stmt);
        }


        return generatedId;
    }

    @Override
    public Cliente buscarPorId(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        try {
            conn = DatabaseManager.getConnection();
            String sql = "SELECT * FROM clientes WHERE id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            //OBTIENE REGISTROS DE LA DB stmt.executeQuery()
            rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("auto_id")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar ResultSet
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseManager.closeResources(conn, stmt);
        }

        return cliente;
    }

    @Override
    public List<Cliente> listarTodosClientes() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();

        try {
            conn = DatabaseManager.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM clientes";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Cliente cliente= new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getInt("auto_id")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Cerrar ResultSet
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            DatabaseManager.closeResources(conn, stmt);
        }

        return clientes;
    }

    @Override
    public boolean actualizar(Cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean actualizado = false;
        try {
            conn = DatabaseManager.getConnection();
            String sql = "UPDATE clientes SET nombre = ?, auto_id = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, cliente.getNombre());
            stmt.setInt(2, cliente.getAuto_id());


            int affectedRows = stmt.executeUpdate();
            actualizado = (affectedRows > 0);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeResources(conn, stmt);
        }

        return actualizado;
    }

    @Override
    public boolean eliminar(int id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean eliminado = false;

        try {
            conn = DatabaseManager.getConnection();
            String sql = "DELETE FROM clientes WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            int affectedRows = stmt.executeUpdate();
            eliminado = (affectedRows > 0);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseManager.closeResources(conn, stmt);
        }

        return eliminado;
    }
}
