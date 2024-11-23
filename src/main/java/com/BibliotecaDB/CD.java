package com.BibliotecaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CD {
    private String codigo;
    private String titulo;
    private String artista;
    private String genero;
    private int duracion;
    private int canciones;
    private int unidadesDisponibles;

    public CD(String codigo, String titulo, String artista, String genero, int duracion, int canciones, int unidadesDisponibles) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.canciones = canciones;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public void guardarEnDB() {
        String sql = "INSERT INTO cds (codigo, titulo, artista, genero, duracion, canciones, unidades) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, codigo);
            pstmt.setString(2, titulo);
            pstmt.setString(3, artista);
            pstmt.setString(4, genero);
            pstmt.setInt(5, duracion);
            pstmt.setInt(6, canciones);
            pstmt.setInt(7, unidadesDisponibles);

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("CD guardado exitosamente en la base de datos");
            } else {
                System.out.println("No se guardó ningún CD en la base de datos.");
            }
        } catch (SQLException e) {
            System.err.println("Error al guardar el CD en la base de datos: " + e.getMessage());
        }
    }
}
