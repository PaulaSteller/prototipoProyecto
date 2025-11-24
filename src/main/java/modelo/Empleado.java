/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author kevin
 */
public class Empleado extends Usuario {
    
    public Empleado(int id, String nombre, String correo, String password) {
        super(id, nombre, correo, password, "EMPLEADO");
    }

    @Override
    public String getTipo() {
        return "EMPLEADO";
    }
}