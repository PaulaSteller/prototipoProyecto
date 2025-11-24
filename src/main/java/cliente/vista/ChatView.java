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
public class ChatView extends JFrame {

    public JLabel lblTiquete;
    public JTextArea txtAreaChat;
    public JTextField txtMensaje;
    public JButton btnEnviar;

    public ChatView() {
        setTitle("Chat Interno");
        setSize(360, 640);
        setLocationRelativeTo(null);
        setResizable(false);

        Color verdeHeader = new Color(76, 141, 71);
        Color grisFondo = new Color(235, 235, 235);

        JPanel fondo = new JPanel(new BorderLayout());
        fondo.setBackground(grisFondo);

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(verdeHeader);
        header.setPreferredSize(new Dimension(360, 60));

        lblTiquete = new JLabel("Chat Interno.");
        lblTiquete.setForeground(Color.WHITE);
        lblTiquete.setHorizontalAlignment(SwingConstants.CENTER);
        lblTiquete.setFont(new Font("SansSerif", Font.BOLD, 16));
        header.add(lblTiquete, BorderLayout.CENTER);

        // Card chat
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtAreaChat = new JTextArea();
        txtAreaChat.setEditable(false);
        txtAreaChat.setLineWrap(true);
        txtAreaChat.setWrapStyleWord(true);
        txtAreaChat.setFont(new Font("SansSerif", Font.PLAIN, 13));

        JScrollPane scroll = new JScrollPane(txtAreaChat);

        JPanel panelInput = new JPanel(new BorderLayout(5, 5));
        txtMensaje = new JTextField();
        btnEnviar = new JButton("Enviar");
        btnEnviar.setFocusPainted(false);

        panelInput.add(txtMensaje, BorderLayout.CENTER);
        panelInput.add(btnEnviar, BorderLayout.EAST);

        card.add(scroll, BorderLayout.CENTER);
        card.add(panelInput, BorderLayout.SOUTH);

        fondo.add(header, BorderLayout.NORTH);
        fondo.add(card, BorderLayout.CENTER);

        setContentPane(fondo);
    }
}