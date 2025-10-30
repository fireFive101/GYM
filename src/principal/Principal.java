package principal;

import modelo.Miembro;
import modelo.Instructor;
import modelo.Actividad;
import modelo.EquipoGym;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    // Listas para almacenar datos
    private static List<Miembro> miembros = new ArrayList<>();
    private static List<Instructor> instructores = new ArrayList<>();
    private static List<Actividad> actividades = new ArrayList<>();
    private static List<EquipoGym> equipos = new ArrayList<>();

    public static void main(String[] args) {
        // Inicializar datos de ejemplo
        inicializarDatos();

        // Crear y mostrar la GUI
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Sistema de Gestión del Gimnasio");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 500);
            frame.setLayout(new BorderLayout());

            JTabbedPane tabbedPane = new JTabbedPane();

            // Pestaña Miembros
            tabbedPane.addTab("Miembros", crearPanelMiembros());

            // Pestaña Instructores
            tabbedPane.addTab("Instructores", crearPanelInstructores());

            // Pestaña Equipos
            tabbedPane.addTab("Equipos", crearPanelEquipos());

            frame.add(tabbedPane, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }

    private static void inicializarDatos() {
        // Miembros de ejemplo (sin membresías asignadas inicialmente)
        miembros.add(new Miembro("Carlos Andrade", "M001", "555-1234", "carlos@example.com", "2023-10-14"));
        miembros.add(new Miembro("Ana García", "M002", "555-9876", "ana@example.com", "2023-05-10"));

        // Instructores de ejemplo
        instructores.add(new Instructor("Laura Pérez", "I005", "555-5678", "laura@gym.com", "Yoga", 5));
        instructores.add(new Instructor("Juan López", "I006", "555-1111", "juan@gym.com", "Cardio", 3));

        // Actividades de ejemplo
        Actividad yoga = new Actividad("Yoga Matinal", "08:00 - 09:00", 2);
        yoga.setInstructorAsignado(instructores.get(0));
        actividades.add(yoga);

        // Equipos de ejemplo
        equipos.add(new EquipoGym("Caminadora Pro", "Cardio", true));
        equipos.add(new EquipoGym("Pesas Libres", "Fuerza", false));
    }

    // Panel para Miembros
    private static JPanel crearPanelMiembros() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel superior: Verificar estatus
        JPanel panelVerificar = new JPanel(new FlowLayout());
        panelVerificar.add(new JLabel("ID del Miembro:"));
        JTextField txtIdMiembro = new JTextField(10);
        panelVerificar.add(txtIdMiembro);
        JButton btnVerificar = new JButton("Verificar Estatus");
        panelVerificar.add(btnVerificar);
        JTextArea txtResultado = new JTextArea(5, 40);
        txtResultado.setEditable(false);
        JScrollPane scrollResultado = new JScrollPane(txtResultado);
        panelVerificar.add(scrollResultado);

        btnVerificar.addActionListener(e -> {
            String id = txtIdMiembro.getText().trim();
            if (id.isEmpty()) {
                txtResultado.setText("Error: Ingrese un ID válido.");
                return;
            }
            Miembro miembro = miembros.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
            if (miembro == null) {
                txtResultado.setText("Miembro no encontrado.");
            } else {
                // Verificar estatus basado en membresía (si existe y está activa)
                String estatus = (miembro.verMembresia() != null) ? "Activa" : "Sin Membresía Activa";
                String infoMembresia = (miembro.verMembresia() != null) ? 
                    "Membresía: " + miembro.verMembresia().getTipo() : "Sin Membresía";
                txtResultado.setText("Nombre: " + miembro.getNombre() + "\nID: " + miembro.getId() +
                        "\nTeléfono: " + miembro.getTelefono() + "\nEmail: " + miembro.getEmail() +
                        "\nFecha Registro: " + miembro.getFechaRegistro() + "\nEstatus: " + estatus +
                        "\n" + infoMembresia);
            }
        });

        // Panel inferior: Agregar miembro
        JPanel panelAgregar = new JPanel(new GridLayout(6, 2));
        panelAgregar.add(new JLabel("Nombre:"));
        JTextField txtNombre = new JTextField();
        panelAgregar.add(txtNombre);
        panelAgregar.add(new JLabel("ID:"));
        JTextField txtIdNuevo = new JTextField();
        panelAgregar.add(txtIdNuevo);
        panelAgregar.add(new JLabel("Teléfono:"));
        JTextField txtTelefono = new JTextField();
        panelAgregar.add(txtTelefono);
        panelAgregar.add(new JLabel("Email:"));
        JTextField txtEmail = new JTextField();
        panelAgregar.add(txtEmail);
        panelAgregar.add(new JLabel("Fecha Registro (yyyy-MM-dd):"));
        JTextField txtFechaReg = new JTextField();
        panelAgregar.add(txtFechaReg);
        JButton btnAgregarMiembro = new JButton("Agregar Miembro");
        panelAgregar.add(btnAgregarMiembro);
        JTextArea txtMensajeAgregar = new JTextArea(2, 40);
        txtMensajeAgregar.setEditable(false);
        panelAgregar.add(new JScrollPane(txtMensajeAgregar));

        btnAgregarMiembro.addActionListener(e -> {
            String nombre = txtNombre.getText().trim();
            String id = txtIdNuevo.getText().trim();
            String telefono = txtTelefono.getText().trim();
            String email = txtEmail.getText().trim();
            String fechaReg = txtFechaReg.getText().trim();
            if (nombre.isEmpty() || id.isEmpty() || telefono.isEmpty() || email.isEmpty() || fechaReg.isEmpty()) {
                txtMensajeAgregar.setText("Error: Todos los campos son obligatorios.");
                return;
            }
            if (miembros.stream().anyMatch(m -> m.getId().equals(id))) {
                txtMensajeAgregar.setText("Error: ID ya existe.");
                return;
            }
            miembros.add(new Miembro(nombre, id, telefono, email, fechaReg));
            txtMensajeAgregar.setText("Miembro agregado exitosamente.");
            // Limpiar campos
            txtNombre.setText("");
            txtIdNuevo.setText("");
            txtTelefono.setText("");
            txtEmail.setText("");
            txtFechaReg.setText("");
        });

        panel.add(panelVerificar, BorderLayout.NORTH);
        panel.add(panelAgregar, BorderLayout.CENTER);
        return panel;
    }

    // Panel para Instructores
    private static JPanel crearPanelInstructores() {
        JPanel panel = new JPanel(new BorderLayout());

        // Lista de instructores
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        actualizarListaInstructores(modeloLista);
        JList<String> listaInstructores = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaInstructores);
        panel.add(scrollLista, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnAgregarInstructor = new JButton("Agregar Instructor");
        JButton btnQuitarInstructor = new JButton("Quitar Instructor");
        panelBotones.add(btnAgregarInstructor);
        panelBotones.add(btnQuitarInstructor);
        panel.add(panelBotones, BorderLayout.SOUTH);

        // Acción para agregar
        btnAgregarInstructor.addActionListener(e -> {
            JTextField txtNombre = new JTextField();
            JTextField txtId = new JTextField();
            JTextField txtTelefono = new JTextField();
            JTextField txtEmail = new JTextField();
            JTextField txtEspecialidad = new JTextField();
            JTextField txtExperiencia = new JTextField();
            Object[] message = {
                "Nombre:", txtNombre,
                "ID:", txtId,
                "Teléfono:", txtTelefono,
                "Email:", txtEmail,
                "Especialidad (Área):", txtEspecialidad,
                "Años de Experiencia:", txtExperiencia
            };
            int option = JOptionPane.showConfirmDialog(null, message, "Agregar Instructor", JOptionPane.OK_CANCEL_OPTION);
            if (option == JOptionPane.OK_OPTION) {
                String nombre = txtNombre.getText().trim();
                String id = txtId.getText().trim();
                String telefono = txtTelefono.getText().trim();
                String email = txtEmail.getText().trim();
                String especialidad = txtEspecialidad.getText().trim();
                int experiencia = Integer.parseInt(txtExperiencia.getText().trim());
                if (nombre.isEmpty() || id.isEmpty() || especialidad.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Error: Campos obligatorios faltan.");
                    return;
                }
                if (instructores.stream().anyMatch(i -> i.getId().equals(id))) {
                    JOptionPane.showMessageDialog(null, "Error: ID ya existe.");
                    return;
                }
                instructores.add(new Instructor(nombre, id, telefono, email, especialidad, experiencia));
                actualizarListaInstructores(modeloLista);
            }
        });

        // Acción para quitar
        btnQuitarInstructor.addActionListener(e -> {
            int selectedIndex = listaInstructores.getSelectedIndex();
            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un instructor para quitar.");
                return;
            }
            instructores.remove(selectedIndex);
            actualizarListaInstructores(modeloLista);
        });

        return panel;
    }

    private static void actualizarListaInstructores(DefaultListModel<String> modelo) {
        modelo.clear();
        for (Instructor i : instructores) {
            modelo.addElement(i.getNombre() + " (ID: " + i.getId() + ", Área: " + i.getEspecialidad() + ", Exp: " + i.getExperienciaAnos() + " años)");
        }
    }

    // Panel para Equipos
    private static JPanel crearPanelEquipos() {
        JPanel panel = new JPanel(new BorderLayout());

        // Lista de equipos
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        actualizarListaEquipos(modeloLista);
        JList<String> listaEquipos = new JList<>(modeloLista);
        JScrollPane scrollLista = new JScrollPane(listaEquipos);
        panel.add(scrollLista, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnMarcarDisponible = new JButton("Marcar Disponible");
        JButton btnMarcarEnUso = new JButton("Marcar En Uso");
        panelBotones.add(btnMarcarDisponible);
        panelBotones.add(btnMarcarEnUso);
        panel.add(panelBotones, BorderLayout.SOUTH);

        btnMarcarDisponible.addActionListener(e -> {
            int selectedIndex = listaEquipos.getSelectedIndex();
            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un equipo.");
                return;
            }
            equipos.get(selectedIndex).marcarDisponible();
            actualizarListaEquipos(modeloLista);
        });

        btnMarcarEnUso.addActionListener(e -> {
            int selectedIndex = listaEquipos.getSelectedIndex();
            if (selectedIndex == -1) {
                JOptionPane.showMessageDialog(null, "Seleccione un equipo.");
                return;
            }
            equipos.get(selectedIndex).marcarEnUso();
            actualizarListaEquipos(modeloLista);
        });

        return panel;
    }

    private static void actualizarListaEquipos(DefaultListModel<String> modelo) {
        modelo.clear();
        for (EquipoGym eq : equipos) {
            String estatus = eq.isDisponible() ? "Disponible" : "En Uso";
            modelo.addElement(eq.getNombre() + " (Tipo: " + eq.getTipo() + ", Estatus: " + estatus + ")");
        }
    }
}
