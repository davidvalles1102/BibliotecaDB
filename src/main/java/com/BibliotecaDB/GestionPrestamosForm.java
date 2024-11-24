package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;

class GestionPrestamosForm extends JFrame {
    private JButton btnRegresar;

    public GestionPrestamosForm() {
        setTitle("Registrar Préstamos");
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Etiqueta con la funcionalidad
        JLabel lblInfo = new JLabel("Funcionalidad de préstamos aquí", SwingConstants.CENTER);
        add(lblInfo, BorderLayout.CENTER);

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
}