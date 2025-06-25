package modelo;

import interfaces.IAlgoritmoCaminoMinimo;
import interfaces.IGrafo;
import java.util.*;

// Algoritmo para encontrar caminos mínimos para ambulancias
public class Dijkstra<T> implements IAlgoritmoCaminoMinimo<T> {
    public static class ResultadoDijkstra<T> {
        public int[] distancias;
        public int[] predecesores;
        public IGrafo<T> grafo;
        public T origen;
        public ResultadoDijkstra(int[] distancias, int[] predecesores, IGrafo<T> grafo, T origen) {
            this.distancias = distancias;
            this.predecesores = predecesores;
            this.grafo = grafo;
            this.origen = origen;
        }
        // Devuelve el camino óptimo desde el origen hasta el destino
        public List<T> reconstruirCamino(T destino) {
            List<T> camino = new ArrayList<>();
            int idx = grafo.getIndiceNodo(destino);
            if (distancias[idx] == Integer.MAX_VALUE) return camino; // No hay camino
            while (idx != -1) {
                camino.add(grafo.getNodo(idx));
                idx = predecesores[idx];
            }
            Collections.reverse(camino);
            return camino;
        }
    }

    public ResultadoDijkstra<T> calcularTodo(IGrafo<T> grafo, T origen) {
        int V = grafo.getV();
        int[] dist = new int[V];
        int[] prev = new int[V];
        boolean[] visitado = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        int idxOrigen = grafo.getIndiceNodo(origen);
        dist[idxOrigen] = 0;
        PriorityQueue<Nodo> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        pq.add(new Nodo(idxOrigen, 0));

        while (!pq.isEmpty()) {
            Nodo actual = pq.poll();
            int u = actual.id;
            if (visitado[u]) continue;
            visitado[u] = true;
            for (Object objArista : grafo.getAdyacentes(grafo.getNodo(u))) {
                Grafo.Arista<T> arista = (Grafo.Arista<T>) objArista;
                int v = arista.destino;
                int peso = arista.peso;
                if (!visitado[v] && dist[u] + peso < dist[v]) {
                    dist[v] = dist[u] + peso;
                    prev[v] = u;
                    pq.add(new Nodo(v, dist[v]));
                }
            }
        }
        return new ResultadoDijkstra<>(dist, prev, grafo, origen);
    }

    @Override
    public int[] calcularCaminosMinimos(IGrafo<T> grafo, T origen) {
        return calcularTodo(grafo, origen).distancias;
    }

    // Nodo para la cola de prioridad
    static class Nodo {
        int id;
        int dist;
        public Nodo(int id, int dist) {
            this.id = id;
            this.dist = dist;
        }
    }
}
