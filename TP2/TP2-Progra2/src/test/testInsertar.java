package test; // O el paquete que decidas usar para tus tests

import modelo.ArbolBinario;
import modelo.Persona;

public class testInsertar {

    public static void main(String[] args) {
        System.out.println("--- PRUEBAS DE INSERCIÓN EN ÁRBOL BINARIO ---");

        // Datos de prueba
        Persona[] personas = {
            new Persona("Laura", 20123456), new Persona("Carlos", 18765432),
            new Persona("Ana", 30987654), new Persona("Pedro", 15123123),
            new Persona("Sofia", 22345678), new Persona("Luis", 10543210)
            // Puedes añadir más personas si lo deseas
        };

        // --- Test con criterio DNI ---
        System.out.println("\n--- ÁRBOL ORDENADO POR DNI ---");
        ArbolBinario arbolDni = new ArbolBinario("dni");

        System.out.println("Insertando personas en árbol por DNI...");
        for (Persona p : personas) {
            System.out.println("Insertando: " + p);
            arbolDni.insertar(p);
        }

        System.out.println("\nRecorridos después de inserción (DNI):");
        System.out.print("En Orden: ");
        arbolDni.mostrarRecorridoEnOrden();
        System.out.print("Pre Orden: ");
        arbolDni.mostrarRecorridoPreOrden();
        System.out.print("Post Orden: ");
        arbolDni.mostrarRecorridoPostOrden();

        // --- Test con criterio Nombre ---
        System.out.println("\n\n--- ÁRBOL ORDENADO POR NOMBRE ---");
        ArbolBinario arbolNombre = new ArbolBinario("nombre");

        System.out.println("Insertando personas en árbol por Nombre...");
        for (Persona p : personas) {
            System.out.println("Insertando: " + p);
            arbolNombre.insertar(p);
        }

        System.out.println("\nRecorridos después de inserción (Nombre):");
        System.out.print("En Orden: ");
        arbolNombre.mostrarRecorridoEnOrden();
        System.out.print("Pre Orden: ");
        arbolNombre.mostrarRecorridoPreOrden();
        System.out.print("Post Orden: ");
        arbolNombre.mostrarRecorridoPostOrden();
        
        System.out.println("\n--- FIN PRUEBAS DE INSERCIÓN ---");
    }
}

