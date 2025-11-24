/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.vista;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author kevin
 */
public class EmpleadoView extends JFrame {
    
    public JLabel lblNombre;
    public JButton btnNuevoTiq;
    public JButton btnRefrescar;
    public JTable tablaTiq;

    public EmpleadoView() {
        setTitle("Sistema de Gestión de Tiquetes - Empleado");
        setSize(360, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        Color verdeHeader = new Color(76, 141, 71);
        Color grisFondo = new Color(235, 235, 235);

        JPanel fondo = new JPanel(new BorderLayout());
        fondo.setBackground(grisFondo);

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(verdeHeader);
        header.setPreferredSize(new Dimension(360, 60));
        JLabel lblTituloHeader = new JLabel("SISTEMA DE GESTIÓN DE TIQUETES");
        lblTituloHeader.setForeground(Color.WHITE);
        lblTituloHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
        header.add(lblTituloHeader, BorderLayout.CENTER);

        // Card central
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        card.setLayout(new BorderLayout(0, 15));

        lblNombre = new JLabel("Hola, Empleado.");
        lblNombre.setFont(new Font("SansSerif", Font.BOLD, 20));

        btnNuevoTiq = new JButton("Crear nuevo tiquete");
        btnNuevoTiq.setBackground(verdeHeader);
        btnNuevoTiq.setForeground(Color.WHITE);
        btnNuevoTiq.setFocusPainted(false);
        btnNuevoTiq.setFont(new Font("SansSerif", Font.BOLD, 13));

        JPanel arriba = new JPanel(new BorderLayout());
        arriba.setOpaque(false);
        arriba.add(lblNombre, BorderLayout.WEST);
        arriba.add(btnNuevoTiq, BorderLayout.EAST);

        // Tabla
        tablaTiq = new JTable(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "TÍTULO", "ESTADO"}
        ));
        tablaTiq.setRowHeight(24);
        JScrollPane scroll = new JScrollPane(tablaTiq);

        // Botón refrescar debajo de la tabla
        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.setFocusPainted(false);

        card.add(arriba, BorderLayout.NORTH);
        card.add(scroll, BorderLayout.CENTER);
        card.add(btnRefrescar, BorderLayout.SOUTH);

        fondo.add(header, BorderLayout.NORTH);
        fondo.add(card, BorderLayout.CENTER);

        setContentPane(fondo);
    }
}
