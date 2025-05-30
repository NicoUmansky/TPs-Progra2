package test;

import modelo.Persona;
import modelo.Vehiculo;

public class TestObtener {


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
            // obtener primero
            System.out.println("\nPrimer vehículo: " + p1.getListaVehiculos().obtenerPrimero());

            // obtener último
            System.out.println("Ultimo vehículo: " + p1.getListaVehiculos().obtenerUltimo());

            // obtener en posición 1
            System.out.println("Vehículo en posición 1: " + p1.getListaVehiculos().obtenerEnPosicion(1));

            // buscar elemento
            System.out.println("¿Dónde está el Onix?: Posición " + p1.getListaVehiculos().buscarElemento(v3));

        }
}
