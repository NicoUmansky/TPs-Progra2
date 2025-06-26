package interfaces;

/**
 * Interfaz que representa un algoritmo para calcular caminos mínimos en un grafo.
 *
 * @param <T> Tipo de dato que representa los nodos del grafo.
 */
public interface IAlgoritmoCaminoMinimo<T> {

    /**
     * Calcula los caminos mínimos desde un nodo origen a todos los demás nodos del grafo.
     *
     * PRE: 
     *   - grafo no es null.
     *   - origen pertenece al conjunto de nodos del grafo.
     *   - Todos los pesos de las aristas del grafo son mayores o iguales a 0.
     *
     * POST: 
     *   - Se retorna un arreglo de enteros de tamaño igual a grafo.getV().
     *   - Cada posición i del arreglo contiene la distancia mínima desde el nodo 'origen' 
     *     hasta el nodo grafo.getNodo(i).
     *   - Si no existe un camino desde 'origen' a un nodo i, el valor en esa posición es infinito 
     *     (usualmente representado por Integer.MAX_VALUE o similar).
     *
     * AXIOMAS:
     *   - calcularCaminosMinimos(grafo, origen)[grafo.getIndiceNodo(origen)] == 0
     *   - Si existe un camino de origen a destino, entonces 
     *       calcularCaminosMinimos(grafo, origen)[grafo.getIndiceNodo(destino)] 
     *     es el peso mínimo acumulado de ese camino.
     *   - El arreglo devuelto cumple la propiedad de optimalidad de caminos: 
     *       para cada arista (u, v) con peso p: 
     *         distancia[v] ≤ distancia[u] + p
     */
    int[] calcularCaminosMinimos(IGrafo<T> grafo, T origen);
}
