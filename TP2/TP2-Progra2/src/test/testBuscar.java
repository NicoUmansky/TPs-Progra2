package test; // O el paquete que decidas usar

import modelo.ArbolBinario;
import modelo.Persona;

public class testBuscar {

    public static void main(String[] args) {
        System.out.println("--- PRUEBAS DE BÚSQUEDA EN ÁRBOL BINARIO ---");

        // Datos y llenado del árbol (para DNI)
        ArbolBinario arbolDni = new ArbolBinario("dni");
        Persona[] personas = {
            new Persona("Laura", 20123456), new Persona("Carlos", 18765432),
            new Persona("Ana", 30987654), new Persona("Pedro", 15123123), // DNI a buscar: 15123123
            new Persona("Jorge", 12121212)  // DNI a buscar: 12121212
        };
        for (Persona p : personas) {
            arbolDni.insertar(p);
        }
        System.out.println("Árbol por DNI (En Orden) para pruebas de búsqueda:");
        arbolDni.mostrarRecorridoEnOrden();

        // --- Búsquedas en árbol por DNI ---
        System.out.println("\n--- BÚSQUEDA POR DNI ---");
        Persona claveBusquedaDniExistente = new Persona("Buscar DNI", 12121212); // Jorge
        Persona claveBusquedaDniNoExistente = new Persona("Buscar DNI", 11111111);

        System.out.println("Buscando por DNI " + claveBusquedaDniExistente.getDni() + ":");
        Persona encontrada = arbolDni.buscar(claveBusquedaDniExistente);
        if (encontrada != null) {
            System.out.println("ENCONTRADO: " + encontrada);
        } else {
            System.out.println("NO ENCONTRADO.");
        }

        System.out.println("Buscando por DNI " + claveBusquedaDniNoExistente.getDni() + ":");
        encontrada = arbolDni.buscar(claveBusquedaDniNoExistente);
        if (encontrada != null) {
            System.out.println("ENCONTRADO (Error, no debería existir): " + encontrada);
        } else {
            System.out.println("NO ENCONTRADO (Correcto).");
        }

        // Datos y llenado del árbol (para Nombre)
        ArbolBinario arbolNombre = new ArbolBinario("nombre");
        // Reusar personas, o definir nuevas específicas para test de nombre
        for (Persona p : personas) {
            arbolNombre.insertar(p);
        }
        System.out.println("\nÁrbol por Nombre (En Orden) para pruebas de búsqueda:");
        arbolNombre.mostrarRecorridoEnOrden();
        
        // --- Búsquedas en árbol por Nombre ---
        System.out.println("\n--- BÚSQUEDA POR NOMBRE ---");
        Persona claveBusquedaNombreExistente = new Persona("Pedro", 0); 
        Persona claveBusquedaNombreNoExistente = new Persona("XyzNombre", 0);

        System.out.println("Buscando por Nombre '" + claveBusquedaNombreExistente.getNombre() + "':");
        encontrada = arbolNombre.buscar(claveBusquedaNombreExistente);
        if (encontrada != null) {
            System.out.println("ENCONTRADO: " + encontrada);
        } else {
            System.out.println("NO ENCONTRADO.");
        }
        
        System.out.println("Buscando por Nombre '" + claveBusquedaNombreNoExistente.getNombre() + "':");
        encontrada = arbolNombre.buscar(claveBusquedaNombreNoExistente);
         if (encontrada != null) {
            System.out.println("ENCONTRADO (Error, no debería existir): " + encontrada);
        } else {
            System.out.println("NO ENCONTRADO (Correcto).");
        }

        System.out.println("\n--- FIN PRUEBAS DE BÚSQUEDA ---");
    }

}
