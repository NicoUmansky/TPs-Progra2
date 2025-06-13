package interfaces;

import modelos.Persona;
import java.util.List;

public interface IGrafo {
    void agregarNodo(Persona persona);
    void agregarArista(int origen, int destino);
    void dfs(int inicio);
    void bfs(int inicio);
    void mostrarMatrizAdyacencia();
    boolean esDirigido();
    List<INodoGrafo> getNodos();
}
