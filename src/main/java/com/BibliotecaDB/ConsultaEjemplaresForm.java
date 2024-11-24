package com.BibliotecaDB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class ConsultaEjemplaresForm extends JFrame {
    private JTextField txtBuscar;
    private JButton btnBuscar, btnMostrarTodos, btnRegresar;
    private JTable tablaResultados;
    private DefaultTableModel modeloTabla;

    // Lista para simular una base de datos de ejemplares
    private List<Ejemplar> ejemplares;

    public ConsultaEjemplaresForm() {
        this(new ArrayList<>());
    }

    public ConsultaEjemplaresForm(List<Ejemplar> ejemplaresRegistrados) {
        setTitle("Consulta de Ejemplares");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicialización de la lista de ejemplares
        this.ejemplares = ejemplaresRegistrados != null ? ejemplaresRegistrados : new ArrayList<>();

        // Panel de búsqueda
        JPanel panelBusqueda = new JPanel(new FlowLayout());
        panelBusqueda.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelBusqueda.add(new JLabel("Buscar:"));
        txtBuscar = new JTextField(20);
        panelBusqueda.add(txtBuscar);

        btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new BuscarAction());
        panelBusqueda.add(btnBuscar);

        btnMostrarTodos = new JButton("Mostrar Todos");
        btnMostrarTodos.addActionListener(new MostrarTodosAction());
        panelBusqueda.add(btnMostrarTodos);

        // Botón Regresar
        btnRegresar = new JButton("Regresar al Menu Principal");
        btnRegresar.addActionListener(e -> {
            dispose(); // Cierra la ventana actual
            SwingUtilities.invokeLater(() -> new LoginScreen()); // Abre la pantalla de inicio de sesión
        });
        panelBusqueda.add(btnRegresar); // Añadido el botón de regresar

        add(panelBusqueda, BorderLayout.NORTH);

        // Tabla de resultados
        modeloTabla = new DefaultTableModel(new String[]{"Código", "Título", "Autor", "Ubicación", "Tipo"}, 0);
        tablaResultados = new JTable(modeloTabla);
        tablaResultados.setFillsViewportHeight(true);

        add(new JScrollPane(tablaResultados), BorderLayout.CENTER);

        // Cargar datos iniciales
        cargarTabla(ejemplares);

        setVisible(true);
    }

    // Método para cargar datos en la tabla
    private void cargarTabla(List<Ejemplar> ejemplares) {
        modeloTabla.setRowCount(0); // Limpiar tabla
        for (Ejemplar ejemplar : ejemplares) {
            modeloTabla.addRow(new Object[]{
                    ejemplar.getCodigo(),
                    ejemplar.getTitulo(),
                    ejemplar.getAutor(),
                    ejemplar.getUbicacion(),
                    ejemplar.getTipo()
            });
        }
    }

    // Acción para buscar ejemplares
    private class BuscarAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String criterio = txtBuscar.getText().trim().toLowerCase();
            if (criterio.isEmpty()) {
                JOptionPane.showMessageDialog(ConsultaEjemplaresForm.this, "Ingrese un criterio de búsqueda.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            List<Ejemplar> resultados = new ArrayList<>();
            for (Ejemplar ejemplar : ejemplares) {
                if (ejemplar.getCodigo().toLowerCase().contains(criterio) ||
                        ejemplar.getTitulo().toLowerCase().contains(criterio) ||
                        ejemplar.getAutor().toLowerCase().contains(criterio) ||
                        ejemplar.getUbicacion().toLowerCase().contains(criterio) ||
                        ejemplar.getTipo().toLowerCase().contains(criterio)) {
                    resultados.add(ejemplar);
                }
            }

            if (resultados.isEmpty()) {
                JOptionPane.showMessageDialog(ConsultaEjemplaresForm.this, "No se encontraron resultados.", "Sin Resultados", JOptionPane.INFORMATION_MESSAGE);
            }

            cargarTabla(resultados);
        }
    }

    // Acción para mostrar todos los ejemplares
    private class MostrarTodosAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            cargarTabla(ejemplares);
        }
    }

    // Acción para regresar al menú principal
    private class RegresarAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            SwingUtilities.invokeLater(() -> new LoginScreen());
        }
    }
}

// Clase auxiliar para representar un Ejemplar
class Ejemplar {
    private String codigo;
    private String titulo;
    private String autor;
    private String ubicacion;
    private String tipo;

    public Ejemplar(String codigo, String titulo, String autor, String ubicacion, String tipo) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.autor = autor;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
    }

    public String getCodigo() { return codigo; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getUbicacion() { return ubicacion; }
    public String getTipo() { return tipo; }
}