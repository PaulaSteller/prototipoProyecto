# Programación Cliente-servidor SistTiquetes

El Sistema de Gestión de Tiquetes es un proyecto desarrollado como parte del curso Programación Cliente-Servidor (SC-303). Su objetivo es implementar un Mínimo Producto Viable (MPV) que simule un entorno real de soporte técnico, donde empleados generan tiquetes, los técnicos los atienden y ambas partes cuentan con un sistema de mensajería interna para comunicarse sobre cada caso.

Este proyecto aplica los conceptos principales vistos en el curso, tales como programación cliente-servidor, sockets, hilos, manejo de excepciones, encriptación de datos, colecciones en memoria y el uso de interfaces gráficas con Swing bajo el enfoque MVC.
El sistema implementa un servidor capaz de aceptar múltiples conexiones simultáneas mediante hilos.
Cada cliente se comunica con el servidor a través de mensajes estructurados usando su propio protocolo de comandos (LOGIN, NUEVO_TIQ, LISTA_TIQ_EMP, CHAT_ENVIAR, etc.).
Esto permite manejar:

- Inicio de sesión.
- Creación de tiquetes.
- Asignación por parte del técnico.
- Actualización de listas en tiempo real.
- Chat interno con broadcast a todos los usuarios conectados.

No se utiliza una base de datos externa.
El servidor mantiene la información en un repositorio centralizado que simula una base de datos utilizando colecciones genéricas:

- Lista de usuarios registrados.
- Lista de tiquetes.
- Lista de mensajes del chat.

Esta aproximación cumple con los requerimientos de un MPV y refleja el uso de estructuras de datos eficientes en Java.
