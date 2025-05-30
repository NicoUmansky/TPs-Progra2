package modelo;
import interfaces.IPersona;
public class Persona implements IPersona{ // Clase Persona
    private String nombere;
    private int dni;

    public Persona(String nombere, int dni) { // Constructor de la clase Persona
        this.nombere = nombere;
        this.dni = dni;
    }

    //Getters y Setters
    @Override
    public String getNombre() {
        return nombere;
    }
    @Override
    public void setNombre(String nombere) {
        this.nombere = nombere;
    }
    @Override
    public int getDni() {
        return dni;
    }
    @Override
    public void setDni(int dni) {
        this.dni = dni;
    }

    //ToString para mostrar los datos de la persona

    @Override
    public String toString() {
        return "Persona [nombere=" + nombere + ", dni=" + dni + "]";
    }

}
