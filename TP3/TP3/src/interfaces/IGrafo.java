package interfaces;

import java.util.List;

public interface IGrafo<T> {
    void agregarNodo(T dato);
    void agregarArista(int origen, int destino);
    void dfs(int inicio);
    void bfs(int inicio);
    void mostrarMatrizAdyacencia();
    boolean esDirigido();
    List<INodoGrafo<T>> getNodos();
}
