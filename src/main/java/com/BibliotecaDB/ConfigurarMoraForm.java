package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;

class ConfigurarMoraForm extends JFrame {
    private JTextField txtMoraDiaria;
    private JButton btnGuardar, btnRegresar;

    public ConfigurarMoraForm() {
        setTitle("Configurar Mora");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2, 10, 10)); // Se ajusta el diseño para incluir el botón de regresar

        // Campo para la mora diaria
        add(new JLabel("Mora Diaria:"));
        txtMoraDiaria = new JTextField();
        add(txtMoraDiaria);

        // Botón para guardar
        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarMora());
        add(btnGuardar);

        // Botón para regresar al menú principal
        btnRegresar = new JButton("Regresar al Menú Principal");
        btnRegresar.addActionListener(e -> {
            dispose(); // Cierra la ventana actual
            SwingUtilities.invokeLater(() -> new MainMenu("Administrador")); // Abre el menú principal para el Administrador
        });
        add(btnRegresar);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);
    }

    private void guardarMora() {
        try {
            double moraDiaria = Double.parseDouble(txtMoraDiaria.getText());
            JOptionPane.showMessageDialog(this, "Mora diaria configurada a: " + moraDiaria);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
