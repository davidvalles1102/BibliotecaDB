package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
//import com.BibliotecaDB.GestionPrestamos;

public class GestionPrestamosForm extends JFrame {

    private JTextField txtCodigoPrestamo;
    private JTextField txtCodigoLibro;
    private JTextField txtUsuario;
    private JTextField txtFechaPrestamo;
    private JTextField txtFechaDevolucion;
    private JTextField txtEstado;
    private JButton btnRegistrar;
    private JButton btnActualizar;

    public GestionPrestamosForm() {
        setTitle("Gestión de Préstamos");
        setSize(400, 400);
        setLayout(new GridLayout(7, 2, 5, 5)); // 7 filas, 2 columnas, separación de 5px

        // Crear etiquetas y campos de texto
        JLabel lblCodigoPrestamo = new JLabel("Código Préstamo:");
        txtCodigoPrestamo = new JTextField();

        JLabel lblCodigoLibro = new JLabel("Código Libro:");
        txtCodigoLibro = new JTextField();

        JLabel lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField();

        JLabel lblFechaPrestamo = new JLabel("Fecha Préstamo (YYYY-MM-DD):");
        txtFechaPrestamo = new JTextField();

        JLabel lblFechaDevolucion = new JLabel("Fecha Devolución (YYYY-MM-DD):");
        txtFechaDevolucion = new JTextField();

        JLabel lblEstado = new JLabel("Estado:");
        txtEstado = new JTextField();

        // Botones
        btnRegistrar = new JButton("Registrar Préstamo");
        btnActualizar = new JButton("Actualizar Estado");

        // Añadir componentes al formulario
        add(lblCodigoPrestamo);
        add(txtCodigoPrestamo);
        add(lblCodigoLibro);
        add(txtCodigoLibro);
        add(lblUsuario);
        add(txtUsuario);
        add(lblFechaPrestamo);
        add(txtFechaPrestamo);
        add(lblFechaDevolucion);
        add(txtFechaDevolucion);
        add(lblEstado);
        add(txtEstado);
        add(btnRegistrar);
        add(btnActualizar);

        // Eventos de botones
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarPrestamo();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarEstado();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);
    }

    private void registrarPrestamo() {
        try {
            // Obtener datos del formulario
            String codigoPrestamo = txtCodigoPrestamo.getText();
            String codigoLibro = txtCodigoLibro.getText();
            String usuario = txtUsuario.getText();
            Date fechaPrestamo = Date.valueOf(txtFechaPrestamo.getText());
            Date fechaDevolucion = Date.valueOf(txtFechaDevolucion.getText());
            String estado = txtEstado.getText();

            // Crear objeto Prestamos
            Prestamos prestamo = new Prestamos(codigoPrestamo, codigoLibro, usuario, fechaPrestamo, fechaDevolucion, estado);
            //prestamo.guardarEnDB();

            JOptionPane.showMessageDialog(this, "Préstamo registrado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, "Formato de fecha inválido", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarEstado() {
        try {
            // Obtener datos del formulario
            String codigoPrestamo = txtCodigoPrestamo.getText();
            String nuevoEstado = txtEstado.getText();

            // Crear objeto Prestamos
            Prestamos prestamo = new Prestamos(codigoPrestamo, null, null, null, null, null);
            prestamo.actualizarEstado(nuevoEstado);

            JOptionPane.showMessageDialog(this, "Estado actualizado correctamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al actualizar el estado: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GestionPrestamosForm::new);
    }
}
