package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;

class CDForm extends JFrame {
    private JTextField txtCodigo, txtTitulo, txtArtista, txtGenero, txtDuracion, txtNumCanciones, txtUnidades;

    public CDForm() {
        setTitle("Registrar CD"); // Título de la ventana
        setSize(400, 400); // Tamaño de la ventana
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana en pantalla
        setLayout(new GridLayout(8, 2, 10, 10)); // Disposición de los componentes

        // Campos para el formulario
        add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        add(txtCodigo);

        add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        add(txtTitulo);

        add(new JLabel("Artista:"));
        txtArtista = new JTextField();
        add(txtArtista);

        add(new JLabel("Género:"));
        txtGenero = new JTextField();
        add(txtGenero);

        add(new JLabel("Duración (min):"));
        txtDuracion = new JTextField();
        add(txtDuracion);

        add(new JLabel("Número de Canciones:"));
        txtNumCanciones = new JTextField();
        add(txtNumCanciones);

        add(new JLabel("Unidades Disponibles:"));
        txtUnidades = new JTextField();
        add(txtUnidades);

        // Botón Guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> registrarCD());
        add(btnGuardar);

        // Hacer visible la ventana
        setVisible(true);
    }

    private void registrarCD() {
        try {
            // Leer datos del formulario
            String codigo = txtCodigo.getText();
            String titulo = txtTitulo.getText();
            String artista = txtArtista.getText();
            String genero = txtGenero.getText();
            int duracion = Integer.parseInt(txtDuracion.getText());
            int numCanciones = Integer.parseInt(txtNumCanciones.getText());
            int unidades = Integer.parseInt(txtUnidades.getText());

            // Crear y guardar CD en la base de datos
            CD cd = new CD(codigo, titulo, artista, genero, duracion, numCanciones, unidades);
            cd.guardarEnDB();

            JOptionPane.showMessageDialog(this, "CD registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Cierra la ventana
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar el CD: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
