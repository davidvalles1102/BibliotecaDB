package com.BibliotecaDB;

public class Usuario {
    private String nombre;
    private String usuario;
    private String contrasena;
    private String rol; // "Administrador", "Profesor", "Alumno"

    public Usuario(String nombre, String usuario, String contrasena, String rol) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getUsuario() { return usuario; }
    public String getContrasena() { return contrasena; }
    public String getRol() { return rol; }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
