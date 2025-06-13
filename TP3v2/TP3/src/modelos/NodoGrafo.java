package modelos;

import interfaces.INodoGrafo;

public class NodoGrafo implements INodoGrafo {
    private Persona dato;
    private int indice;

    public NodoGrafo(Persona dato, int indice) {
        this.dato = dato;
        this.indice = indice;
    }

    @Override
    public Persona getDato() {
        return dato;
    }

    @Override
    public void setDato(Persona dato) {
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
