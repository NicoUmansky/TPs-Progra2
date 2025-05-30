package modelo;
import interfaces.IPersona;
public class Persona implements IPersona{ // Clase Persona
    private String nombre;
    private int dni;

    public Persona(String nombre, int dni) { // Constructor de la clase Persona
        this.nombre = nombre;
        this.dni = dni;
    }

    //Getters y Setters
    @Override
    public String getNombre() {
        return nombre;
    }
    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Persona [nombre=" + nombre + ", dni=" + dni + "]";
    }

}
