package test;

import modelo.Persona;
import modelo.Vehiculo;

public class TestInsertar {
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
		
		p1.mostrarPersona();
}

}
