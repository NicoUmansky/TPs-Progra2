package modelo;

import interfaces.IHospital;

public class Hospital implements IHospital {
    private int id;
    private String nombre;
    private String direccion;

    public Hospital(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }
} 