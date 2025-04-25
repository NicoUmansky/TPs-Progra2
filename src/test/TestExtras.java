package test;

import modelo.Persona;
import modelo.Vehiculo;

public class TestExtras {
    public static void main(String[] args) {
        Persona p1 = new Persona(12345678, "Nico Perez");
        Vehiculo v1 = new Vehiculo("ABC123", "Corolla");
		Vehiculo v2 = new Vehiculo("XYZ789","Focus");
		Vehiculo v3 = new Vehiculo("LMN456", "Onix");
		Vehiculo v4 = new Vehiculo("DEF456", "Zentorno"); 

		p1.getListaVehiculos().insertarPrimero(v1);
		p1.getListaVehiculos().insertarUltimo(v2);
		p1.getListaVehiculos().insertarEnPosicion(v3, 0); // Insertar en la posición 1
		p1.getListaVehiculos().insertarEnPosicion(v4, 1); // Insertar en la posición 1
		
        p1.getListaVehiculos().mostrarLista();

        System.out.println("\nCantidad de vehículos: " + p1.getListaVehiculos().cantidadElementos());

        System.out.println("\nLista antes de ordenar:");
        p1.getListaVehiculos().mostrarLista();

        p1.getListaVehiculos().ordenar();
        System.out.println("\nLista después de ordenar (por patente):");
        p1.getListaVehiculos().mostrarLista();

        // vaciar lista
        p1.getListaVehiculos().vaciarLista();
        System.out.println("\nDespués de vaciar la lista:");
        System.out.println("¿Está vacía?: " + p1.getListaVehiculos().esVacia());
    

    }
}
