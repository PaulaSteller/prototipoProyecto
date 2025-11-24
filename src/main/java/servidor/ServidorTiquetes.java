/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author kevin
 */
public class ServidorTiquetes {
    
    public static final int PUERTO = 5000;
    private List<ManejadorCliente> clientes = new ArrayList<>();

    public static void main(String[] args) { new ServidorTiquetes().iniciar(); }

    public synchronized void registrarCliente(ManejadorCliente mc) { clientes.add(mc); }
    public synchronized void removerCliente(ManejadorCliente mc) { clientes.remove(mc); }

    public synchronized void enviarATodos(String mensaje) {
        for (ManejadorCliente mc : clientes) mc.enviar(mensaje);
    }

    private void iniciar() {
        try (ServerSocket server = new ServerSocket(PUERTO)) {
            System.out.println("Servidor en puerto " + PUERTO);
            while (true) {
                Socket socket = server.accept();
                ManejadorCliente mc = new ManejadorCliente(socket, this);
                registrarCliente(mc);
                mc.start();
            }
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }
}
