package interfaces;

import java.util.List;

/**
 * Interfaz para representar un grafo genérico.
 */
public interface IGrafo<T> {

    /**
     * Pre: dato ≠ null.
     * Post: Se agrega un nuevo nodo con el dato proporcionado al grafo.
     * Axioma: getNodos().contains(nodo) ⇐⇒ nodo.dato == dato después de agregar.
     */
    void agregarNodo(T dato);

    /**
     * Pre: 0 ≤ origen < getNodos().size() ∧ 0 ≤ destino < getNodos().size().
     * Post: Se crea una arista desde el nodo en posición 'origen' al nodo en posición 'destino'.
     * Axioma: mostrarMatrizAdyacencia() muestra un 1 (o valor positivo) en [origen][destino].
     */
    void agregarArista(int origen, int destino);

    /**
     * Pre: 0 ≤ inicio < getNodos().size().
     * Post: Se recorre el grafo en profundidad (DFS) comenzando desde el nodo en 'inicio'.
     * Axioma: Todos los nodos alcanzables desde 'inicio' son visitados una única vez.
     */
    void dfs(int inicio);

    /**
     * Pre: 0 ≤ inicio < getNodos().size().
     * Post: Se recorre el grafo en anchura (BFS) comenzando desde el nodo en 'inicio'.
     * Axioma: Todos los nodos alcanzables desde 'inicio' son visitados por niveles (mínima distancia).
     */
    void bfs(int inicio);

    /**
     * Pre: - (no tiene precondiciones).
     * Post: Se imprime la matriz de adyacencia del grafo.
     * Axioma: matriz[i][j] ≠ 0 ⇐⇒ existe una arista desde el nodo i al nodo j.
     */
    void mostrarMatrizAdyacencia();

    /**
     * Pre: - (no tiene precondiciones).
     * Post: Se devuelve true si el grafo es dirigido, false en caso contrario.
     * Axioma: esDirigido() ⇐⇒ ∃ i,j : matriz[i][j] ≠ matriz[j][i].
     */
    boolean esDirigido();

    /**
     * Pre: - (no tiene precondiciones).
     * Post: Devuelve la lista de nodos actuales del grafo.
     * Axioma: getNodos().size() == número de llamadas válidas a agregarNodo().
     */
    List<INodoGrafo<T>> getNodos();
}
