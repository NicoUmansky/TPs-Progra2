package modelo;

public class Persona { // Clase Persona
    private String nombere;
    private String dni;

    public Persona(String nombere, String dni) { // Constructor de la clase Persona
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //ToString para mostrar los datos de la persona

    @Override
    public String toString() {
        return "Persona [nombere=" + nombere + ", dni=" + dni + "]";
    }

}
