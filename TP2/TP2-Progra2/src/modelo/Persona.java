package modelo;

public class Persona { // Clase Persona
    private String nombere;
    private int dni;

    public Persona(String nombere, int dni) { // Constructor de la clase Persona
        this.nombere = nombere;
        this.dni = dni;
    }

    //Getters y Setters

    public String getNombere() {
        return nombere;
    }

    public void setNombere(String nombere) {
        this.nombere = nombere;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    //ToString para mostrar los datos de la persona

    @Override
    public String toString() {
        return "Persona [nombere=" + nombere + ", dni=" + dni + "]";
    }

}
