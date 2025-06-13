package modelo;

import java.util.*;

public class Dijkstra {
    public static int[] dijkstra(Grafo grafo, int origen) {
        int V = grafo.getV();
        int[] dist = new int[V];
        boolean[] visitado = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[origen] = 0;
        PriorityQueue<Nodo> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.dist));
        pq.add(new Nodo(origen, 0));

        while (!pq.isEmpty()) {
            Nodo actual = pq.poll();
            int u = actual.id;
            if (visitado[u]) continue;
            visitado[u] = true;
            for (Arista arista : grafo.getAdyacentes(u)) {
                int v = arista.destino;
                int peso = arista.peso;
                if (!visitado[v] && dist[u] + peso < dist[v]) {
                    dist[v] = dist[u] + peso;
                    pq.add(new Nodo(v, dist[v]));
                }
            }
        }
        return dist;
    }
}

class Nodo {
    int id;
    int dist;
    public Nodo(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }
}
