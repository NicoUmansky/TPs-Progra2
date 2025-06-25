package modelo;

import interfaces.IGrafo;
import java.util.*;

public class Grafo<T> implements IGrafo<T> {
    private int V; // Número de nodos
    private List<List<Arista<T>>> adj;
    private List<T> nodos;

    public Grafo(List<T> nodos) {
        this.nodos = nodos;
        this.V = nodos.size();
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    // Agrega una arista entre dos nodos de tipo T
    public void agregarArista(T origen, T destino, int peso) {
        int idxOrigen = nodos.indexOf(origen);
        int idxDestino = nodos.indexOf(destino);
        if (idxOrigen != -1 && idxDestino != -1) {
            adj.get(idxOrigen).add(new Arista<>(idxDestino, peso));
        }
    }

    // Devuelve la lista de adyacentes de un nodo de tipo T
    public List<Arista<T>> getAdyacentes(T nodo) {
        int idx = nodos.indexOf(nodo);
        if (idx != -1) {
            return adj.get(idx);
        }
        return Collections.emptyList();
    }

    // Devuelve la cantidad de nodos
    public int getV() {
        return V;
    }

    // Devuelve el nodo en la posición i
    public T getNodo(int i) {
        return nodos.get(i);
    }

    // Devuelve el índice de un nodo
    public int getIndiceNodo(T nodo) {
        return nodos.indexOf(nodo);
    }

    // Clase interna para representar una arista
    public static class Arista<T> {
        public int destino;
        public int peso;
        public Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }
}
