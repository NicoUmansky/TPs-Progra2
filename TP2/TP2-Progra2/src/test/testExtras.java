package test; // O el paquete que decidas usar

import modelo.ArbolBinario;
import modelo.Persona;

public class testExtras {

    public static void main(String[] args) {
        System.out.println("--- PRUEBAS DE FUNCIONALIDADES EXTRAS DEL ÁRBOL BINARIO ---");

        // --- Prueba de estaVacio() ---
        System.out.println("\n--- Probando estaVacio() ---");
        ArbolBinario arbol = new ArbolBinario("dni");

        System.out.println("¿El árbol recién creado está vacío? " + (arbol.estaVacio() ? "Sí (Correcto)" : "No (Error)"));

        arbol.insertar(new Persona("Alguien", 123));
        System.out.println("Después de insertar un elemento, ¿el árbol está vacío? " + (arbol.estaVacio() ? "Sí (Error)" : "No (Correcto)"));

        // --- Prueba de inserción de duplicados (verificar que no se inserten y se muestre mensaje) ---
        System.out.println("\n--- Probando inserción de duplicados (DNI) ---");
        ArbolBinario arbolDuplicadosDni = new ArbolBinario("dni");
        arbolDuplicadosDni.insertar(new Persona("PersonaA", 100));
        arbolDuplicadosDni.insertar(new Persona("PersonaB", 200));
        System.out.println("Intentando insertar duplicado por DNI (PersonaC, 100):");
        arbolDuplicadosDni.insertar(new Persona("PersonaC", 100)); // Debería imprimir mensaje de duplicado
        System.out.print("Recorrido En Orden (DNI) después de intentar duplicado: ");
        arbolDuplicadosDni.mostrarRecorridoEnOrden(); // Debería haber solo PersonaA y PersonaB

        System.out.println("\n--- Probando inserción de duplicados (Nombre) ---");
        ArbolBinario arbolDuplicadosNombre = new ArbolBinario("nombre");
        arbolDuplicadosNombre.insertar(new Persona("Alfa", 10));
        arbolDuplicadosNombre.insertar(new Persona("Beta", 20));
        System.out.println("Intentando insertar duplicado por Nombre (Alfa, 30):");
        arbolDuplicadosNombre.insertar(new Persona("Alfa", 30)); // Debería imprimir mensaje de duplicado
        System.out.print("Recorrido En Orden (Nombre) después de intentar duplicado: ");
        arbolDuplicadosNombre.mostrarRecorridoEnOrden(); // Debería haber solo Alfa y Beta


        // --- Prueba de inserción de elemento nulo ---
        System.out.println("\n--- Probando inserción de elemento nulo ---");
        ArbolBinario arbolNulo = new ArbolBinario("dni");
        System.out.println("Intentando insertar null:");
        arbolNulo.insertar(null); // Debería imprimir mensaje y no fallar
        System.out.println("¿Árbol vacío después de intentar insertar null? " + arbolNulo.estaVacio());


        // --- Prueba de búsqueda de elemento nulo ---
        System.out.println("\n--- Probando búsqueda de elemento nulo ---");
        System.out.println("Intentando buscar null:");
        Persona encontrado = arbol.buscar(null); // arbol ya tiene "Alguien"
        System.out.println("Encontrado: " + encontrado + (encontrado == null ? " (Correcto)" : " (Error)"));


        // --- Prueba de eliminación de elemento nulo ---
        System.out.println("\n--- Probando eliminación de elemento nulo ---");
        System.out.println("Intentando eliminar null:");
        arbol.eliminar(null); // arbol ya tiene "Alguien"
        System.out.print("Recorrido En Orden después de intentar eliminar null: ");
        arbol.mostrarRecorridoEnOrden(); // No debería cambiar


        System.out.println("\n--- FIN PRUEBAS EXTRAS ---");
    }
}