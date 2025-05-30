package modelo;

public class ArbolBinario {

    private Nodo<Persona> raiz;
    private final String criterioComparacion;

    public ArbolBinario(String criterio) {
        this.raiz = null;
        if (criterio != null && (criterio.equalsIgnoreCase("dni") || criterio.equalsIgnoreCase("nombre"))) {
            this.criterioComparacion = criterio.toLowerCase();
        } else {
            System.out.println("Criterio de comparación no válido. Usando DNI por defecto.");
            this.criterioComparacion = "dni";
        }
    }

    public boolean estaVacio() {
        return this.raiz == null;
    }

    private int compararPersonas(Persona p1, Persona p2) {
        if (p1 == null && p2 == null) {
            return 0; // Ambos son nulos, se consideran iguales en este contexto.
        }
        if (p1 == null) {
            // p1 es nulo, p2 no lo es. Consideramos p1 como "menor".
            System.err.println("Advertencia: p1 es nulo en la comparación.");
            return -1;
        }
        if (p2 == null) {
            // p2 es nulo, p1 no lo es. Consideramos p1 como "mayor".
            System.err.println("Advertencia: p2 es nulo en la comparación.");
            return 1;
        }

        // Si ninguno es nulo, procede con la comparación normal por criterio
        if ("dni".equals(this.criterioComparacion)) {
            return p1.getDni().compareTo(p2.getDni()); //
        } else {
            return p1.getNombere().compareTo(p2.getNombere()); //
        }
    }

    // --- Métodos de Inserción ---
    public void insertar(Persona persona) {
        if (persona == null) {
            System.out.println("No se puede insertar un valor nulo.");
            return;
        }
        this.raiz = insertarRecursivo(this.raiz, persona);
    }

    private Nodo<Persona> insertarRecursivo(Nodo<Persona> nodoActual, Persona personaAInsertar) {
        if (nodoActual == null) {
            // Asumiendo que Nodo tiene un constructor que toma el dato y
            // que izquierda y derecha se inicializan a null por defecto.
            return new Nodo<>(personaAInsertar); //
        }

        // Asumiendo que Nodo.java tiene getDato()
        int comparacion = compararPersonas(personaAInsertar, nodoActual.getDato()); //

        if (comparacion < 0) {
            // Asumiendo que Nodo.java tiene getizquierda() y setizquierda()
            nodoActual.setizquierda(insertarRecursivo(nodoActual.getizquierda(), personaAInsertar));
        } else if (comparacion > 0) {
            // Asumiendo que Nodo.java tiene getderecha() y setderecha()
            nodoActual.setderecha(insertarRecursivo(nodoActual.getderecha(), personaAInsertar));
        } else {
            System.out.println("Elemento duplicado según el criterio '" + this.criterioComparacion + "': " + personaAInsertar);
        }
        return nodoActual;
    }

    // --- Métodos de Búsqueda ---
    public Persona buscar(Persona personaClave) {
        if (personaClave == null) {
            System.out.println("No se puede buscar una persona nula.");
            return null;
        }
        Nodo<Persona> nodoEncontrado = buscarRecursivo(this.raiz, personaClave);
        return (nodoEncontrado == null) ? null : nodoEncontrado.getDato(); //
    }

    private Nodo<Persona> buscarRecursivo(Nodo<Persona> nodoActual, Persona personaClave) {
        if (nodoActual == null) {
            return null;
        }
        int comparacion = compararPersonas(personaClave, nodoActual.getDato()); //

        if (comparacion < 0) {
            return buscarRecursivo(nodoActual.getizquierda(), personaClave);
        } else if (comparacion > 0) {
            return buscarRecursivo(nodoActual.getderecha(), personaClave);
        } else {
            return nodoActual; // Elemento encontrado
        }
    }

    // --- Métodos de Eliminación ---
    public void eliminar(Persona personaAEliminar) {
        if (personaAEliminar == null) {
            System.out.println("No se puede eliminar un valor nulo.");
            return;
        }
        this.raiz = eliminarRecursivo(this.raiz, personaAEliminar);
    }

    private Nodo<Persona> eliminarRecursivo(Nodo<Persona> nodoActual, Persona personaAEliminar) {
        if (nodoActual == null) {
            System.out.println("Elemento no encontrado para eliminar: " + personaAEliminar);
            return null;
        }
        int comparacion = compararPersonas(personaAEliminar, nodoActual.getDato()); //

        if (comparacion < 0) {
            nodoActual.setizquierda(eliminarRecursivo(nodoActual.getizquierda(), personaAEliminar));
        } else if (comparacion > 0) {
            nodoActual.setderecha(eliminarRecursivo(nodoActual.getderecha(), personaAEliminar));
        } else {
            // Nodo encontrado, proceder con la eliminación
            Nodo<Persona> hijoIzquierdo = nodoActual.getizquierda();
            Nodo<Persona> hijoDerecho = nodoActual.getderecha();

            if (hijoIzquierdo == null && hijoDerecho == null) { // Caso 1: Nodo hoja
                return null;
            }
            if (hijoIzquierdo == null) { // Caso 2: Solo hijo derecho
                return hijoDerecho;
            }
            if (hijoDerecho == null) { // Caso 2: Solo hijo izquierdo
                return hijoIzquierdo;
            }
            
            // Caso 3: Nodo con dos hijos
            Persona sucesorDato = encontrarMinimo(hijoDerecho).getDato(); //
            nodoActual.setDato(sucesorDato); //
            nodoActual.setderecha(eliminarRecursivo(hijoDerecho, sucesorDato));
        }
        return nodoActual;
    }

    private Nodo<Persona> encontrarMinimo(Nodo<Persona> nodo) {
        Nodo<Persona> actual = nodo;
        while (actual.getizquierda() != null) {
            actual = actual.getizquierda();
        }
        return actual;
    }

    // --- Métodos de Recorrido (imprimiendo en consola) ---

    public void mostrarRecorridoEnOrden() {
        System.out.print("En Orden (" + this.criterioComparacion + "): ");
        if (estaVacio()) {
            System.out.println("Árbol vacío.");
            return;
        }
        recorridoEnOrdenRecursivo(this.raiz);
        System.out.println();
    }

    private void recorridoEnOrdenRecursivo(Nodo<Persona> nodo) {
        if (nodo != null) {
            recorridoEnOrdenRecursivo(nodo.getizquierda());
            System.out.print(nodo.getDato() + " | "); //
            recorridoEnOrdenRecursivo(nodo.getderecha());
        }
    }

    public void mostrarRecorridoPreOrden() {
        System.out.print("Pre Orden (" + this.criterioComparacion + "): ");
        if (estaVacio()) {
            System.out.println("Árbol vacío.");
            return;
        }
        recorridoPreOrdenRecursivo(this.raiz);
        System.out.println();
    }

    private void recorridoPreOrdenRecursivo(Nodo<Persona> nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + " | "); //
            recorridoPreOrdenRecursivo(nodo.getizquierda());
            recorridoPreOrdenRecursivo(nodo.getderecha());
        }
    }

    public void mostrarRecorridoPostOrden() {
        System.out.print("Post Orden (" + this.criterioComparacion + "): ");
        if (estaVacio()) {
            System.out.println("Árbol vacío.");
            return;
        }
        recorridoPostOrdenRecursivo(this.raiz);
        System.out.println();
    }

    private void recorridoPostOrdenRecursivo(Nodo<Persona> nodo) {
        if (nodo != null) {
            recorridoPostOrdenRecursivo(nodo.getizquierda());
            recorridoPostOrdenRecursivo(nodo.getderecha());
            System.out.print(nodo.getDato() + " | "); //
        }
    }
}