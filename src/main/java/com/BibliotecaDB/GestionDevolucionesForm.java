package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GestionDevolucionesForm extends JFrame {
    public GestionDevolucionesForm() {
        setTitle("Registrar Devoluciones");
        setSize(400, 300);
        setLayout(new BorderLayout());

        // Etiqueta informativa en el centro
        JLabel lblInfo = new JLabel("Funcionalidad de devoluciones aquí", SwingConstants.CENTER);
        add(lblInfo, BorderLayout.CENTER);

        // Botón para regresar a la pantalla de inicio de sesión
        JButton btnRegresar = new JButton("Regresar al Menu Principal");
        btnRegresar.addActionListener(new RegresarAction());

        // Añadir el botón en la parte inferior
        add(btnRegresar, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);
    }

    // Acción para regresar a la pantalla de inicio de sesión
    private class RegresarAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); // Cierra esta ventana
            SwingUtilities.invokeLater(() -> new LoginScreen()); // Abre la pantalla de inicio de sesión
        }
    }
}