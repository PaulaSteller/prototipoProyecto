/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
import java.time.LocalDateTime;
/**
 *
 * @author kevin
 */
public class Mensaje {
    private int id;
    private int idTiquete;
    private int idUsuario;
    private String contenido;
    private LocalDateTime fecha;

    public Mensaje(int id, int idTiquete, int idUsuario,
                   String contenido, LocalDateTime fecha) {
        this.id = id;
        this.idTiquete = idTiquete;
        this.idUsuario = idUsuario;
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public int getId() { return id; }
    public int getIdTiquete() { return idTiquete; }
    public int getIdUsuario() { return idUsuario; }
    public String getContenido() { return contenido; }
    public LocalDateTime getFecha() { return fecha; }
}
