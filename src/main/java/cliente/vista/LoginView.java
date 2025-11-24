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
public class LoginView extends JFrame {
    
    public JTextField txtCorreo;
    public JPasswordField txtPassword;
    public JButton btnLogin;

    public LoginView() {
        setTitle("Sistema de Gestión de Tiquetes");
        setSize(360, 640);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // Colores de la app
        Color verdeHeader = new Color(76, 141, 71);
        Color grisFondo = new Color(235, 235, 235);
        Color grisCampo = new Color(245, 245, 245);

        // Fondo general
        JPanel fondo = new JPanel(new BorderLayout());
        fondo.setBackground(grisFondo);

        // Header verde
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(verdeHeader);
        header.setPreferredSize(new Dimension(360, 60));

        JLabel lblTituloHeader = new JLabel("SISTEMA DE GESTIÓN DE TIQUETES");
        lblTituloHeader.setForeground(Color.WHITE);
        lblTituloHeader.setFont(new Font("SansSerif", Font.BOLD, 14));
        lblTituloHeader.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(lblTituloHeader, BorderLayout.CENTER);

        // Tarjeta blanca central (simula el celular)
        JPanel card = new JPanel();
        card.setBackground(Color.WHITE);
        card.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

        JLabel lblBienvenido = new JLabel("Bienvenido.");
        lblBienvenido.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblBienvenido.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblBienvenido.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        txtCorreo = new JTextField();
        txtCorreo.setPreferredSize(new Dimension(260, 40));
        txtCorreo.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtCorreo.setBackground(grisCampo);
        txtCorreo.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        txtCorreo.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtCorreo.setToolTipText("Correo electrónico");

        txtPassword = new JPasswordField();
        txtPassword.setPreferredSize(new Dimension(260, 40));
        txtPassword.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        txtPassword.setBackground(grisCampo);
        txtPassword.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        txtPassword.setFont(new Font("SansSerif", Font.PLAIN, 13));
        txtPassword.setToolTipText("Contraseña");

        btnLogin = new JButton("Iniciar sesión");
        btnLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnLogin.setPreferredSize(new Dimension(260, 45));
        btnLogin.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        btnLogin.setBackground(verdeHeader);
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFocusPainted(false);
        btnLogin.setFont(new Font("SansSerif", Font.BOLD, 15));

        card.add(lblBienvenido);
        card.add(txtCorreo);
        card.add(Box.createVerticalStrut(10));
        card.add(txtPassword);
        card.add(Box.createVerticalStrut(25));
        card.add(btnLogin);

        fondo.add(header, BorderLayout.NORTH);
        fondo.add(card, BorderLayout.CENTER);

        setContentPane(fondo);
    }
}