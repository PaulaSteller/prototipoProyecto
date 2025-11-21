/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipoproyecto;

/**
 *
 * @author paulasteller
 */
public class Tecnico {
    private String idTecnico;
    private String nombre;
    private String apellido;
    private String especialidad;

    public Tecnico(String idTecnico, String nombre, String apellido, String especialidad) {
        // En el constructor se llaman a los setters para asegurar la validación inicial
        this.setIdTecnico(idTecnico);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEspecialidad(especialidad);
    }

    public String getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(String idTecnico) {
        // 1. RESTRICCIÓN: El ID del técnico debe iniciar con T.
        // 2. RESTRICCIÓN: No se permiten campos vacíos.
        if (idTecnico == null || idTecnico.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del técnico no puede estar vacío.");
        }
        if (!idTecnico.trim().toUpperCase().startsWith("T")) {
            throw new IllegalArgumentException("ID de Técnico inválido. Debe iniciar con 'T'.");
        }
        this.idTecnico = idTecnico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
         // 1. RESTRICCIÓN: No se permiten campos vacíos.
        if (nombre == null || nombre.trim().isEmpty()) {
             throw new IllegalArgumentException("El Nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
         // 1. RESTRICCIÓN: No se permiten campos vacíos.
        if (apellido == null || apellido.trim().isEmpty()) {
             throw new IllegalArgumentException("El Apellido no puede estar vacío.");
        }
        this.apellido = apellido;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
         // 1. RESTRICCIÓN: No se permiten campos vacíos.
        if (especialidad == null || especialidad.trim().isEmpty()) {
             throw new IllegalArgumentException("La Especialidad no puede estar vacía.");
        }
        this.especialidad = especialidad;
    }
    
    
}