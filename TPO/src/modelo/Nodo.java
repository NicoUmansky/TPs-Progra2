package modelo;

import interfaces.INodo;

// Implementación concreta de la interfaz INodo
// Representa un nodo que contiene un identificador único y una distancia asociada (por ejemplo, para algoritmos de caminos mínimos)
public class Nodo implements INodo {

    private int id;     // Identificador único del nodo
    private int dist;   // Distancia asociada al nodo (por ejemplo, desde el nodo origen en un algoritmo como Dijkstra)

    // Constructor: inicializa el nodo con un id y una distancia
    public Nodo(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    // Devuelve el identificador del nodo
    @Override
    public int getId() {
        return id;
    }

    // Devuelve la distancia asociada al nodo
    @Override
    public int getDist() {
        return dist;
    }

    // Establece un nuevo identificador para el nodo
    @Override
    public void setId(int id) {
        this.id = id;
    }

    // Establece una nueva distancia para el nodo
    @Override
    public void setDist(int dist) {
        this.dist = dist;
    }
}
