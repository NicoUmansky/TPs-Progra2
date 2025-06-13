package interfaces;

import java.util.List;

public interface IGrafo {
    void agregarArista(int origen, int destino, int peso);
    List<?> getAdyacentes(int v);
    int getV();
}
