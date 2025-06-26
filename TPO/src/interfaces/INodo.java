package interfaces;

/**
 * Interfaz que representa un nodo con identificador y distancia asociada.
 * Es para representar nodos en algoritmos de grafos,
 *  en este caso Dijkstra, donde se necesita almacenar un valor de distancia mínima.
 */
public interface INodo {

    /**
     * Devuelve el identificador del nodo.
     *
     * PRE: El nodo ha sido inicializado correctamente.
     * POST: Retorna un valor entero que representa el ID único del nodo.
     * AXIOMAS:
     *     - getId() == getId() si no se invocó setId() entre ambas llamadas.
     */
    int getId();

    /**
     * Establece el identificador del nodo.
     *
     * PRE: El parámetro id debe ser un número entero válido (ej. >= 0).
     * POST: El nodo almacena el nuevo identificador proporcionado.
     * AXIOMAS:
     *     - Después de setId(x), getId() == x
     */
    void setId(int id);

    /**
     * Devuelve la distancia asociada al nodo (por ejemplo, la distancia desde un nodo origen).
     *
     * PRE: El nodo ha sido correctamente inicializado.
     * POST: Retorna un valor entero que representa la distancia almacenada.
     * AXIOMAS:
     *     - getDist() == getDist() si no se invocó setDist() entre ambas llamadas.
     */
    int getDist();

    /**
     * Establece la distancia asociada al nodo.
     *
     * PRE: El parámetro dist debe ser un número entero válido (por ejemplo, ≥ 0 si se usa en Dijkstra).
     * POST: El nodo almacena la nueva distancia proporcionada.
     * AXIOMAS:
     *     - Después de setDist(x), getDist() == x
     */
    void setDist(int dist);
}
