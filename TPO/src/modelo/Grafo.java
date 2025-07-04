package modelo;

import interfaces.IGrafo;
import java.util.*;

// Implementación concreta de un grafo dirigido y ponderado usando listas de adyacencia
public class Grafo<T> implements IGrafo<T> {
    //Agregue final a las varaibles de instancia para indicar que no cambiarán después de la inicialización
    private final int V; // Número de nodos en el grafo
    private final List<List<Arista<T>>> adj; // Lista de adyacencia que guarda las aristas salientes por nodo
    private final List<T> nodos; // Lista que guarda los nodos del grafo

    // Constructor: inicializa el grafo con una lista de nodos dada
    public Grafo(List<T> nodos) {
        this.nodos = nodos;
        this.V = nodos.size(); // La cantidad de nodos es el tamaño de la lista
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>()); // Inicializa la lista de adyacencia para cada nodo
        }
    }

    // Agrega una arista dirigida desde 'origen' hasta 'destino' con un peso dado
    @Override
    public void agregarArista(T origen, T destino, int peso) {
        int idxOrigen = nodos.indexOf(origen);   // Busca el índice del nodo origen
        int idxDestino = nodos.indexOf(destino); // Busca el índice del nodo destino
        if (idxOrigen != -1 && idxDestino != -1) {
            adj.get(idxOrigen).add(new Arista<>(idxDestino, peso)); // Agrega la arista a la lista correspondiente
        }
    }

    // Devuelve la lista de aristas salientes (adyacentes) desde el nodo dado
    @Override
    public List<Arista<T>> getAdyacentes(T nodo) {
        int idx = nodos.indexOf(nodo); // Busca el índice del nodo
        if (idx != -1) {
            return adj.get(idx); // Retorna la lista de aristas salientes
        }
        return Collections.emptyList(); // Si el nodo no existe, retorna una lista vacía
    }

    // Devuelve la cantidad total de nodos en el grafo
    @Override
    public int getV() {
        return V;
    }

    // Devuelve el nodo que se encuentra en la posición i
    @Override
    public T getNodo(int i) {
        return nodos.get(i);
    }

    // Devuelve el índice correspondiente al nodo dado
    @Override
    public int getIndiceNodo(T nodo) {
        return nodos.indexOf(nodo); // Si no existe, retorna -1
    }

    // Clase interna que representa una arista dirigida con peso
    public static class Arista<T> {
        private int destino; // Índice del nodo destino
        private int peso;    // Peso de la arista

        public Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }

        // Métodos getter para acceder a los datos de la arista
        public int getDestino() {
            return destino;
        }

        public int getPeso() {
            return peso;
        }

        public void setDestino(int destino) {
            this.destino = destino;
        }

        public void setPeso(int peso) {
            this.peso = peso;
        }

        
    }
}
