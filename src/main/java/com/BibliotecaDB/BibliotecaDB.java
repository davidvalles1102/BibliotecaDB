package com.BibliotecaDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BibliotecaDB {
    public static void main(String[] args) {
        // Inicia la aplicación
        SwingUtilities.invokeLater(LoginScreen::new);
    }
}

// Clase para la pantalla de inicio de sesión
class LoginScreen extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;

    public LoginScreen() {
        setTitle("Biblioteca - Inicio de Sesión");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1));

        // Usuario
        JPanel panelUsuario = new JPanel(new FlowLayout());
        JLabel lblUsuario = new JLabel("Usuario:");
        txtUsuario = new JTextField(20);
        panelUsuario.add(lblUsuario);
        panelUsuario.add(txtUsuario);
        add(panelUsuario);

        // Contraseña
        JPanel panelContrasena = new JPanel(new FlowLayout());
        JLabel lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JPasswordField(20);
        panelContrasena.add(lblContrasena);
        panelContrasena.add(txtContrasena);
        add(panelContrasena);

        // Botón Iniciar Sesión
        JButton btnIniciar = new JButton("Iniciar Sesión");
        btnIniciar.addActionListener(new LoginActionListener());
        add(btnIniciar);

        setVisible(true);
    }

    // Action Listener para el botón de inicio de sesión
    class LoginActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String usuario = txtUsuario.getText();
            String contrasena = new String(txtContrasena.getPassword());

            // Validación simulada de usuario
            if ("admin".equals(usuario) && "1234".equals(contrasena)) {
                dispose(); // Cierra la pantalla de inicio de sesión
                new MainMenu("Administrador");
            } else if ("profesor".equals(usuario) && "1234".equals(contrasena)) {
                dispose();
                new MainMenu("Profesor");
            } else if ("alumno".equals(usuario) && "1234".equals(contrasena)) {
                dispose();
                new MainMenu("Alumno");
            } else {
                JOptionPane.showMessageDialog(LoginScreen.this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

// Clase para el menú principal
class MainMenu extends JFrame {
    public MainMenu(String tipoUsuario) {
        setTitle("Biblioteca - Menú Principal");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un menú basado en el tipo de usuario
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menuGestion = new JMenu("Gestión");
        JMenu menuOperaciones = new JMenu("Operaciones");

        if ("Administrador".equals(tipoUsuario)) {
            menuGestion.add(new JMenuItem("Gestión de Usuarios"));
            menuGestion.add(new JMenuItem("Configurar Mora Diaria"));
        } else if ("Profesor".equals(tipoUsuario)) {
            menuGestion.add(new JMenuItem("Gestión de Ejemplares"));
            menuOperaciones.add(new JMenuItem("Préstamos"));
            menuOperaciones.add(new JMenuItem("Devoluciones"));
        } else if ("Alumno".equals(tipoUsuario)) {
            menuOperaciones.add(new JMenuItem("Consultar Ejemplares"));
        }

        menuBar.add(menuGestion);
        menuBar.add(menuOperaciones);

        setVisible(true);
    }
}
