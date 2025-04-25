package modelo;

import interfaces.INodo;

public class Nodo implements INodo {
    // Atributos
    private Vehiculo dato;
    private INodo siguiente;
    private INodo anterior;

    // Constructores
    public Nodo(Vehiculo dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Nodo(Vehiculo dato, INodo siguiente, INodo anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    // Métodos (Getter/Setter)
    @Override
    public Vehiculo getDato() { // Cambiado para devolver un objeto Vehiculo
        return dato;
    }

    @Override
    public void setDato(Vehiculo dato) { // Cambiado para aceptar un objeto Vehiculo
        this.dato = dato;
    }

    @Override
    public INodo getSiguiente() {
        return siguiente;
    }

    @Override
    public void setSiguiente(INodo nodo) {
        this.siguiente = nodo;
    }

    @Override
    public INodo getAnterior() {
        return anterior;
    }

    @Override
    public void setAnterior(INodo anterior) {
        this.anterior = anterior;
    }


    @Override
    public String toString() {
        return "Nodo [dato=" + dato + "]"  ;
    }
}