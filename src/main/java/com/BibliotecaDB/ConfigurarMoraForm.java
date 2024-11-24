package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;

class ConfigurarMoraForm extends JFrame {
    private JTextField txtMoraDiaria;
    private JButton btnGuardar;

    public ConfigurarMoraForm() {
        setTitle("Configurar Mora");
        setSize(300, 150);
        setLayout(new GridLayout(2, 2));

        add(new JLabel("Mora Diaria:"));
        txtMoraDiaria = new JTextField();
        add(txtMoraDiaria);

        btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> guardarMora());
        add(btnGuardar);

        setVisible(true);
    }

    private void guardarMora() {
        double moraDiaria = Double.parseDouble(txtMoraDiaria.getText());
        JOptionPane.showMessageDialog(this, "Mora diaria configurada a: " + moraDiaria);
    }
}
