/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipoproyecto;

import java.time.LocalDateTime;

/**
 *
 * @author paulasteller
 */
public class Chat {
    private String idMensaje;
    private String contenido;
    private String idRemitente;
    private LocalDateTime timestamp;

    public Chat(String idMensaje, String contenido, String idRemitente, LocalDateTime timestamp) {
        // En el constructor se llaman a los setters para asegurar la validación inicial
        this.setIdMensaje(idMensaje);
        this.setContenido(contenido);
        this.setIdRemitente(idRemitente);
        this.setTimestamp(timestamp);
    }

    public String getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(String idMensaje) {
        // 1. RESTRICCIÓN: No se permiten campos vacíos. (Asumimos la validación básica de ID)
        if (idMensaje == null || idMensaje.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del Mensaje no puede estar vacío.");
        }
        this.idMensaje = idMensaje;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        // 2. RESTRICCIÓN: No se permiten campos vacíos.
        if (contenido == null || contenido.trim().isEmpty()) {
            throw new IllegalArgumentException("El Contenido del mensaje no puede estar vacío.");
        }
        this.contenido = contenido;
    }

    public String getIdRemitente() {
        return idRemitente;
    }

    public void setIdRemitente(String idRemitente) {
        // 3. RESTRICCIÓN: No se permiten campos vacíos.
        if (idRemitente == null || idRemitente.trim().isEmpty()) {
             throw new IllegalArgumentException("El ID del Remitente no puede estar vacío.");
        }
        this.idRemitente = idRemitente;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    
}