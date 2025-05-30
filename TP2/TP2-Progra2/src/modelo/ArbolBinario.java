package modelo;
import interfaces.IArbolBinario;
import interfaces.INodo;
public class ArbolBinario implements IArbolBinario {

    private INodo<Persona> raiz;
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

    @Override
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
            // return p1.getDni().compareTo(p2.getDni()); //
            if (p1.getDni() < p2.getDni()) {
                return -1; // p1 es menor que p2
            } else if (p1.getDni() > p2.getDni()) {
                return 1; // p1 es mayor que p2
            } else {
                return 0; // Son iguales
            }

        } else {
            return p1.getNombere().compareTo(p2.getNombere()); //
        }
    }

    // --- Métodos de Inserción ---
    @Override
    public void insertar(Persona persona) {
        if (persona == null) {
            System.out.println("No se puede insertar un valor nulo.");
            return;
        }
        this.raiz = insertarRecursivo(this.raiz, persona);
    }

    private INodo<Persona> insertarRecursivo(INodo<Persona> INodoActual, Persona personaAInsertar) {
        if (INodoActual == null) {
            // Asumiendo que INodo tiene un constructor que toma el dato y
            // que izquierda y derecha se inicializan a null por defecto.
            return new Nodo<>(personaAInsertar); //
        }

        // Asumiendo que INodo.java tiene getDato()
        int comparacion = compararPersonas(personaAInsertar, INodoActual.getDato()); //

        if (comparacion < 0) {
            // Asumiendo que INodo.java tiene getizquierda() y setizquierda()
            INodoActual.setizquierda(insertarRecursivo(INodoActual.getizquierda(), personaAInsertar));
        } else if (comparacion > 0) {
            // Asumiendo que INodo.java tiene getderecha() y setderecha()
            INodoActual.setderecha(insertarRecursivo(INodoActual.getderecha(), personaAInsertar));
        } else {
            System.out.println("Elemento duplicado según el criterio '" + this.criterioComparacion + "': " + personaAInsertar);
        }
        return INodoActual;
    }

    // --- Métodos de Búsqueda ---
    @Override
    public Persona buscar(Persona personaClave) {
        if (personaClave == null) {
            System.out.println("No se puede buscar una persona nula.");
            return null;
        }
        INodo<Persona> INodoEncontrado = buscarRecursivo(this.raiz, personaClave);
        return (INodoEncontrado == null) ? null : INodoEncontrado.getDato(); //
    }

    private INodo<Persona> buscarRecursivo(INodo<Persona> INodoActual, Persona personaClave) {
        if (INodoActual == null) {
            return null;
        }
        int comparacion = compararPersonas(personaClave, INodoActual.getDato()); //

        if (comparacion < 0) {
            return buscarRecursivo(INodoActual.getizquierda(), personaClave);
        } else if (comparacion > 0) {
            return buscarRecursivo(INodoActual.getderecha(), personaClave);
        } else {
            return INodoActual; // Elemento encontrado
        }
    }

    // --- Métodos de Eliminación ---
    @Override
    public void eliminar(Persona personaAEliminar) {
        if (personaAEliminar == null) {
            System.out.println("No se puede eliminar un valor nulo.");
            return;
        }
        this.raiz = eliminarRecursivo(this.raiz, personaAEliminar);
    }

    private INodo<Persona> eliminarRecursivo(INodo<Persona> INodoActual, Persona personaAEliminar) {
        if (INodoActual == null) {
            System.out.println("Elemento no encontrado para eliminar: " + personaAEliminar);
            return null;
        }
        int comparacion = compararPersonas(personaAEliminar, INodoActual.getDato()); //

        if (comparacion < 0) {
            INodoActual.setizquierda(eliminarRecursivo(INodoActual.getizquierda(), personaAEliminar));
        } else if (comparacion > 0) {
            INodoActual.setderecha(eliminarRecursivo(INodoActual.getderecha(), personaAEliminar));
        } else {
            // INodo encontrado, proceder con la eliminación
            INodo<Persona> hijoIzquierdo = INodoActual.getizquierda();
            INodo<Persona> hijoDerecho = INodoActual.getderecha();

            if (hijoIzquierdo == null && hijoDerecho == null) { // Caso 1: INodo hoja
                return null;
            }
            if (hijoIzquierdo == null) { // Caso 2: Solo hijo derecho
                return hijoDerecho;
            }
            if (hijoDerecho == null) { // Caso 2: Solo hijo izquierdo
                return hijoIzquierdo;
            }
            
            // Caso 3: INodo con dos hijos
            Persona sucesorDato = encontrarMinimo(hijoDerecho).getDato(); //
            INodoActual.setDato(sucesorDato); //
            INodoActual.setderecha(eliminarRecursivo(hijoDerecho, sucesorDato));
        }
        return INodoActual;
    }

    private INodo<Persona> encontrarMinimo(INodo<Persona> INodo) {
        INodo<Persona> actual = INodo;
        while (actual.getizquierda() != null) {
            actual = actual.getizquierda();
        }
        return actual;
    }

    // --- Métodos de Recorrido (imprimiendo en consola) ---

    @Override
    public void mostrarRecorridoEnOrden() {
        System.out.print("En Orden (" + this.criterioComparacion + "): ");
        if (estaVacio()) {
            System.out.println("Árbol vacío.");
            return;
        }
        recorridoEnOrdenRecursivo(this.raiz);
        System.out.println();
    }

    private void recorridoEnOrdenRecursivo(INodo<Persona> INodo) {
        if (INodo != null) {
            recorridoEnOrdenRecursivo(INodo.getizquierda());
            System.out.print(INodo.getDato() + " | "); //
            recorridoEnOrdenRecursivo(INodo.getderecha());
        }
    }

    @Override
    public void mostrarRecorridoPreOrden() {
        System.out.print("Pre Orden (" + this.criterioComparacion + "): ");
        if (estaVacio()) {
            System.out.println("Árbol vacío.");
            return;
        }
        recorridoPreOrdenRecursivo(this.raiz);
        System.out.println();
    }

    private void recorridoPreOrdenRecursivo(INodo<Persona> INodo) {
        if (INodo != null) {
            System.out.print(INodo.getDato() + " | "); //
            recorridoPreOrdenRecursivo(INodo.getizquierda());
            recorridoPreOrdenRecursivo(INodo.getderecha());
        }
    }

    @Override
    public void mostrarRecorridoPostOrden() {
        System.out.print("Post Orden (" + this.criterioComparacion + "): ");
        if (estaVacio()) {
            System.out.println("Árbol vacío.");
            return;
        }
        recorridoPostOrdenRecursivo(this.raiz);
        System.out.println();
    }

    private void recorridoPostOrdenRecursivo(INodo<Persona> INodo) {
        if (INodo != null) {
            recorridoPostOrdenRecursivo(INodo.getizquierda());
            recorridoPostOrdenRecursivo(INodo.getderecha());
            System.out.print(INodo.getDato() + " | "); //
        }
    }
}