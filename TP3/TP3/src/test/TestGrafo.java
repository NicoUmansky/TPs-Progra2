package test;

import modelos.Grafo;
import modelos.Persona;

public class TestGrafo {
    public static void main(String[] args) {
        Grafo<Persona> grafo = new Grafo<>(3, false); // No dirigido
        grafo.agregarNodo(new Persona("Ana", 20));
        grafo.agregarNodo(new Persona("Luis", 22));
        grafo.agregarNodo(new Persona("Sofía", 21));

        grafo.agregarArista(0, 1);
        grafo.agregarArista(1, 2);

        grafo.mostrarMatrizAdyacencia();
        grafo.dfs(0);
        grafo.bfs(0);
    }
}
