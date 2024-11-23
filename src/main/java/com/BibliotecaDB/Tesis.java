package com.BibliotecaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Tesis {
    private String codigo;
    private String titulo;
    private String autor;
    private String facultad;
    private String fechapublicacion;
    private String ubicacion;
    private int unidades;
    private int unidadesprestados;
    private int unidadesdisponibles;

    public Tesis(String codigo, String titulo, String autor, String facultad, String fechapublicacion, String ubicacion, int unidades, int unidadesprestados, int unidadesdisponibles) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.facultad = facultad;
        this.fechapublicacion = fechapublicacion;
        this.ubicacion = ubicacion;
        this.unidades = unidades;
        this.unidadesprestados = unidadesprestados;
        this.unidadesdisponibles = unidadesdisponibles;
    }

    // Método para guardar la tesis en la base de datos
    public void guardarEnDB() throws SQLException {
        Connection connection = DatabaseConnection.getConnection(); // Asegúrate de que DatabaseConnection esté configurado correctamente

        // Corregir la consulta SQL para que coincida con los campos de la clase Tesis
        String sql = "INSERT INTO tesis (codigo, titulo, autor, facultad, fechapublicacion, ubicacion, unidades, unidadesprestados, unidadesdisponibles) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, this.codigo);
            statement.setString(2, this.titulo);
            statement.setString(3, this.autor);
            statement.setString(4, this.facultad);
            statement.setString(5, this.fechapublicacion);
            statement.setString(6, this.ubicacion);
            statement.setInt(7, this.unidades);
            statement.setInt(8, this.unidadesprestados);
            statement.setInt(9, this.unidadesdisponibles);

            // Ejecutar la actualización y verificar si se insertaron filas
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Tesis guardada correctamente");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al guardar la tesis en la base de datos", e);
        }
    }
}
