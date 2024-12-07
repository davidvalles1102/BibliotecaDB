package com.BibliotecaDB;

import com.BibliotecaDB.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Prestamos {

    private String codigoPrestamo;
    private String codigoLibro;  // Relación con el libro
    private String usuario;      // Nombre o ID del usuario
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private String estado;       // Ejemplo: "pendiente", "devuelto"

    // Constructor
    public Prestamos(String codigoPrestamo, String codigoLibro, String usuario, Date fechaPrestamo, Date fechaDevolucion, String estado) {
        this.codigoPrestamo = codigoPrestamo;
        this.codigoLibro = codigoLibro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.estado = estado;
    }

//Metodo para registrar un préstamo en la base de datos



    // Metodo para actualizar el estado de un préstamo

    public void actualizarEstado(String nuevoEstado) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();

        String sql = "UPDATE prestamos SET estado = ? WHERE codigo_prestamo = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, nuevoEstado);
            statement.setString(2, this.codigoPrestamo);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Estado del préstamo actualizado correctamente");
                this.estado = nuevoEstado;
            } else {
                System.out.println("No se pudo actualizar el estado del préstamo");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al actualizar el estado del préstamo", e);
        }
    }
}

