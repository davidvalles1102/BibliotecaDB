package com.BibliotecaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Libro {
    private String codigo;
    private String titulo;
    private String autor;
    private int paginas;
    private String editorial;
    private String isbn;
    private int anio;
    private int unidades;

    // Constructor
    public Libro(String codigo, String titulo, String autor, int paginas, String editorial, String isbn, int anio, int unidades) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.editorial = editorial;
        this.isbn = isbn;
        this.anio = anio;
        this.unidades = unidades;
    }

    // Método para guardar el libro en la base de datos
    public void guardarEnDB() throws SQLException {
        Connection connection = DatabaseConnection.getConnection(); // Asegúrate de que DatabaseConnection esté configurado correctamente

        String sql = "INSERT INTO libros (codigo, titulo, autor, paginas, editorial, isbn, anio, unidades) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, this.codigo);
            statement.setString(2, this.titulo);
            statement.setString(3, this.autor);
            statement.setInt(4, this.paginas);
            statement.setString(5, this.editorial);
            statement.setString(6, this.isbn);
            statement.setInt(7, this.anio);
            statement.setInt(8, this.unidades);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Libro guardado correctamente");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al guardar el libro en la base de datos", e);
        }
    }
}
