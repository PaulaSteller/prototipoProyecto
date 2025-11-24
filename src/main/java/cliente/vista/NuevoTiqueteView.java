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
public class NuevoTiqueteView extends JFrame {

    public JTextField txtTitulo;
    public JTextArea txtDescripcion;
    public JComboBox<String> cbPrioridad;
    public JComboBox<String> cbCategoria;
    public JButton btnCrear;

    public NuevoTiqueteView() {
        setTitle("Crear Tiquete");
        setSize(360, 640);
        setLocationRelativeTo(null);
        setResizable(false);

        Color verdeHeader = new Color(76, 141, 71);
        Color grisFondo = new Color(235, 235, 235);
        Color grisCampo = new Color(245, 245, 245);
        Color azulBoton = new Color(41, 98, 255);

        JPanel fondo = new JPanel(new BorderLayout());
        fondo.setBackground(grisFondo);

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(verdeHeader);
        header.setPreferredSize(new Dimension(360, 60));
        JLabel lblTituloHeader = new JLabel("SISTEMA DE GESTIÓN DE TIQUETES");
        lblTituloHeader.setForeground(Color.WHITE);
        lblTituloHeader.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
        header.add(lblTituloHeader, BorderLayout.CENTER);

        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel lblCrear = new JLabel("Crear Tiquete.");
        lblCrear.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblCrear.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblCrear.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        txtTitulo = new JTextField();
        txtTitulo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtTitulo.setBackground(grisCampo);
        txtTitulo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        txtTitulo.setToolTipText("Título");

        txtDescripcion = new JTextArea(4, 20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setWrapStyleWord(true);
        txtDescripcion.setBackground(grisCampo);
        txtDescripcion.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        cbPrioridad = new JComboBox<>(new String[]{"BAJA", "MEDIA", "ALTA"});
        cbPrioridad.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        cbCategoria = new JComboBox<>(new String[]{"SOFTWARE", "HARDWARE", "REDES", "OTRO"});
        cbCategoria.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        btnCrear = new JButton("Enviar");
        btnCrear.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCrear.setPreferredSize(new Dimension(260, 40));
        btnCrear.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        btnCrear.setBackground(azulBoton);
        btnCrear.setForeground(Color.WHITE);
        btnCrear.setFocusPainted(false);
        btnCrear.setFont(new Font("SansSerif", Font.BOLD, 14));

        card.add(lblCrear);
        card.add(txtTitulo);
        card.add(Box.createVerticalStrut(10));
        card.add(new JLabel("Descripción:"));
        card.add(new JScrollPane(txtDescripcion));
        card.add(Box.createVerticalStrut(10));
        card.add(new JLabel("Prioridad:"));
        card.add(cbPrioridad);
        card.add(Box.createVerticalStrut(10));
        card.add(new JLabel("Categoría:"));
        card.add(cbCategoria);
        card.add(Box.createVerticalStrut(20));
        card.add(btnCrear);

        fondo.add(header, BorderLayout.NORTH);
        fondo.add(card, BorderLayout.CENTER);
        setContentPane(fondo);
    }
}