package test; // O el paquete que decidas usar

import modelo.ArbolBinario;
import modelo.Persona;

public class testRecorrer {

    private static void probarRecorridos(String descripcionArbol, ArbolBinario arbol) {
        System.out.println("\n--- Probando Recorridos para: " + descripcionArbol + " ---");
        System.out.println("Criterio de ordenación: " + arbol.getCriterioComparacion()); 

        if (arbol.estaVacio()) {
            System.out.println("El arbol está vacío.");
        }

        System.out.print("En Orden:   ");
        arbol.mostrarRecorridoEnOrden();
        System.out.print("Pre Orden:  ");
        arbol.mostrarRecorridoPreOrden();
        System.out.print("Post Orden: ");
        arbol.mostrarRecorridoPostOrden();
        System.out.println("------------------------------------");
    }
    

    public static void main(String[] args) {
        System.out.println("--- PRUEBAS DE RECORRIDOS EN arbol BINARIO ---");

        // Escenario 1: arbol Vacío
        ArbolBinario arbolVacioDni = new ArbolBinario("dni");
        probarRecorridos("arbol Vacío (DNI)", arbolVacioDni);

        ArbolBinario arbolVacioNombre = new ArbolBinario("nombre");
        probarRecorridos("arbol Vacío (Nombre)", arbolVacioNombre);

        // Escenario 2: arbol con un solo nodo
        ArbolBinario arbolUnNodoDni = new ArbolBinario("dni");
        arbolUnNodoDni.insertar(new Persona("Unico", 100));
        probarRecorridos("arbol con un solo nodo (DNI)", arbolUnNodoDni);
        
        ArbolBinario arbolUnNodoNombre = new ArbolBinario("nombre");
        arbolUnNodoNombre.insertar(new Persona("Unico", 100));
        probarRecorridos("arbol con un solo nodo (Nombre)", arbolUnNodoNombre);


        // Escenario 3: arbol más completo (ordenado por DNI)
        ArbolBinario arbolCompletoDni = new ArbolBinario("dni");
        Persona[] personasDni = {
            new Persona("Laura", 20), new Persona("Carlos", 10),
            new Persona("Ana", 30), new Persona("Pedro", 5),
            new Persona("Sofia", 15), new Persona("Luis", 25),
            new Persona("Maria", 35)
        };
        for (Persona p : personasDni) {
            arbolCompletoDni.insertar(p);
        }
        probarRecorridos("arbol Completo (DNI)", arbolCompletoDni);

        // Escenario 4: arbol más completo (ordenado por Nombre)
        ArbolBinario arbolCompletoNombre = new ArbolBinario("nombre");
        Persona[] personasNombre = { // Nombres en orden para predecir estructura
            new Persona("Laura", 20), new Persona("Carlos", 10),
            new Persona("Ana", 30), new Persona("Pedro", 5),
            new Persona("Sofia", 15), new Persona("Luis", 25),
            new Persona("Maria", 35)
        };
        // Insertar en un orden que genere un arbol interesante
        arbolCompletoNombre.insertar(personasNombre[0]); // Laura
        arbolCompletoNombre.insertar(personasNombre[1]); // Carlos
        arbolCompletoNombre.insertar(personasNombre[3]); // Pedro (irá a la izq de Carlos)
        arbolCompletoNombre.insertar(personasNombre[2]); // Ana (irá a la der de Laura)
        arbolCompletoNombre.insertar(personasNombre[4]); // Sofia (irá a la der de Pedro o izq de Laura)
        arbolCompletoNombre.insertar(personasNombre[6]); // Maria (irá a la der de Ana)
        arbolCompletoNombre.insertar(personasNombre[5]); // Luis (irá a la izq de Maria o der de Ana)

        probarRecorridos("arbol Completo (Nombre)", arbolCompletoNombre);
        
        // Escenario 5: arbol degenerado (elementos insertados en orden) - por DNI
        ArbolBinario arbolDegeneradoDni = new ArbolBinario("dni");
        for (int i = 1; i <= 5; i++) {
            arbolDegeneradoDni.insertar(new Persona("Persona" + i, i * 10));
        }
        probarRecorridos("arbol Degenerado (DNI, insertados en orden)", arbolDegeneradoDni);

        // Escenario 6: arbol degenerado (elementos insertados en orden inverso) - por DNI
        ArbolBinario arbolDegeneradoInversoDni = new ArbolBinario("dni");
        for (int i = 5; i >= 1; i--) {
            arbolDegeneradoInversoDni.insertar(new Persona("Persona" + i, i * 10));
        }
        probarRecorridos("arbol Degenerado (DNI, insertados en orden inverso)", arbolDegeneradoInversoDni);

        System.out.println("\n--- FIN PRUEBAS DE RECORRIDOS ---");
    }

}
