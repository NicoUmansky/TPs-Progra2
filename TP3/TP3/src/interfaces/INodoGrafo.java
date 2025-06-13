package interfaces;

/**
 * Interfaz que representa un nodo dentro de un grafo.
 */
public interface INodoGrafo<T> {

    /**
     * Pre: - (no tiene precondiciones).
     * Post: Devuelve el dato almacenado en el nodo.
     * Axioma: Si setDato(x) fue llamado previamente, entonces getDato() == x.
     */
    T getDato();

    /**
     * Pre: dato ≠ null.
     * Post: El dato almacenado en el nodo se actualiza al valor de 'dato'.
     * Axioma: Después de setDato(x), getDato() == x.
     */
    void setDato(T dato);

    /**
     * Pre: - (no tiene precondiciones).
     * Post: Devuelve el índice asociado al nodo.
     * Axioma: Si setIndice(i) fue llamado previamente, entonces getIndice() == i.
     */
    int getIndice();

    /**
     * Pre: indice ≥ 0.
     * Post: El índice del nodo se actualiza al valor de 'indice'.
     * Axioma: Después de setIndice(i), getIndice() == i.
     */
    void setIndice(int indice);
}
