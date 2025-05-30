package modelo;

public class Nodo <T> {
    T dato;
    Nodo<T> derecha;
    Nodo<T> izquierda;
    
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

    public Nodo<T> getderecha() {
        return derecha;
    }

    public void setderecha(Nodo<T> derecha) {
        this.derecha = derecha;
    }

    public Nodo<T> getizquierda() {
        return izquierda;
    }

    public void setizquierda(Nodo<T> izquierda) {
        this.izquierda = izquierda;
    }
    


}
