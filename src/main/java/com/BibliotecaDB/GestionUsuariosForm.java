package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;

class GestionUsuariosForm extends JFrame {
    private JTextField txtNombre, txtUsuario, txtRol;
    private JPasswordField txtContrasena;
    private JButton btnAgregar, btnRestablecer, btnRegresar;

    public GestionUsuariosForm() {
        setTitle("Gestión de Usuarios");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2)); // Mantengo el número de filas a 6

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        add(txtUsuario);

        add(new JLabel("Contraseña:"));
        txtContrasena = new JPasswordField();
        add(txtContrasena);

        add(new JLabel("Rol (Admin/Profesor/Alumno):"));
        txtRol = new JTextField();
        add(txtRol);

        btnAgregar = new JButton("Agregar Usuario");
        btnAgregar.addActionListener(e -> agregarUsuario());
        add(btnAgregar);

        btnRestablecer = new JButton("Restablecer Contraseña");
        btnRestablecer.addActionListener(e -> restablecerContrasena());
        add(btnRestablecer);

        // Botón para regresar a la pantalla de inicio de sesión
        btnRegresar = new JButton("Regresar al Login Screen");
        btnRegresar.addActionListener(e -> {
            dispose(); // Cierra la ventana actual
            SwingUtilities.invokeLater(() -> new LoginScreen()); // Abre la pantalla de inicio de sesión
        });
        add(btnRegresar);

        setVisible(true);
    }

    private void agregarUsuario() {
        // Aquí puedes implementar la lógica para guardar el usuario en la base de datos.
        String nombre = txtNombre.getText();
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());
        String rol = txtRol.getText();

        JOptionPane.showMessageDialog(this, "Usuario " + nombre + " agregado con rol " + rol);
    }

    private void restablecerContrasena() {
        String usuario = txtUsuario.getText();
        String nuevaContrasena = new String(txtContrasena.getPassword());
        // Implementa lógica para actualizar la contraseña en la base de datos.
        JOptionPane.showMessageDialog(this, "Contraseña restablecida para el usuario: " + usuario);
    }
}