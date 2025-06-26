package interfaces;

import java.util.List;

/**
 * Interfaz genérica que representa la estructura de un grafo dirigido y ponderado.
 * Permite agregar aristas y consultar la información estructural del grafo.
 *
 */
public interface IGrafo<T> {

    /**
     * Agrega una arista desde el nodo origen al nodo destino con un peso determinado.
     *
     * PRE: origen y destino deben ser nodos válidos existentes en el grafo.
     *      peso >= 0
     * POST: Se agrega una arista dirigida desde 'origen' hacia 'destino' con el peso dado.
     * AXIOMAS:
     *     - Si ya existía una arista entre origen y destino, esta se actualiza con el nuevo peso.
     *     - getAdyacentes(origen) contiene a destino tras la invocación.
     */
    void agregarArista(T origen, T destino, int peso);

    /**
     * Devuelve la lista de nodos adyacentes (destinos) al nodo dado.
     *
     * PRE: nodo es un nodo existente en el grafo.
     * POST: Se retorna una lista (posiblemente vacía) de nodos adyacentes a 'nodo'.
     * AXIOMAS:
     *     - Si no hay aristas salientes desde 'nodo', la lista devuelta está vacía.
     *     - Cada elemento en la lista corresponde a un nodo alcanzable directamente desde 'nodo'.
     */
    List<?> getAdyacentes(T nodo);

    /**
     * Devuelve la cantidad total de nodos en el grafo.
     *
     * PRE: El grafo ha sido inicializado correctamente.
     * POST: Se retorna un entero mayor o igual a 0.
     * AXIOMAS:
     *     - El valor no cambia si no se agregan o eliminan nodos.
     *     - Si se agregan nodos, el valor incrementa en consecuencia.
     */
    int getV();

    /**
     * Devuelve el nodo correspondiente a un índice específico.
     *
     * PRE: 0 <= i < getV()
     * POST: Se retorna el nodo ubicado en la posición i del grafo.
     * AXIOMAS:
     *     - getNodo(i) == getNodo(j) si y solo si i == j
     *     - Para todo i válido, getIndiceNodo(getNodo(i)) == i
     */
    T getNodo(int i);

    /**
     * Devuelve el índice asociado a un nodo específico.
     *
     * PRE: nodo es un nodo existente en el grafo.
     * POST: Se retorna un entero entre 0 y getV()-1 que representa la posición del nodo.
     * AXIOMAS:
     *     - getNodo(getIndiceNodo(n)) == n
     *     - Si n1.equals(n2), entonces getIndiceNodo(n1) == getIndiceNodo(n2)
     */
    int getIndiceNodo(T nodo);
}
