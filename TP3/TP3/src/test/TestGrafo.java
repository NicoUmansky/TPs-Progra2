package test;

import modelos.Grafo;
import modelos.Persona;

public class TestGrafo {
    public static void main(String[] args) {
        System.out.println("-----PRUEBA GRAFO NO DIRIGIDO:-----");
        Grafo<Persona> grafo = new Grafo<>(false); // No dirigido
        grafo.agregarNodo(new Persona("Ana", 20));
        grafo.agregarNodo(new Persona("Luis", 22));
        grafo.agregarNodo(new Persona("Sofía", 21));
        grafo.agregarNodo(new Persona("Carlos", 25));

        grafo.agregarArista(0, 1);
        grafo.agregarArista(1, 2);
        grafo.agregarArista(3, 0);

        grafo.mostrarMatrizAdyacencia();
        grafo.dfs(0);
        grafo.bfs(0);

        System.out.println("-----PRUEBA GRAFO DIRIGIDO:-----");
        Grafo<Persona> grafo2 = new Grafo<>(true); // dirigido
        grafo2.agregarNodo(new Persona("Ana", 20));
        grafo2.agregarNodo(new Persona("Luis", 22));
        grafo2.agregarNodo(new Persona("Sofía", 21));
        grafo2.agregarNodo(new Persona("Carlos", 25));

        grafo2.agregarArista(0, 1);
        grafo2.agregarArista(1, 2);
        grafo2.agregarArista(3, 0);

        grafo2.mostrarMatrizAdyacencia();
        grafo2.dfs(3);
        grafo2.bfs(1);
    }
}
