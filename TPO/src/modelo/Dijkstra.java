package modelo;

import interfaces.IAlgoritmoCaminoMinimo;
import interfaces.IGrafo;
import java.util.*;

// Algoritmo para encontrar caminos mínimos para ambulancias
public class Dijkstra<T> implements IAlgoritmoCaminoMinimo<T> {

    // Clase interna que encapsula los resultados del algoritmo de Dijkstra
    public static class ResultadoDijkstra<T> {
        private int[] distancias;        // Distancia mínima desde el origen a cada nodo
        private int[] predecesores;      // Nodo anterior en el camino más corto
        private IGrafo<T> grafo;         // Referencia al grafo sobre el cual se ejecutó el algoritmo
        private T origen;                // Nodo origen desde el cual se calcularon las distancias

        public ResultadoDijkstra(int[] distancias, int[] predecesores, IGrafo<T> grafo, T origen) {
            this.distancias = distancias;
            this.predecesores = predecesores;
            this.grafo = grafo;
            this.origen = origen;
        }

        // Métodos getter para acceder a los datos del resultado
        public int[] getDistancias() {
            return distancias;
        }

        public int[] getPredecesores() {
            return predecesores;
        }

        public IGrafo<T> getGrafo() {
            return grafo;
        }

        public T getOrigen() {
            return origen;
        }

        // Devuelve el camino óptimo desde el nodo origen hasta el nodo destino
        public List<T> reconstruirCamino(T destino) {
            List<T> camino = new ArrayList<>();
            int idx = grafo.getIndiceNodo(destino);

            // Si la distancia es infinita, no hay camino
            if (distancias[idx] == Integer.MAX_VALUE) return camino;

            // Reconstrucción del camino hacia atrás usando el arreglo de predecesores
            while (idx != -1) {
                camino.add(grafo.getNodo(idx));
                idx = predecesores[idx];
            }

            // El camino se reconstruyó al revés, se invierte antes de devolverlo
            Collections.reverse(camino);
            return camino;
        }
    }

    // Ejecuta el algoritmo de Dijkstra desde un nodo origen y retorna todos los resultados
    public ResultadoDijkstra<T> calcularTodo(IGrafo<T> grafo, T origen) {
        int V = grafo.getV();                      // Cantidad de nodos
        int[] dist = new int[V];                   // Distancias mínimas desde el origen
        int[] prev = new int[V];                   // Predecesores en el camino
        boolean[] visitado = new boolean[V];       // Marca los nodos ya procesados

        Arrays.fill(dist, Integer.MAX_VALUE);      // Inicializar todas las distancias a infinito
        Arrays.fill(prev, -1);                     // Sin predecesores conocidos al inicio

        int idxOrigen = grafo.getIndiceNodo(origen);  // Obtener índice del nodo origen
        dist[idxOrigen] = 0;                           // Distancia del origen a sí mismo es 0

        // Cola de prioridad para seleccionar el nodo con menor distancia estimada
        PriorityQueue<Nodo> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.getDist()));
        pq.add(new Nodo(idxOrigen, 0));

        // Bucle principal de Dijkstra
        while (!pq.isEmpty()) {
            Nodo actual = pq.poll();
            int u = actual.getId();

            if (visitado[u]) continue;             // Saltar si el nodo ya fue visitado
            visitado[u] = true;

            // Procesar todas las aristas salientes del nodo actual
            for (Object objArista : grafo.getAdyacentes(grafo.getNodo(u))) {
                @SuppressWarnings("unchecked") //El compilador no puede garantizar que el objeto es una arista
                // Cast seguro ya que sabemos que las adyacentes son de tipo Arista<T>, por eso suprimimos la advertencia
                /// REVISAR: Podemos mejorarlo, cambiando la declaración y el retorno de getAdyacentes para que sea genérico
                Grafo.Arista<T> arista = (Grafo.Arista<T>) objArista;
                int v = arista.getDestino();
                int peso = arista.getPeso();

                // Relajación: actualizar si se encontró un camino más corto
                if (!visitado[v] && dist[u] + peso < dist[v]) {
                    dist[v] = dist[u] + peso;
                    prev[v] = u;
                    pq.add(new Nodo(v, dist[v]));  // Agregar el nodo con nueva prioridad
                }
            }
        }

        // Devolver el resultado completo
        return new ResultadoDijkstra<>(dist, prev, grafo, origen);
    }

    // Implementación del método de la interfaz: solo retorna las distancias
    @Override
    public int[] calcularCaminosMinimos(IGrafo<T> grafo, T origen) {
        return calcularTodo(grafo, origen).getDistancias();
    }
}
