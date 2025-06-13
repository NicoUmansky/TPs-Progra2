package modelo;

import java.util.*;

public class Grafo {
    private int V; // Número de vértices
    private List<List<Arista>> adj;

    public Grafo(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int peso) {
        adj.get(origen).add(new Arista(destino, peso));
        // Si es no dirigido, descomentar la siguiente línea:
        // adj.get(destino).add(new Arista(origen, peso));
    }

    public List<Arista> getAdyacentes(int v) {
        return adj.get(v);
    }

    public int getV() {
        return V;
    }
}

class Arista {
    int destino;
    int peso;
    public Arista(int destino, int peso) {
        this.destino = destino;
        this.peso = peso;
    }
}
