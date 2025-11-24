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
public class TecnicoView extends JFrame {

    public JLabel lblNombre;
    public JButton btnRefrescar;
    public JButton btnAsignar;
    public JTable tablaTiq;

    public TecnicoView() {
        setTitle("Técnico - Tiquetes abiertos");
        setSize(500, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblNombre = new JLabel("Técnico");
        btnRefrescar = new JButton("Refrescar");
        btnAsignar = new JButton("Asignar seleccionado");

        tablaTiq = new JTable(new javax.swing.table.DefaultTableModel(
                new Object[][]{}, new String[]{"ID", "Título", "Estado"}
        ));

        JPanel arriba = new JPanel(new BorderLayout());
        arriba.add(lblNombre, BorderLayout.WEST);

        JPanel botones = new JPanel();
        botones.add(btnRefrescar);
        botones.add(btnAsignar);
        arriba.add(botones, BorderLayout.EAST);

        add(arriba, BorderLayout.NORTH);
        add(new JScrollPane(tablaTiq), BorderLayout.CENTER);
    }
}
