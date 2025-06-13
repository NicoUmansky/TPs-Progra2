package test;

import modelo.Dijkstra;
import modelo.Grafo;

public class TestDijkstra {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);
        grafo.agregarArista(0, 1, 10);
        grafo.agregarArista(0, 4, 5);
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(1, 4, 2);
        grafo.agregarArista(2, 3, 4);
        grafo.agregarArista(3, 0, 7);
        grafo.agregarArista(3, 2, 6);
        grafo.agregarArista(4, 1, 3);
        grafo.agregarArista(4, 2, 9);
        grafo.agregarArista(4, 3, 2);

        int origen = 0;
        int[] distancias = Dijkstra.dijkstra(grafo, origen);
        System.out.println("Distancias mínimas desde el nodo " + origen + ":");
        for (int i = 0; i < distancias.length; i++) {
            System.out.println("A nodo " + i + ": " + distancias[i]);
        }
    }
}
