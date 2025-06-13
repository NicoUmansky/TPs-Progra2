package modelos;

import interfaces.INodoGrafo;

public class NodoGrafo<T> implements INodoGrafo<T> {
    private T dato;
    private int indice;

    public NodoGrafo(T dato, int indice) {
        this.dato = dato;
        this.indice = indice;
    }

    @Override
    public T getDato() {
        return dato;
    }

    @Override
    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public int getIndice() {
        return indice;
    }

    @Override
    public void setIndice(int indice) {
        this.indice = indice;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
}
