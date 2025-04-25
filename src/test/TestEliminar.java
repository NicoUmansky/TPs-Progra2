package test;

import interfaces.INodo;
import modelo.Persona;
import modelo.Vehiculo;

public class TestEliminar {
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
		// eliminar en posición intermedia
		INodo eliminado1 = p1.getListaVehiculos().eliminarEnPosicion(0);
		System.out.println("\nVehículo eliminado en posición 0:");
		if (eliminado1 != null) {
			System.out.println(eliminado1.getDato());
		}

		// eliminar primero
		INodo eliminado2 = p1.getListaVehiculos().eliminarPrimero();
		System.out.println("\nVehículo eliminado al eliminarPrimero():");
		if (eliminado2 != null) {
			System.out.println(eliminado2.getDato());
		}

		// eliminar último
		INodo eliminado3 = p1.getListaVehiculos().eliminarUltimo();
		System.out.println("\nVehículo eliminado al eliminarUltimo():");
		if (eliminado3 != null) {
			System.out.println(eliminado3.getDato());
		}

        // Mostrar la lista después de las eliminaciones
        System.out.println("\nLista de vehículos después de las eliminaciones:");
        p1.getListaVehiculos().mostrarLista();

    }
}
