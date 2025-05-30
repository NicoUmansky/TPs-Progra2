package modelo; 
import interfaces.INodo;

public class Nodo<T> implements INodo<T> {
    T dato;
    INodo<T> derecha;
    INodo<T> izquierda;
    
    public Nodo(T dato) { // Constructor que inicializa el nodo con un dato
        this.dato = dato;
        this.derecha = null;
        this.izquierda = null;
    }
    //Getters y Setters
    @Override
    public T getDato() {
        return dato;
    }
    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }
    @Override
    public INodo<T> getderecha() {
        return derecha;
    }
    
    @Override
    public INodo<T> getizquierda() {
        return izquierda;
    }
    @Override
    public void setizquierda(INodo<T> izquierda) {
        this.izquierda = izquierda;
    }

    @Override
    public void setderecha(INodo<T> derecha) {
        this.derecha = derecha;
    }
    


}
