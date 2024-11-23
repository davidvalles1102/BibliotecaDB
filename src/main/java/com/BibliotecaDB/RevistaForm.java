package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RevistaForm extends JFrame {
    private JTextField txtCodigo, txtTitulo, txtAutor, txtPeriodicidad, txtFechaPublicacion, txtUnidades;

    public RevistaForm() {
        setTitle("Registrar Revista");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));

        // Campos para el formulario
        add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        add(txtCodigo);

        add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        add(txtTitulo);

        add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        add(txtAutor);

        add(new JLabel("Periodicidad:"));
        txtPeriodicidad = new JTextField();
        add(txtPeriodicidad);

        add(new JLabel("Fecha de Publicación:"));
        txtFechaPublicacion = new JTextField();
        add(txtFechaPublicacion);

        add(new JLabel("Unidades Disponibles:"));
        txtUnidades = new JTextField();
        add(txtUnidades);

        // Botón para guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarRevista();
            }
        });
        add(btnGuardar);

        setVisible(true);
    }

    private void registrarRevista() {
        try {
            // Leer los datos del formulario
            String codigo = txtCodigo.getText();
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            String periodicidad = txtPeriodicidad.getText();
            String fechaPublicacion = txtFechaPublicacion.getText();
            int unidades = Integer.parseInt(txtUnidades.getText());

            // Crear y guardar la revista en la base de datos
            Revista revista = new Revista(codigo, titulo, autor, periodicidad, fechaPublicacion, unidades);
            revista.guardarEnDB();

            JOptionPane.showMessageDialog(this, "Revista registrada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Cierra la ventana del formulario
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar la revista: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RevistaForm());
    }
}
