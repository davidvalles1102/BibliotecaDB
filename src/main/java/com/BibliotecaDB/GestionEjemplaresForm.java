package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;

class GestionEjemplaresForm extends JFrame {
    private JTextField txtCodigo, txtTitulo, txtAutor, txtUbicacion, txtTipo;
    private JButton btnAgregar, btnConsultar, btnRegresar;

    public GestionEjemplaresForm() {
        setTitle("Gestión de Ejemplares");
        setSize(400, 400);
        setLayout(new BorderLayout(10, 10));

        // Panel de entrada de datos
        JPanel panelDatos = new JPanel();
        panelDatos.setLayout(new GridLayout(6, 2, 10, 10));

        panelDatos.add(new JLabel("Código:"));
        txtCodigo = new JTextField();
        panelDatos.add(txtCodigo);

        panelDatos.add(new JLabel("Título:"));
        txtTitulo = new JTextField();
        panelDatos.add(txtTitulo);

        panelDatos.add(new JLabel("Autor:"));
        txtAutor = new JTextField();
        panelDatos.add(txtAutor);

        panelDatos.add(new JLabel("Ubicación:"));
        txtUbicacion = new JTextField();
        panelDatos.add(txtUbicacion);

        panelDatos.add(new JLabel("Tipo (Libro/CD/Revista/Tesis):"));
        txtTipo = new JTextField();
        panelDatos.add(txtTipo);

        // Botones para agregar y consultar ejemplares
        btnAgregar = new JButton("Agregar");
        btnAgregar.addActionListener(e -> agregarEjemplar());
        panelDatos.add(btnAgregar);

        btnConsultar = new JButton("Consultar");
        btnConsultar.addActionListener(e -> consultarEjemplar());
        panelDatos.add(btnConsultar);

        add(panelDatos, BorderLayout.CENTER);

        // Botón para regresar a la pantalla de inicio de sesión
        btnRegresar = new JButton("Regresar al Menu Principal");
        btnRegresar.addActionListener(e -> {
            dispose(); // Cierra esta ventana
            SwingUtilities.invokeLater(() -> new LoginScreen()); // Abre la pantalla de inicio de sesión
        });

        add(btnRegresar, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);
    }

    private void agregarEjemplar() {
        // Implementar lógica para agregar ejemplares
        JOptionPane.showMessageDialog(this, "Ejemplar agregado.");
    }

    private void consultarEjemplar() {
        // Implementar lógica para buscar ejemplares
        JOptionPane.showMessageDialog(this, "Consulta realizada.");
    }
}