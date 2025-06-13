package interfaces;

import modelos.Persona;

public interface INodoGrafo {
    Persona getDato();
    void setDato(Persona dato);
    int getIndice();
    void setIndice(int indice);
}
