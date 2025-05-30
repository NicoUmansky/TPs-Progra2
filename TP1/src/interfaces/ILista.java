package interfaces;
import modelo.Vehiculo;

public interface ILista {
    boolean esVacia();
    void insertarPrimero(Vehiculo dato);
    void insertarUltimo(Vehiculo dato);
    void insertarEnPosicion(Vehiculo dato, int posicion);
    INodo eliminarPrimero();
    INodo eliminarUltimo();
    INodo eliminarEnPosicion(int posicion);
    void mostrarLista();
    int cantidadElementos();
    void vaciarLista();
    void ordenar();
    public Vehiculo obtenerPrimero();
    public Vehiculo obtenerUltimo();
    public Vehiculo obtenerEnPosicion(int posicion);
    public int buscarElemento(Vehiculo dato) ;


    
}
