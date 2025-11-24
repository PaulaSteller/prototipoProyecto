/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import util.CifradoUtil;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author kevin
 */
public class RepositorioDatos {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Tiquete> tiquetes = new ArrayList<>();
    private static List<Mensaje> mensajes = new ArrayList<>();

    private static int nextTiqueteId = 1;
    private static int nextMensajeId = 1;

    static {
        usuarios.add(new Empleado(1, "Empleado Demo", "empleado@demo.com",
                CifradoUtil.cifrar("1234")));
        usuarios.add(new Tecnico(2, "Técnico Demo", "tecnico@demo.com",
                CifradoUtil.cifrar("1234")));
    }

    public static Usuario login(String correo, String passCifrada) {
        for (Usuario u : usuarios)
            if (u.getCorreo().equals(correo) && u.getPassword().equals(passCifrada)) return u;
        return null;
    }

    public static int crearTiquete(Tiquete t) {
        t.setId(nextTiqueteId++);
        tiquetes.add(t);
        return t.getId();
    }

    public static List<Tiquete> listarPorEmpleado(int idEmp) {
        List<Tiquete> res = new ArrayList<>();
        for (Tiquete t : tiquetes) if (t.getIdEmpleado() == idEmp) res.add(t);
        return res;
    }

    public static List<Tiquete> listarAbiertos() {
        List<Tiquete> res = new ArrayList<>();
        for (Tiquete t : tiquetes)
            if (t.getEstado() == Tiquete.Estado.ABIERTO) res.add(t);
        return res;
    }

    public static void asignarTiquete(int idTiq, int idTec) {
        for (Tiquete t : tiquetes)
            if (t.getId() == idTiq) {
                t.setIdTecnico(idTec);
                t.setEstado(Tiquete.Estado.EN_PROGRESO);
            }
    }

    public static void guardarMensaje(int idTiquete, int idUsuario, String contenido) {
        mensajes.add(new Mensaje(nextMensajeId++, idTiquete, idUsuario, contenido,
                LocalDateTime.now()));
    }
}