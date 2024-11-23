package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CDForm extends JFrame {
    private JTextField txtCodigo, txtTitulo, txtArtista, txtGenero, txtDuracion, txtCanciones, txtUnidades;

    public CDForm() {
        setTitle("Registrar CD");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 10, 10));

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

        add(new JLabel("Duración:"));
        txtDuracion = new JTextField();
        add(txtDuracion);

        add(new JLabel("Número de Canciones:"));
        txtCanciones = new JTextField();
        add(txtCanciones);

        add(new JLabel("Unidades Disponibles:"));
        txtUnidades = new JTextField();
        add(txtUnidades);

        // Botón para guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarCD();
            }
        });
        add(btnGuardar);

        setVisible(true);
    }

    private void registrarCD() {
        try {
            // Leer los datos del formulario
            String codigo = txtCodigo.getText();
            String titulo = txtTitulo.getText();
            String artista = txtArtista.getText();
            String genero = txtGenero.getText();
            int duracion = Integer.parseInt(txtDuracion.getText());
            int canciones = Integer.parseInt(txtCanciones.getText());
            int unidades = Integer.parseInt(txtUnidades.getText());

            // Crear el CD
            CD cd = new CD(codigo, titulo, artista, genero, duracion, canciones, unidades);

            // Guardar el CD en la base de datos
            cd.guardarEnDB();

            // Mensaje de éxito
            JOptionPane.showMessageDialog(this, "CD registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Cierra la ventana del formulario
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar el CD: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CDForm());
    }
}
