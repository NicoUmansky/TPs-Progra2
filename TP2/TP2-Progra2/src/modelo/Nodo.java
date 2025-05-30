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

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public INodo<T> getderecha() {
        return derecha;
    }

    public void setderecha(Nodo<T> derecha) {
        this.derecha = derecha;
    }

    public INodo<T> getizquierda() {
        return izquierda;
    }

    public void setizquierda(INodo<T> izquierda) {
        this.izquierda = izquierda;
    }

    @Override
    public void setderecha(INodo<T> derecha) {
        this.derecha = derecha;
    }
    


}
