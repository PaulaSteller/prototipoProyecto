/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import modelo.*;
import java.io.*;
import java.net.Socket;

/**
 *
 * @author kevin
 */
public class ManejadorCliente extends Thread {
    
    private Socket socket;
    private ServidorTiquetes servidor;
    private BufferedReader in;
    private PrintWriter out;
    private Usuario usuario;

    public ManejadorCliente(Socket socket, ServidorTiquetes servidor) {
        this.socket = socket;
        this.servidor = servidor;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (Exception ignored) {}
    }

    public void enviar(String msg) { out.println(msg); }

    @Override
    public void run() {
        try {
            String linea;
            while ((linea = in.readLine()) != null) procesar(linea);
        } catch (Exception ignored) {}
    }

    private void procesar(String linea) {
        try {
            String[] p = linea.split("\\|");
            switch (p[0]) {
                case "LOGIN": login(p); break;
                case "NUEVO_TIQ": nuevoTiq(p); break;
                case "LISTA_TIQ_EMP": listarEmp(p); break;
                case "LISTA_TIQ_ABIERTOS": listarAbiertos(); break;
                case "ASIGNAR_TIQ": asignar(p); break;
                case "CHAT_ENVIAR": chat(p); break;
            }
        } catch (Exception e) { out.println("ERROR|" + e.getMessage()); }
    }

    private void login(String[] p) {
        usuario = RepositorioDatos.login(p[1], p[2]);
        if (usuario != null)
            out.println("LOGIN_OK|" + usuario.getTipo() + "|" + usuario.getId() + "|" + usuario.getNombre());
        else out.println("LOGIN_ERROR");
    }

    private void nuevoTiq(String[] p) {
        int idEmp = Integer.parseInt(p[1]);
        String tit = p[2], desc = p[3];
        Tiquete.Prioridad pr = Tiquete.Prioridad.valueOf(p[4]);
        Tiquete.Categoria cat = Tiquete.Categoria.valueOf(p[5]);

        Tiquete t = new Tiquete(0, tit, desc, pr, cat,
                Tiquete.Estado.ABIERTO, idEmp, null);
        int id = RepositorioDatos.crearTiquete(t);
        out.println("NUEVO_TIQ_OK|" + id);
    }

    private void listarEmp(String[] p) {
        int idEmp = Integer.parseInt(p[1]);
        for (Tiquete t : RepositorioDatos.listarPorEmpleado(idEmp))
            out.println("TQ|" + t.getId() + "|" + t.getTitulo() + "|" + t.getEstado());
        out.println("END_TQ");
    }

    private void listarAbiertos() {
        for (Tiquete t : RepositorioDatos.listarAbiertos())
            out.println("TQ|" + t.getId() + "|" + t.getTitulo() + "|" + t.getEstado());
        out.println("END_TQ");
    }

    private void asignar(String[] p) {
        RepositorioDatos.asignarTiquete(
                Integer.parseInt(p[1]),
                Integer.parseInt(p[2])
        );
        out.println("ASIGNAR_OK");
    }

    private void chat(String[] p) {
        int idT = Integer.parseInt(p[1]);
        int idU = Integer.parseInt(p[2]);
        String msg = p[3];
        RepositorioDatos.guardarMensaje(idT, idU, msg);
        servidor.enviarATodos("CHAT_MSG|" + idT + "|" + usuario.getNombre() + "|" + msg);
    }
}
