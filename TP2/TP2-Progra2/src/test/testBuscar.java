package test; // O el paquete que decidas usar

import modelo.ArbolBinario;
import modelo.Persona;

public class testBuscar {

    public static void main(String[] args) {
        System.out.println("--- PRUEBAS DE busqueda EN arbol BINARIO ---");

        // Datos y llenado del arbol (para DNI)
        ArbolBinario arbolDni = new ArbolBinario("dni");
        Persona[] personas = {
            new Persona("Laura", 20123456), new Persona("Carlos", 18765432),
            new Persona("Ana", 30987654), new Persona("Pedro", 15123123), // DNI a buscar: 15123123
            new Persona("Jorge", 12121212)  // DNI a buscar: 12121212
        };
        for (Persona p : personas) {
            arbolDni.insertar(p);
        }
        System.out.println("arbol por DNI (En Orden) para pruebas de busqueda:");
        arbolDni.mostrarRecorridoEnOrden();

        // --- busquedas en arbol por DNI ---
        System.out.println("\n--- busqueda POR DNI ---");
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

        // Datos y llenado del arbol (para Nombre)
        ArbolBinario arbolNombre = new ArbolBinario("nombre");
        // Reusar personas, o definir nuevas específicas para test de nombre
        for (Persona p : personas) {
            arbolNombre.insertar(p);
        }
        System.out.println("\narbol por Nombre (En Orden) para pruebas de busqueda:");
        arbolNombre.mostrarRecorridoEnOrden();
        
        // --- busquedas en arbol por Nombre ---
        System.out.println("\n--- busqueda POR NOMBRE ---");
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

        System.out.println("\n--- FIN PRUEBAS DE busqueda ---");
    }

}
