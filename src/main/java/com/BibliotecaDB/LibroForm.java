package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibroForm extends JFrame {
    private JTextField txtCodigo, txtTitulo, txtAutor, txtEditorial, txtIsbn, txtAnio, txtPaginas, txtUnidades;

    public LibroForm() {
        setTitle("Registrar Libro");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 2, 10, 10));

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

        add(new JLabel("Número de Páginas:"));
        txtPaginas = new JTextField();
        add(txtPaginas);

        add(new JLabel("Editorial:"));
        txtEditorial = new JTextField();
        add(txtEditorial);

        add(new JLabel("ISBN:"));
        txtIsbn = new JTextField();
        add(txtIsbn);

        add(new JLabel("Año:"));
        txtAnio = new JTextField();
        add(txtAnio);

        add(new JLabel("Unidades Disponibles:"));
        txtUnidades = new JTextField();
        add(txtUnidades);

        // Botón para guardar
        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarLibro();
            }
        });
        add(btnGuardar);

        setVisible(true);
    }

    private void registrarLibro() {
        try {
            // Leer los datos del formulario
            String codigo = txtCodigo.getText();
            String titulo = txtTitulo.getText();
            String autor = txtAutor.getText();
            int paginas = Integer.parseInt(txtPaginas.getText());
            String editorial = txtEditorial.getText();
            String isbn = txtIsbn.getText();
            int anio = Integer.parseInt(txtAnio.getText());
            int unidades = Integer.parseInt(txtUnidades.getText());

            // Crear y guardar el libro en la base de datos
            Libro libro = new Libro(codigo, titulo, autor, paginas, editorial, isbn, anio, unidades);
            libro.guardarEnDB();

            JOptionPane.showMessageDialog(this, "Libro registrado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            dispose(); // Cierra la ventana del formulario
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al registrar el libro: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibroForm());
    }
}
