package interfaces;

import java.util.List;

public interface IGrafo<T> {
    void agregarArista(T origen, T destino, int peso);
    List<?> getAdyacentes(T nodo);
    int getV();
    T getNodo(int i);
    int getIndiceNodo(T nodo);
}
