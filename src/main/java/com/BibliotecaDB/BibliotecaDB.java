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
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setBackground(new Color(240, 240, 240));

        // Panel de contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(contentPanel, BorderLayout.CENTER);

        // Título
        JLabel lblTitulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(lblTitulo);

        // Espaciado
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Usuario
        JPanel panelUsuario = createInputPanel("Usuario:", txtUsuario = new JTextField(20));
        contentPanel.add(panelUsuario);

        // Espaciado
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        // Contraseña
        JPanel panelContrasena = createInputPanel("Contraseña:", txtContrasena = new JPasswordField(20));
        contentPanel.add(panelContrasena);

        // Espaciado
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        // Botón Iniciar Sesión
        JButton btnIniciar = new JButton("Iniciar Sesión");
        btnIniciar.setBackground(new Color(70, 130, 180));
        btnIniciar.setForeground(Color.WHITE);
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 16));
        btnIniciar.addActionListener(new LoginActionListener());
        btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(btnIniciar);

        setVisible(true);
    }

    private JPanel createInputPanel(String labelText, JTextField textField) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        JLabel label = new JLabel(labelText);
        label.setFont(new Font("Arial", Font.PLAIN, 16));

        textField.setMaximumSize(new Dimension(200, 30)); // Alineación de tamaño para los campos de entrada

        panel.add(label);
        panel.add(textField);

        return panel;
    }

    // Action Listener para el botón de inicio de sesión
    class LoginActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String usuario = txtUsuario.getText();
            String contrasena = new String(txtContrasena.getPassword());

            // Simulación de roles y validación
            if ("admin".equals(usuario) && "1234".equals(contrasena)) {
                dispose();
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
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un menú basado en el tipo de usuario
        JMenuBar menuBar = new JMenuBar();

        JMenu menuGestion = new JMenu("Gestión");
        JMenu menuOperaciones = new JMenu("Operaciones");

        if ("Administrador".equals(tipoUsuario)) {
            menuGestion.add(createMenuItem("Gestión de Usuarios", e -> new GestionUsuariosForm()));
            menuGestion.add(createMenuItem("Configurar Mora Diaria", e -> new ConfigurarMoraForm()));
            menuGestion.add(createMenuItem("Gestión de Ejemplares", e -> new GestionEjemplaresForm()));
            menuBar.add(menuGestion);
        } else if ("Profesor".equals(tipoUsuario)) {
            menuGestion.add(createMenuItem("Gestión de Ejemplares", e -> new GestionEjemplaresForm()));
            menuOperaciones.add(createMenuItem("Registrar Préstamos", e -> new GestionPrestamosForm()));
            menuOperaciones.add(createMenuItem("Registrar Devoluciones", e -> new GestionDevolucionesForm()));
            menuBar.add(menuGestion);
            menuBar.add(menuOperaciones);
        } else if ("Alumno".equals(tipoUsuario)) {
            menuOperaciones.add(createMenuItem("Consultar Ejemplares", e -> new ConsultaEjemplaresForm()));
            menuBar.add(menuOperaciones);
        }

        setJMenuBar(menuBar);

        JLabel lblBienvenida = new JLabel("Bienvenido, " + tipoUsuario, SwingConstants.CENTER);
        lblBienvenida.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblBienvenida, BorderLayout.CENTER);

        // Botón para regresar al menú principal
        JButton btnRegresar = new JButton("Regresar al Menú Principal");
        btnRegresar.addActionListener(e -> regresarAlMenuPrincipal());
        add(btnRegresar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private JMenuItem createMenuItem(String text, ActionListener action) {
        JMenuItem menuItem = new JMenuItem(text);
        menuItem.addActionListener(action);
        return menuItem;
    }

    private void regresarAlMenuPrincipal() {
        dispose(); // Cierra la ventana actual
        SwingUtilities.invokeLater(() -> new MainMenu("Administrador")); // Vuelve a abrir el menú principal con un tipo de usuario por defecto
    }
}
