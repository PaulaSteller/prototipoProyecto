/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.controlador;

import cliente.vista.*;
import util.CifradoUtil;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.net.Socket;

/**
 *
 * @author kevin
 */
public class ClienteApp {
    
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    private LoginView loginView;
    private EmpleadoView empView;
    private TecnicoView tecView;
    private NuevoTiqueteView nuevoTiqView;
    private ChatView chatView;

    private int idUsuario;
    private String nombreUsuario;
    private String rolUsuario;
    private int chatTiqueteActual = -1;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ClienteApp::new);
    }

    public ClienteApp() {
        conectar();
        iniciarLogin();
        iniciarHiloLectura();
    }

    private void conectar() {
        try {
            socket = new Socket("localhost", 5000);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar al servidor: " + e.getMessage());
            System.exit(0);
        }
    }

    private void iniciarLogin() {
        loginView = new LoginView();
        loginView.btnLogin.addActionListener(e -> hacerLogin());
        loginView.setVisible(true);
    }

    private void hacerLogin() {
        String correo = loginView.txtCorreo.getText();
        String pass = new String(loginView.txtPassword.getPassword());
        String passCifrada = CifradoUtil.cifrar(pass);
        out.println("LOGIN|" + correo + "|" + passCifrada);
    }

    private void iniciarHiloLectura() {
        Thread t = new Thread(() -> {
            try {
                String linea;
                while ((linea = in.readLine()) != null) {
                    procesarRespuesta(linea);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Conexión cerrada con el servidor.");
                System.exit(0);
            }
        });
        t.start();
    }
    
private void procesarRespuesta(String linea) {
        String[] partes = linea.split("\\|");
        String cmd = partes[0];

        switch (cmd) {
            case "LOGIN_OK":
                rolUsuario = partes[1];
                idUsuario = Integer.parseInt(partes[2]);
                nombreUsuario = partes[3];
                SwingUtilities.invokeLater(this::abrirVistaRol);
                break;

            case "LOGIN_ERROR":
                JOptionPane.showMessageDialog(loginView, "Credenciales inválidas");
                break;

            case "NUEVO_TIQ_OK":
                JOptionPane.showMessageDialog(nuevoTiqView,
                        "Tiquete creado con ID: " + partes[1]);
                nuevoTiqView.dispose();
                cargarTiquetesEmpleado();
                break;

            case "TQ":
                agregarTiqueteATabla(partes);
                break;

            case "END_TQ":
                break;

            case "ASIGNAR_OK":
                JOptionPane.showMessageDialog(tecView, "Tiquete asignado");
                cargarTiquetesAbiertos();
                break;

            case "CHAT_MSG":
                int idTq = Integer.parseInt(partes[1]);
                String nom = partes[2];
                String msg = partes[3];
                mostrarMensajeChat(idTq, nom + ": " + msg);
                break;
        }
    }

    private void abrirVistaRol() {
        loginView.dispose();

        if ("EMPLEADO".equalsIgnoreCase(rolUsuario)) {
            empView = new EmpleadoView();
            empView.lblNombre.setText("Hola, " + nombreUsuario);

            empView.btnNuevoTiq.addActionListener(e -> abrirNuevoTiquete());
            empView.btnRefrescar.addActionListener(e -> cargarTiquetesEmpleado());
            empView.tablaTiq.getSelectionModel()
                    .addListSelectionListener(e -> {
                        if (!e.getValueIsAdjusting())
                            abrirChatDesdeTablaEmpleado();
                    });

            empView.setVisible(true);
            cargarTiquetesEmpleado();

        } else {
            tecView = new TecnicoView();
            tecView.lblNombre.setText("Hola, " + nombreUsuario);

            tecView.btnRefrescar.addActionListener(e -> cargarTiquetesAbiertos());
            tecView.btnAsignar.addActionListener(e -> asignarSeleccionado());
            tecView.tablaTiq.getSelectionModel()
                    .addListSelectionListener(e -> {
                        if (!e.getValueIsAdjusting())
                            abrirChatDesdeTablaTecnico();
                    });

            tecView.setVisible(true);
            cargarTiquetesAbiertos();
        }
    }
    
    private void abrirNuevoTiquete() {
        nuevoTiqView = new NuevoTiqueteView();
        nuevoTiqView.btnCrear.addActionListener(e -> crearTiquete());
        nuevoTiqView.setVisible(true);
    }

    private void crearTiquete() {
        String titulo = nuevoTiqView.txtTitulo.getText();
        String desc = nuevoTiqView.txtDescripcion.getText();
        String pr = (String) nuevoTiqView.cbPrioridad.getSelectedItem();
        String cat = (String) nuevoTiqView.cbCategoria.getSelectedItem();

        out.println("NUEVO_TIQ|" + idUsuario + "|" + titulo + "|" + desc + "|" + pr + "|" + cat);
    }

    private void cargarTiquetesEmpleado() {
        limpiarTabla(empView.tablaTiq);
        out.println("LISTA_TIQ_EMP|" + idUsuario);
    }

    private void cargarTiquetesAbiertos() {
        limpiarTabla(tecView.tablaTiq);
        out.println("LISTA_TIQ_ABIERTOS");
    }

    private void limpiarTabla(JTable tabla) {
        DefaultTableModel m = (DefaultTableModel) tabla.getModel();
        m.setRowCount(0);
    }

    private void agregarTiqueteATabla(String[] partes) {
        int idTq = Integer.parseInt(partes[1]);
        String tit = partes[2];
        String est = partes[3];

        if ("EMPLEADO".equals(rolUsuario)) {
            ((DefaultTableModel) empView.tablaTiq.getModel()).addRow(new Object[]{idTq, tit, est});
        } else {
            ((DefaultTableModel) tecView.tablaTiq.getModel()).addRow(new Object[]{idTq, tit, est});
        }
    }

    private void asignarSeleccionado() {
        int fila = tecView.tablaTiq.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(tecView, "Seleccione un tiquete");
            return;
        }
        int idTq = (int) tecView.tablaTiq.getValueAt(fila, 0);
        out.println("ASIGNAR_TIQ|" + idTq + "|" + idUsuario);
    }

    private void abrirChatDesdeTablaEmpleado() {
        int fila = empView.tablaTiq.getSelectedRow();
        if (fila == -1) return;
        int idTq = (int) empView.tablaTiq.getValueAt(fila, 0);
        abrirChat(idTq);
    }

    private void abrirChatDesdeTablaTecnico() {
        int fila = tecView.tablaTiq.getSelectedRow();
        if (fila == -1) return;
        int idTq = (int) tecView.tablaTiq.getValueAt(fila, 0);
        abrirChat(idTq);
    }

    private void abrirChat(int idTq) {
        chatTiqueteActual = idTq;

        if (chatView != null) chatView.dispose();

        chatView = new ChatView();
        chatView.lblTiquete.setText("Chat Tiquete #" + idTq);
        chatView.btnEnviar.addActionListener(e -> enviarMensajeChat(idTq));
        chatView.setVisible(true);
    }

    private void enviarMensajeChat(int idTq) {
        String texto = chatView.txtMensaje.getText();
        if (texto.trim().isEmpty()) return;

        chatView.txtMensaje.setText("");
        out.println("CHAT_ENVIAR|" + idTq + "|" + idUsuario + "|" + texto);
    }

    private void mostrarMensajeChat(int idTq, String texto) {
        if (chatView != null && idTq == chatTiqueteActual) {
            chatView.txtAreaChat.append(texto + "\n");
        }
    }
}

