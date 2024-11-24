package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ObraForm extends JFrame {
    private JTextField txtCodigo, txtTitulo, txtAutor, txtPaginas, txtGenero, txtFechaPublicacion, txtUbicacion, txtUnidades, txtUnidadesPrestados, txtUnidadesDisponibles;
    private JButton btnGuardar;

    public ObraForm() {
        setTitle("Registro de Obra");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(12, 2, 5, 5));

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

        add(new JLabel("Páginas:"));
        txtPaginas = new JTextField();
        add(txtPaginas);

        add(new JLabel("Género:"));
        txtGenero = new JTextField();
        add(txtGenero);

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
        btnGuardar = new JButton("Guardar Obra");
        add(btnGuardar);

        // Espacio vacío para centrar el botón
        add(new JLabel(""));

        // Acción al presionar el botón
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarObra();
            }
        });

        setVisible(true);
    }

    private void guardarObra() {
        try {
            // Capturar datos del formulario
            String codigo = txtCodigo.getText();
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            int paginas = Integer.parseInt(txtPaginas.getText());
            String genero = txtGenero.getText();
            String fechapublicacion = txtFechaPublicacion.getText();
            String ubicacion = txtUbicacion.getText();
            int unidades = Integer.parseInt(txtUnidades.getText());
            int unidadesPrestados = Integer.parseInt(txtUnidadesPrestados.getText());
            int unidadesDisponibles = Integer.parseInt(txtUnidadesDisponibles.getText());

            // Crear objeto Obra
            Obra obra = new Obra(codigo, titulo, autor, paginas, genero, fechapublicacion, ubicacion, unidades, unidadesPrestados, unidadesDisponibles);

            // Guardar en la base de datos
            obra.guardarEnDB();
            JOptionPane.showMessageDialog(this, "Obra guardada exitosamente.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar la obra: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new ObraForm();
    }
}
