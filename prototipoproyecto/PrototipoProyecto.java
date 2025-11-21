/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.prototipoproyecto;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author paulasteller
 */
public class PrototipoProyecto {
    
    // Lista de departamentos válidos para la restricción que se va a cumplir en la seccion de los departamentos
    private static final List<String> DEPARTAMENTOS_VALIDOS = Arrays.asList(
            "IT", "VENTAS", "MARKETING", "RRHH", "CONTABILIDAD", "OPERACIONES"
    );
    // Lista de prioridades válidas para la restricción de las prioridades 
    private static final List<String> PRIORIDADES_VALIDAS = Arrays.asList(
            "Baja", "Media", "Alta"
    );

    public static void main(String[] args) {
      // Este Scanner lo usamos Scanner para ingresar los datos del usuario desde la consola
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- SIMULACIÓN DE GESTIÓN DE TIQUETES ---\n");
        
        // VARIABLES PARA ALMACENAR DATOS PARA LA VALIDACION
        String empId = "";
        String empNombre = "";
        String empApellido = "";
        String empCorreo = "";
        String empDepto = "";
        String tecId = "";
        String tecNombre = "";
        String tecApellido = "";
        String tecEspecialidad = "";
        String tqId = "";
        String tqTitulo = "";
        String tqDescripcion = "";
        String tqPrioridad = "";

        // CREACIÓN DE USUARIOS (Empleado y Técnico)
        // --- 1. INGRESO DE DATOS DEL EMPLEADO QUE REPORTA ---

        System.out.println("\n--- 1. INGRESO DE DATOS DEL EMPLEADO QUE REPORTA ---");

        // ID del empleado debe iniciar con E y tener 3 números (E101).
        // No se permiten campos vacíos.
        while (true) {
            System.out.print("Ingrese ID del Empleado (Ej: E105): ");
            empId = scanner.nextLine().trim();
            if (empId.isEmpty()) {
                System.out.println("ERROR: El ID del empleado no puede estar vacío.");
            } else if (!Pattern.matches("^E\\d{3}$", empId)) {
                System.out.println("ERROR: El ID del empleado debe iniciar con 'E' y tener 3 números (Ej: E105).");
            } else {
                break;
            }
        }
        
        // No se permiten campos vacíos.
        while (true) {
            System.out.print("Ingrese Nombre del Empleado: ");
            empNombre = scanner.nextLine().trim();
            if (empNombre.isEmpty()) {
                System.out.println("ERROR: El nombre del empleado no puede estar vacío.");
            } else {
                break;
            }
        }
        
        // No se permiten campos vacíos.
        while (true) {
            System.out.print("Ingrese Apellido del Empleado: ");
            empApellido = scanner.nextLine().trim();
            if (empApellido.isEmpty()) {
                System.out.println("ERROR: El apellido del empleado no puede estar vacío.");
            } else {
                break;
            }
        }

        // El correo debe tener formato válido.
        // No se permiten campos vacíos.
        while (true) {
            System.out.print("Ingrese Correo del Empleado: ");
            empCorreo = scanner.nextLine().trim();
            if (empCorreo.isEmpty()) {
                System.out.println("ERROR: El correo del empleado no puede estar vacío.");
            } else if (!Pattern.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$", empCorreo)) {
                 System.out.println("ERROR: El correo debe tener un formato válido (Ej: usuario@dominio.com).");
            } else {
                break;
            }
        }
        
        // El departamento debe ser uno de una lista.
        // No se permiten campos vacíos.
        while (true) {
            System.out.print("Ingrese Departamento del Empleado (Ej: Ventas): ");
            empDepto = scanner.nextLine().trim();
            if (empDepto.isEmpty()) {
                System.out.println("ERROR: El departamento no puede estar vacío.");
            } else if (!DEPARTAMENTOS_VALIDOS.contains(empDepto.toUpperCase())) {
                System.out.println("ERROR: Departamento inválido. Debe ser uno de: " + DEPARTAMENTOS_VALIDOS);
            } else {
                break;
            }
        }
        
        // constructor de la clase Empleado para mostrar el empleado que se creo
        Empleado empleadoReportando = new Empleado(empId, empNombre, empApellido, empCorreo, empDepto);
        System.out.println(" Empleado Creado: " + empleadoReportando.getNombre() + " (" + empleadoReportando.getDepartamento() + ")");

        // ------------------------------------------------------------------
        // --- 2. INGRESO DE DATOS DEL TÉCNICO ASIGNADO ---
        System.out.println("\n--- 2. INGRESO DE DATOS DEL TÉCNICO ASIGNADO ---");

        // El ID del técnico debe iniciar con T.
        // No se permiten campos vacíos.
        while (true) {
            System.out.print("Ingrese ID del Técnico (Ej: T003): ");
            tecId = scanner.nextLine().trim();
            if (tecId.isEmpty()) {
                System.out.println("ERROR: El ID del técnico no puede estar vacío.");
            } else if (!tecId.toUpperCase().startsWith("T")) {
                System.out.println("ERROR: El ID del técnico debe iniciar con 'T'.");
            } else {
                break;
            }
        }
        
        // No se permiten campos vacíos.
        while (true) {
            System.out.print("Ingrese Nombre del Técnico: ");
            tecNombre = scanner.nextLine().trim(); 
            if (tecNombre.isEmpty()) {
                System.out.println("ERROR: El nombre del técnico no puede estar vacío.");
            } else {
                break;
            }
        }

        // No se permiten campos vacíos.
        while (true) {
            System.out.print("Ingrese Apellido del Técnico: ");
            tecApellido = scanner.nextLine().trim(); 
             if (tecApellido.isEmpty()) {
                System.out.println("ERROR: El apellido del técnico no puede estar vacío.");
            } else {
                break;
            }
        }
        
        // No se permiten campos vacíos. (Asumimos que especialidad no tiene restricción de lista).
        while (true) {
             System.out.print("Ingrese Especialidad del Técnico (Ej: Redes): ");
             tecEspecialidad = scanner.nextLine().trim();
             if (tecEspecialidad.isEmpty()) {
                 System.out.println("ERROR: La especialidad del técnico no puede estar vacía.");
             } else {
                 break;
             }
        }

        // constructor de la clase Tecnico para mostrar el tecnico que se creo 
        Tecnico tecnicoAsignado = new Tecnico(tecId, tecNombre, tecApellido, tecEspecialidad);
        System.out.println(" Técnico Creado: " + tecnicoAsignado.getNombre() + " (" + tecnicoAsignado.getEspecialidad() + ")");


        // ------------------------------------------------------------------
        // --- 3. CREACIÓN DEL TIQUETE DE SOPORTE ---
        System.out.println("\n--- 3. CREACIÓN DEL TIQUETE DE SOPORTE ---");
        
        // El ID del tiquete debe tener formato HT-XXX.
        // No se permiten campos vacíos.
        while (true) {
            System.out.print("Ingrese ID del Tiquete (Ej: HT-001): ");
            tqId = scanner.nextLine().trim();
            if (tqId.isEmpty()) {
                System.out.println("ERROR: El ID del tiquete no puede estar vacío.");
            } else if (!Pattern.matches("^HT-\\w{3}$", tqId.toUpperCase())) { // Usamos toUpperCase para ser flexible
                System.out.println("ERROR: El ID del tiquete debe tener formato HT-XXX (Ej: HT-A01 o HT-001).");
            } else {
                break;
            }
        }
        
        // El título debe tener mínimo 10 caracteres.
        // No se permiten campos vacíos.
        while (true) {
            System.out.print("Ingrese Título del Tiquete: ");
            tqTitulo = scanner.nextLine().trim();
            if (tqTitulo.isEmpty()) {
                System.out.println("ERROR: El título no puede estar vacío.");
            } else if (tqTitulo.length() < 10) {
                System.out.println("ERROR: El título debe tener un mínimo de 10 caracteres. Actualmente tiene " + tqTitulo.length() + ".");
            } else {
                break;
            }
        }
        
        // No se permiten campos vacíos.
        while (true) {
            System.out.print("Ingrese Descripción del Tiquete: ");
            tqDescripcion = scanner.nextLine().trim();
            if (tqDescripcion.isEmpty()) {
                System.out.println("ERROR: La descripción no puede estar vacía.");
            } else {
                break;
            }
        }
        
        // Prioridad solo puede ser Baja / Media / Alta.
        // No se permiten campos vacíos.
        while (true) {
            System.out.print("Ingrese Prioridad (Baja/Media/Alta): ");
            tqPrioridad = scanner.nextLine().trim();
            if (tqPrioridad.isEmpty()) {
                System.out.println("ERROR: La prioridad no puede estar vacía.");
            } else if (!PRIORIDADES_VALIDAS.contains(tqPrioridad)) {
                System.out.println("ERROR: Prioridad inválida. Debe ser Baja, Media o Alta.");
            } else {
                break;
            }
        }
        
        // Estado inicial y fecha de creación del chat
        String tqEstadoInicial = "Abierto"; 
        LocalDateTime fechaCreacion = LocalDateTime.now();
        
        // constructor de la clase Tiquete
        Tiquete nuevoTiquete = new Tiquete(tqId, tqTitulo, tqDescripcion, tqPrioridad, tqEstadoInicial, fechaCreacion);
        
        System.out.println("\n Tiquete Creado Exitosamente:");
        System.out.println("   ID: " + nuevoTiquete.getIdTiquete() + " | Título: " + nuevoTiquete.getTitulo());
        System.out.println("   Reportado por: " + empleadoReportando.getNombre() + " " + empleadoReportando.getApellido());
        System.out.println("   Estado Inicial: " + nuevoTiquete.getEstado() + " | Prioridad: " + nuevoTiquete.getPrioridad());
        
        // --- 4. SIMULACIÓN DE GESTIÓN Y CHAT ---
        
        System.out.println("\n--- 4. SIMULACIÓN DE GESTIÓN Y CHAT ---");
        
        // El técnico asigna el tiquete
        nuevoTiquete.setEstado("En Progreso"); 
        System.out.println(" Tiquete Asignado a " + tecnicoAsignado.getNombre() + ". Nuevo Estado: " + nuevoTiquete.getEstado());

        // Mensaje del Técnico
        System.out.println("\n--- CHAT ---");
        System.out.print("Ingrese el Contenido del Primer Mensaje del Técnico: ");
        String chatContenido1 = scanner.nextLine();
        
        Chat chatMsg1 = new Chat(
            "C-" + tqId + "-MSG1", 
            chatContenido1, 
            tecnicoAsignado.getIdTecnico(), 
            LocalDateTime.now().plusMinutes(1)
        );
        System.out.println(" Mensaje de Chat Enviado (Técnico):\n   Contenido: \"" + chatMsg1.getContenido() + "\"");

        // Mensaje del Empleado
        System.out.print("Ingrese la Respuesta del Empleado: ");
        String chatContenido2 = scanner.nextLine();
        
        Chat chatMsg2 = new Chat(
            "C-" + tqId + "-MSG2", 
            chatContenido2, 
            empleadoReportando.getIdEmpleado(), 
            LocalDateTime.now().plusMinutes(2)
        );
        System.out.println(" Mensaje de Chat Enviado (Empleado):\n   Contenido: \"" + chatMsg2.getContenido() + "\"");

        // Cierre del tiquete
        nuevoTiquete.setEstado("Resuelto");
        System.out.println("\n Tiquete Resuelto y Cerrado. Estado Final: " + nuevoTiquete.getEstado());
        
        // Cerrar el objeto Scanner ya que ya no vamos a ingresar datos
        scanner.close();
    }
}