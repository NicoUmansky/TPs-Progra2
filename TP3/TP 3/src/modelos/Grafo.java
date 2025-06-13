package modelos;

import interfaces.IGrafo;
import interfaces.INodoGrafo;
import java.util.*;

public class Grafo implements IGrafo {
    private List<INodoGrafo> nodos;
    private int[][] matrizAdyacencia;
    private boolean esDirigido;

    public Grafo(int cantidadNodos, boolean esDirigido) {
        this.nodos = new ArrayList<>();
        this.matrizAdyacencia = new int[cantidadNodos][cantidadNodos];
        this.esDirigido = esDirigido;
    }

    @Override
    public void agregarNodo(modelos.Persona persona) {
        nodos.add(new NodoGrafo(persona, nodos.size()));
    }

    @Override
    public void agregarArista(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 1;
        if (!esDirigido) {
            matrizAdyacencia[destino][origen] = 1;
        }
    }

    @Override
    public void dfs(int inicio) {
        boolean[] visitado = new boolean[nodos.size()];
        System.out.print("DFS: ");
        dfsRec(inicio, visitado);
        System.out.println();
    }

    private void dfsRec(int actual, boolean[] visitado) {
        visitado[actual] = true;
        System.out.print(nodos.get(actual) + " ");
        for (int i = 0; i < nodos.size(); i++) {
            if (matrizAdyacencia[actual][i] == 1 && !visitado[i]) {
                dfsRec(i, visitado);
            }
        }
    }

    @Override
    public void bfs(int inicio) {
        boolean[] visitado = new boolean[nodos.size()];
        Queue<Integer> cola = new LinkedList<>();
        visitado[inicio] = true;
        cola.add(inicio);
        System.out.print("BFS: ");
        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.print(nodos.get(actual) + " ");
            for (int i = 0; i < nodos.size(); i++) {
                if (matrizAdyacencia[actual][i] == 1 && !visitado[i]) {
                    cola.add(i);
                    visitado[i] = true;
                }
            }
        }
        System.out.println();
    }

    @Override
    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        for (int i = 0; i < nodos.size(); i++) {
            for (int j = 0; j < nodos.size(); j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setDirigido(boolean dirigido) {
        this.esDirigido = dirigido;
    }

    @Override
    public boolean esDirigido() {
        return esDirigido;
    }

    @Override
    public List<INodoGrafo> getNodos() {
        return nodos;
    }
}

/*
Para que el grafo sea dirigido, simplemente inicializa el grafo con el parámetro esDirigido=true.
El recorrido DFS y BFS funciona igual para grafos dirigidos y no dirigidos.
*/
