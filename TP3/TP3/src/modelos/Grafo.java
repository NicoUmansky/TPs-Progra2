package modelos;

import interfaces.IGrafo;
import interfaces.INodoGrafo;
import java.util.*;

// Clase que representa un grafo con matriz de adyacencia y nodos genéricos
// Soporta grafos dirigidos y no dirigidos 

public class Grafo<T> implements IGrafo<T> {
    private final List<INodoGrafo<T>> nodos; 
    private int[][] matrizAdyacencia; // Matriz de adyacencia - representa las conexiones 
    private boolean esDirigido;

    public Grafo(boolean esDirigido) {
        this.nodos = new ArrayList<>();
        this.matrizAdyacencia = new int[0][0];
        this.esDirigido = esDirigido;
    }

    @Override
    public void agregarNodo(T dato) {
        nodos.add(new NodoGrafo<>(dato, nodos.size()));
        expandirMatriz(); // Se actualiza la matriz para agregar una nueva fila/columna 
    }

    // Expande la matriz de adyacencia al agregar un nuevo nodo 

    private void expandirMatriz() {
        int n = nodos.size();
        int[][] nuevaMatriz = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                nuevaMatriz[i][j] = matrizAdyacencia[i][j];
            }
        }
        matrizAdyacencia = nuevaMatriz;
    }

    @Override
    public void agregarArista(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 1;
        if (!esDirigido) {
            matrizAdyacencia[destino][origen] = 1; // Si no es dirigido, también se marca la conexión inversa
        }
    }

    @Override
    public void dfs(int inicio) {
        boolean[] visitado = new boolean[nodos.size()];
        System.out.print("DFS: ");
        dfsRec(inicio, visitado);
        System.out.println();
    }
    // Función recursiva para realizar DFS 

    private void dfsRec(int actual, boolean[] visitado) {
        visitado[actual] = true;
        System.out.print(nodos.get(actual) + " ");
        for (int i = 0; i < nodos.size(); i++) {
            if (matrizAdyacencia[actual][i] == 1 && !visitado[i]) {
                dfsRec(i, visitado); // Llamada recursiva si hay conexión y aún no fue visitado
            }
        }
    }

    // Realizar recorrido en anchura (BFS) desde un nodo inicial 
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
    // Cambia la configuración del grado dirigido a no dirigido 

    public void setDirigido(boolean dirigido) {
        this.esDirigido = dirigido;
    }

    @Override
    public boolean esDirigido() {
        return esDirigido;
    }

    @Override
    public List<INodoGrafo<T>> getNodos() {
        return nodos;
    }
}
