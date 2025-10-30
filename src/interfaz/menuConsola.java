package interfaz;

import logica.Gimnasio;
import logica.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    private Gimnasio gimnasio = new Gimnasio();

    public VentanaPrincipal() {
        setTitle("Sistema de Gimnasio GYM");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de botones
        JPanel panelBotones = new JPanel();
        JButton btnAgregarUsuario = new JButton("Agregar Usuario");
        JButton btnAgregarEntrenamiento = new JButton("Agregar Entrenamiento");
        JButton btnMostrarReporte = new JButton("Mostrar Reporte");

        panelBotones.add(btnAgregarUsuario);
        panelBotones.add(btnAgregarEntrenamiento);
        panelBotones.add(btnMostrarReporte);
        add(panelBotones, BorderLayout.NORTH);

        // Área de texto para mostrar resultados
        JTextArea areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);
        add(scrollPane, BorderLayout.CENTER);

        // Acciones de botones
        btnAgregarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog("Nombre:");
                int edad = Integer.parseInt(JOptionPane.showInputDialog("Edad:"));
                String membresia = JOptionPane.showInputDialog("Membresía:");
                gimnasio.agregarUsuario(nombre, edad, membresia);
                JOptionPane.showMessageDialog(null, "Usuario agregado.");
            }
        });

        btnAgregarEntrenamiento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gimnasio.obtenerUsuarios().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Agrega un usuario primero.");
                    return;
                }
                String tipo = JOptionPane.showInputDialog("Tipo de entrenamiento:");
                int duracion = Integer.parseInt(JOptionPane.showInputDialog("Duración (min):"));
                Usuario usuario = gimnasio.obtenerUsuarios().get(0);  // Simplificado: toma el primer usuario
                gimnasio.agregarEntrenamiento(tipo, duracion, usuario);
                JOptionPane.showMessageDialog(null, "Entrenamiento agregado.");
            }
        });

        btnMostrarReporte.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                areaTexto.setText(gimnasio.generarReporte());
            }
        });

        setVisible(true);
    }
}
