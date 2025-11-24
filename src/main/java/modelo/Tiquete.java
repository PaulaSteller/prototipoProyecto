/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author kevin
 */
public class Tiquete {
    
    public enum Prioridad { BAJA, MEDIA, ALTA }
    public enum Categoria { SOFTWARE, HARDWARE, REDES, OTRO }
    public enum Estado { ABIERTO, EN_PROGRESO, RESUELTO, CERRADO }

    private int id;
    private String titulo;
    private String descripcion;
    private Prioridad prioridad;
    private Categoria categoria;
    private Estado estado;
    private int idEmpleado;
    private Integer idTecnico; // puede ser null

    public Tiquete(int id, String titulo, String descripcion,
                   Prioridad prioridad, Categoria categoria,
                   Estado estado, int idEmpleado, Integer idTecnico) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.categoria = categoria;
        this.estado = estado;
        this.idEmpleado = idEmpleado;
        this.idTecnico = idTecnico;
    }

    // getters
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public Prioridad getPrioridad() { return prioridad; }
    public Categoria getCategoria() { return categoria; }
    public Estado getEstado() { return estado; }
    public int getIdEmpleado() { return idEmpleado; }
    public Integer getIdTecnico() { return idTecnico; }

    // setters usados en RepositorioDatos
    public void setId(int id) { this.id = id; }
    public void setEstado(Estado estado) { this.estado = estado; }
    public void setIdTecnico(Integer idTecnico) { this.idTecnico = idTecnico; }
}
