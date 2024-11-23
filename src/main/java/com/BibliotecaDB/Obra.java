package com.BibliotecaDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Obra{
    private String codigo;
    private String titulo;
    private String autor;
    private int paginas;
    private String genero;
    private String fechapublicacion;
    private String ubicacion;
    private int unidades;
    private int unidadesprestados;
    private int unidadesdisponibles;

    public Obra(String codigo, String titulo, String autor, int paginas, String genero, String fechapublicacion, String ubicacion, int unidades, int unidadesprestados, int unidadesdisponibles) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.genero = genero;
        this.fechapublicacion = fechapublicacion;
        this.ubicacion = ubicacion;
        this.unidades = unidades;
        this.unidadesprestados = unidadesprestados;
        this.unidadesdisponibles = unidadesdisponibles;
    }

    // Método para guardar el libro en la base de datos
    public void guardarEnDB() throws SQLException {
        Connection connection = DatabaseConnection.getConnection(); // Asegúrate de que DatabaseConnection esté configurado correctamente

        String sql = "INSERT INTO libros (codigo, titulo, autor, paginas, genero, fechapublicacion, ubicacion,  unidades, unidadesprstados, unidadesdisponible) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, this.codigo);
            statement.setString(2, this.titulo);
            statement.setString(3, this.autor);
            statement.setInt(4, this.paginas);
            statement.setString(5, this.genero);
            statement.setString(6, this.fechapublicacion);
            statement.setString(7, this.ubicacion);
            statement.setInt(8, this.unidades);
            statement.setInt(9, this.unidadesprestados);
            statement.setInt(10, this.unidadesdisponibles);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("se guardo la Obra guardado correctamente");
            }
        } catch (SQLException e) {
            throw new SQLException("Error al guardar el Obra en la base de datos", e);
        }
    }


}//
