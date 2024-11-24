package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TesisForm extends JFrame {
    private JTextField txtCodigo, txtTitulo, txtAutor, txtFacultad, txtFechaPublicacion, txtUbicacion, txtUnidades, txtUnidadesPrestados, txtUnidadesDisponibles;
    private JButton btnGuardar;

    public TesisForm() {
        setTitle("Registro de Tesis");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(11, 2, 5, 5));

        // Crear etiquetas y campos de texto
        add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        add(txtCodigo);

        add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        add(txtTitulo);

        add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        add(txtAutor);

        add(new JLabel("Facultad:"));
        txtFacultad = new JTextField();
        add(txtFacultad);

        add(new JLabel("Fecha de Publicación:"));
        txtFechaPublicacion = new JTextField();
        add(txtFechaPublicacion);

        add(new JLabel("Ubicación:"));
        txtUbicacion = new JTextField();
        add(txtUbicacion);

        add(new JLabel("Unidades:"));
        txtUnidades = new JTextField();
        add(txtUnidades);

        add(new JLabel("Unidades Prestados:"));
        txtUnidadesPrestados = new JTextField();
        add(txtUnidadesPrestados);

        add(new JLabel("Unidades Disponibles:"));
        txtUnidadesDisponibles = new JTextField();
        add(txtUnidadesDisponibles);

        // Botón para guardar
        btnGuardar = new JButton("Guardar Tesis");
        add(btnGuardar);

        // Espacio vacío para centrar el botón
        add(new JLabel(""));

        // Acción al presionar el botón
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarTesis();
            }
        });

        setVisible(true);
    }

    private void guardarTesis() {
        try {
            // Capturar datos del formulario
            String codigo = txtCodigo.getText();
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            String facultad = txtFacultad.getText();
            String fechapublicacion = txtFechaPublicacion.getText();
            String ubicacion = txtUbicacion.getText();
            int unidades = Integer.parseInt(txtUnidades.getText());
            int unidadesPrestados = Integer.parseInt(txtUnidadesPrestados.getText());
            int unidadesDisponibles = Integer.parseInt(txtUnidadesDisponibles.getText());

            // Crear objeto Tesis
            Tesis tesis = new Tesis(codigo, titulo, autor, facultad, fechapublicacion, ubicacion, unidades, unidadesPrestados, unidadesDisponibles);

            // Guardar en la base de datos
            tesis.guardarEnDB();
            JOptionPane.showMessageDialog(this, "Tesis guardada exitosamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar la tesis: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new TesisForm();
    }
}
