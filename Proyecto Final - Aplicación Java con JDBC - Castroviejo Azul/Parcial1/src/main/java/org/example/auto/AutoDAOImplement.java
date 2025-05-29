package org.example.auto;

import org.example.DatabaseManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutoDAOImplement implements AutoDAO{


    @Override
    public int crear(Auto auto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int generatedId = -1;


        try {
            conn = DatabaseManager.getConnection();
            String sql = "INSERT INTO autos (modelo, marca, color,patente , numeroSerie, precio) VALUES (?, ?, ?, ? , ? , ?)";
            stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            stmt.setString(1, auto.getModelo());
            stmt.setString(2, auto.getMarca());
            stmt.setString(3, auto.getColor());
            stmt.setString(4, auto.getPatente());
            stmt.setInt(5, auto.getNumeroSerie());
            stmt.setDouble(6, auto.getPrecio());

            int affectedRows = stmt.executeUpdate();


            System.out.println("Auto agregado correctamente.");



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
    public Auto buscarPorId(int auto_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Auto auto = null;
        try {
            conn = DatabaseManager.getConnection();
            String sql = "SELECT * FROM autos WHERE auto_id = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, auto_id);

            //OBTIENE REGISTROS DE LA DB stmt.executeQuery()
            rs = stmt.executeQuery();

            if (rs.next()) {
                auto = new Auto(
                        rs.getInt("auto_id"),
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getString("color"),
                        rs.getString("patente"),
                        rs.getInt("numeroSerie"),
                        rs.getDouble("precio")
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

        return auto ;
    }

    @Override
    public Auto buscarPorPatente(String patente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Auto auto = null;
        try {
            conn = DatabaseManager.getConnection();
            String sql = "SELECT * FROM autos WHERE patente = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, patente);

            //OBTIENE REGISTROS DE LA DB stmt.executeQuery()
            rs = stmt.executeQuery();

            if (rs.next()) {
                auto = new Auto(
                        rs.getInt("auto_id"),
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getString("color"),
                        rs.getString("patente"),
                        rs.getInt("numeroSerie"),
                        rs.getDouble("precio")
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

        return auto ;
    }

    @Override
    public List<Auto> listarTodos() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        List<Auto> autos = new ArrayList<>();

        try {
            conn = DatabaseManager.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT * FROM autos";

            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Auto auto = new Auto(
                        rs.getInt("auto_id"),
                        rs.getString("modelo"),
                        rs.getString("marca"),
                        rs.getString("color"),
                        rs.getString("patente"),
                        rs.getInt("numeroSerie"),
                        rs.getDouble("precio")
                );
                autos.add(auto);
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

        return autos;
    }

    @Override
    public boolean actualizar(Auto auto) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean actualizado = false;
        try {
            conn = DatabaseManager.getConnection();
            String sql = "UPDATE autos SET modelo = ?, marca = ?, color = ?, patente = ? , numeroSerie = ? , precio = ? WHERE id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, auto.getModelo());
            stmt.setString(2, auto.getMarca());
            stmt.setString(3, auto.getColor());
            stmt.setString(4, auto.getPatente());
            stmt.setInt(5, auto.getNumeroSerie());
            stmt.setDouble(6, auto.getPrecio());

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
    public boolean eliminar(int auto_id) {
        Connection conn = null;
        PreparedStatement stmt = null;
        boolean eliminado = false;

        try {
            conn = DatabaseManager.getConnection();
            String sql = "DELETE FROM autos WHERE auto_id = ?";
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, auto_id);

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


