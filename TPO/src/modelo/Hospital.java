package modelo;

import interfaces.IHospital;

// Clase que representa un hospital concreto, implementando la interfaz IHospital
public class Hospital implements IHospital {
    //Agregue final a las varaibles de instancia para indicar que no cambiarán después de la inicialización
    private final int id;             // Identificador único del hospital
    private final String nombre;      // Nombre del hospital
    private final String direccion;   // Dirección física del hospital

    // Constructor: inicializa un hospital con su id, nombre y dirección
    public Hospital(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    // Devuelve el identificador único del hospital
    @Override
    public int getId() {
        return id;
    }

    // Devuelve el nombre del hospital
    @Override
    public String getNombre() {
        return nombre;
    }

    // Devuelve la dirección del hospital
    @Override
    public String getDireccion() {
        return direccion;
    }
}
