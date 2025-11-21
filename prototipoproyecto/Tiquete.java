/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipoproyecto;

import java.time.LocalDateTime;
import java.util.Arrays; // Necesario para usar Listas
import java.util.List;   // Necesario para usar Listas
import java.util.regex.Pattern; // Necesario para usar Regex

/**
 *
 * @author paulasteller
 */
public class Tiquete {
    private String idTiquete;
    private String titulo;
    private String descripcion;
    private String prioridad;
    private String estado;
    private LocalDateTime fechaCreacion;
    
    // Lista de prioridades válidas
    private static final List<String> PRIORIDADES_VALIDAS = Arrays.asList(
            "Baja", "Media", "Alta"
    );

    public Tiquete(String idTiquete, String titulo, String descripcion, String prioridad, String estado, LocalDateTime fechaCreacion) {
        // En el constructor se llaman a los setters para asegurar la validación inicial
        this.setIdTiquete(idTiquete);
        this.setTitulo(titulo);
        this.setDescripcion(descripcion);
        this.setPrioridad(prioridad);
        this.setEstado(estado);
        this.setFechaCreacion(fechaCreacion);
    }

    public String getIdTiquete() {
        return idTiquete;
    }

    public void setIdTiquete(String idTiquete) {
        // 1. RESTRICCIÓN: El ID del tiquete debe tener formato HT-XXX.
        // 2. RESTRICCIÓN: No se permiten campos vacíos.
        if (idTiquete == null || idTiquete.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del tiquete no puede estar vacío.");
        }
        if (!Pattern.matches("^HT-\\w{3}$", idTiquete.trim().toUpperCase())) {
            throw new IllegalArgumentException("ID de Tiquete inválido. Debe tener formato HT-XXX (Ej: HT-A01).");
        }
        this.idTiquete = idTiquete;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        // 1. RESTRICCIÓN: El título debe tener mínimo 10 caracteres.
        // 2. RESTRICCIÓN: No se permiten campos vacíos.
        if (titulo == null || titulo.trim().isEmpty()) {
             throw new IllegalArgumentException("El Título no puede estar vacío.");
        }
        if (titulo.trim().length() < 10) {
            throw new IllegalArgumentException("El Título debe tener un mínimo de 10 caracteres.");
        }
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        // 1. RESTRICCIÓN: No se permiten campos vacíos.
        if (descripcion == null || descripcion.trim().isEmpty()) {
             throw new IllegalArgumentException("La Descripción no puede estar vacía.");
        }
        this.descripcion = descripcion;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        // 1. RESTRICCIÓN: Prioridad solo puede ser Baja / Media / Alta.
        // 2. RESTRICCIÓN: No se permiten campos vacíos.
        if (prioridad == null || prioridad.trim().isEmpty()) {
             throw new IllegalArgumentException("La Prioridad no puede estar vacía.");
        }
        if (!PRIORIDADES_VALIDAS.contains(prioridad.trim())) {
            throw new IllegalArgumentException("Prioridad inválida. Debe ser Baja, Media o Alta.");
        }
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
         // 1. RESTRICCIÓN: No se permiten campos vacíos.
         if (estado == null || estado.trim().isEmpty()) {
             throw new IllegalArgumentException("El Estado no puede estar vacío.");
         }
        this.estado = estado;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    
}