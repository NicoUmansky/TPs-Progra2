package test; // O el paquete que decidas usar

import modelo.ArbolBinario;
import modelo.Persona;

public class testEliminar {
    // Método auxiliar para poblar el Arbol y mostrarlo
    private static void poblarYMostrar(ArbolBinario arbol, Persona[] personas, String titulo) {
        System.out.println("\n--- " + titulo + " ---");
        for (Persona p : personas) {
            arbol.insertar(p);
        }
        System.out.println("Estado inicial del Arbol (En Orden):");
        arbol.mostrarRecorridoEnOrden();
    }

    public static void main(String[] args) {
        System.out.println("--- PRUEBAS DE ELIMINACION EN Arbol BINARIO ---");

        Persona[] personasIniciales = {
            new Persona("Laura", 20123456), new Persona("Carlos", 18765432),
            new Persona("Ana", 30987654), new Persona("Pedro", 15123123),
            new Persona("Sofia", 22345678), new Persona("Luis", 10543210),
            new Persona("Jorge", 12121212), new Persona("Valeria", 35678901),
            new Persona("Mateo", 45112233) // Usado para prueba de ELIMINACION de hoja
        };

        // --- Test de ELIMINACION en Arbol por DNI ---
        ArbolBinario arbolDni = new ArbolBinario("dni");
        poblarYMostrar(arbolDni, personasIniciales, "Arbol POR DNI PARA ELIMINACION");

        // Caso 1: Eliminar nodo hoja (Mateo DNI: 45112233)
        System.out.println("\nEliminando nodo hoja (Mateo, DNI 45112233):");
        arbolDni.eliminar(new Persona("Mateo", 45112233));
        arbolDni.mostrarRecorridoEnOrden();

        // Caso 2: Eliminar nodo con un hijo
        // (Tras eliminar a Mateo, si Luis (10543210) era su padre y no tenía otro hijo, Luis podría tener un hijo o ser hoja)
        // O eliminamos a Pedro (15123123), si Carlos (18765432) es su padre y Jorge (12121212) su otro hijo, Carlos tendría 1 hijo
        System.out.println("\nEliminando nodo con un hijo (Pedro, DNI 15123123):");
        arbolDni.eliminar(new Persona("Pedro", 15123123));
        arbolDni.mostrarRecorridoEnOrden();

        // Caso 3: Eliminar nodo con dos hijos (Laura DNI: 20123456, probablemente la raíz o un nodo interno)
        System.out.println("\nEliminando nodo con dos hijos (Laura, DNI 20123456):");
        arbolDni.eliminar(new Persona("Laura", 20123456));
        arbolDni.mostrarRecorridoEnOrden();
        
        // Caso 4: Eliminar nodo no existente
        System.out.println("\nIntentando eliminar nodo no existente (DNI 99999999):");
        arbolDni.eliminar(new Persona("NoExiste", 99999999));
        arbolDni.mostrarRecorridoEnOrden(); // No debería cambiar

        System.out.println("\n--- FIN PRUEBAS DE ELIMINACION (DNI) ---");

    }
}
