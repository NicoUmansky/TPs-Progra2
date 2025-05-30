package interfaces;

import modelo.Persona;
public interface IArbolBinario {
    /**
     * PRE: El árbol ha sido creado.
     * POST: Devuelve true si el árbol no contiene nodos; false en caso contrario.
     * AXIOMA: Si estaVacio() == true, entonces raíz == null.
     */
    public boolean estaVacio();

    /**
     * PRE: persona no debe ser null.
     * POST: Inserta persona en el árbol respetando el criterio de comparación establecido.
     * AXIOMA: insertar(x); buscar(x) != null.
     */
    public void insertar(Persona persona);

    /**
     * PRE: personaClave no debe ser null.
     * POST: Devuelve una persona con el mismo dato clave si existe, null si no se encuentra.
     * AXIOMA: insertar(x); buscar(x) == x.
     */
    public Persona buscar(Persona personaClave);

    /**
    * PRE: El árbol debe tener definido un criterio de comparación ("dni" o "nombre").
    * POST: Devuelve un valor entero que indica la comparación entre p1 y p2:
    *       negativo si p1 < p2, 0 si son iguales, positivo si p1 > p2.
    * AXIOMA:
     *   - compararPersonas(null, null) == 0
     *   - compararPersonas(null, p) < 0
     *   - compararPersonas(p, null) > 0
     *   - Si criterio == "dni", compararPersonas(p1, p2) == p1.getDni() < (p2.getDni())
    *   - Si criterio == "nombre", compararPersonas(p1, p2) == p1.getnombre().compareTo(p2.getnombre())
    */
    public int compararPersonas(Persona p1, Persona p2);


    /**
     * PRE: personaAEliminar no debe ser null.
     * POST: Si existe una persona con el mismo dato clave, se elimina del árbol.
     * AXIOMA: insertar(x); eliminar(x); buscar(x) == null.
     */
    public void eliminar(Persona personaAEliminar);

    /**
     * PRE: El árbol ha sido creado.
     * POST: Imprime por consola los elementos del árbol en recorrido inorden.
     * AXIOMA: El recorrido en orden de un BST devuelve los elementos ordenados según el criterio.
     */
    public void mostrarRecorridoEnOrden();

    /**
     * PRE: El árbol ha sido creado.
     * POST: Imprime por consola los elementos del árbol en recorrido preorden.
     * AXIOMA: El primer nodo impreso es siempre la raíz.
     */
    public void mostrarRecorridoPreOrden();

    /**
     * PRE: El árbol ha sido creado.
     * POST: Imprime por consola los elementos del árbol en recorrido postorden.
     * AXIOMA: El último nodo impreso es siempre la raíz.
     */
    public void mostrarRecorridoPostOrden();
}


