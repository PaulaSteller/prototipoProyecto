/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.prototipoproyecto;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author paulasteller
 */
public class Empleado {
    private String idEmpleado;
    private String nombre;
    private String apellido;
    private String correo;
    private String departamento;
    
    // Lista de departamentos válidos
    private static final List<String> DEPARTAMENTOS_VALIDOS = Arrays.asList(
            "IT", "VENTAS", "MARKETING", "RRHH", "CONTABILIDAD", "OPERACIONES"
    );

    public Empleado(String idEmpleado, String nombre, String apellido, String correo, String departamento) {
        // el constructor se llaman a los setters para asegurar la validación inicial
        this.setIdEmpleado(idEmpleado);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setCorreo(correo);
        this.setDepartamento(departamento);
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        // 1. RESTRICCIÓN: ID del empleado debe iniciar con E y tener 3 números (E101).
        // 2. RESTRICCIÓN: No se permiten campos vacíos.
        if (idEmpleado == null || idEmpleado.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del empleado no puede estar vacío.");
        }
        if (!Pattern.matches("^E\\d{3}$", idEmpleado.trim())) {
            throw new IllegalArgumentException("ID de Empleado inválido. Debe tener formato E000 (Ej: E101).");
        }
        this.idEmpleado = idEmpleado;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        // 1. RESTRICCIÓN: El correo debe tener formato válido.
        // 2. RESTRICCIÓN: No se permiten campos vacíos.
        if (correo == null || correo.trim().isEmpty()) {
             throw new IllegalArgumentException("El Correo no puede estar vacío.");
        }
        if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", correo.trim())) {
            throw new IllegalArgumentException("Formato de correo inválido.");
        }
        this.correo = correo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        // 1. RESTRICCIÓN: El departamento debe ser uno de una lista.
        // 2. RESTRICCIÓN: No se permiten campos vacíos.
        if (departamento == null || departamento.trim().isEmpty()) {
             throw new IllegalArgumentException("El Departamento no puede estar vacío.");
        }
        if (!DEPARTAMENTOS_VALIDOS.contains(departamento.trim().toUpperCase())) {
            throw new IllegalArgumentException("Departamento inválido. Debe ser uno de: " + DEPARTAMENTOS_VALIDOS);
        }
        this.departamento = departamento;
    }
    
    
}


 ///La principal función de .trim() es limpiar la entrada de datos que proviene de los usuarios, asegurando que los valores almacenados o comparados sean precisos.