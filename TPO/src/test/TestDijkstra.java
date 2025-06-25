package test;

import interfaces.IAlgoritmoCaminoMinimo;
import interfaces.IGrafo;
import interfaces.IHospital;
import java.util.*;
import modelo.Dijkstra;
import modelo.Grafo;
import modelo.Hospital;

public class TestDijkstra {
    public static void main(String[] args) {
        Random rand = new Random();
        // Definir los nodos de la ciudad
        List<String> ubicaciones = Arrays.asList(
            "BaseAmbulancia",
            "Interseccion1",
            "Interseccion2",
            "Interseccion3",
            "Hospital1",
            "Hospital2",
            "Hospital3",
            "Hospital4",
            "Plaza",
            "Escuela",
            "Hospital5"
        );
        IGrafo<String> mapaCiudad = new Grafo<>(ubicaciones);
        // Aristas principales con pesos aleatorios
        mapaCiudad.agregarArista("BaseAmbulancia", "Interseccion1", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("BaseAmbulancia", "Escuela", rand.nextInt(15) + 1);

        // mapaCiudad.agregarArista("BaseAmbulancia", "Hospital1", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Interseccion1", "Interseccion2", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Interseccion1", "Hospital1", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Interseccion2", "Interseccion3", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Interseccion3", "BaseAmbulancia", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Interseccion3", "Interseccion2", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Hospital1", "Interseccion1", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Hospital1", "Interseccion2", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Hospital1", "Interseccion3", rand.nextInt(15) + 1);
        //mapaCiudad.agregarArista("BaseAmbulancia", "Hospital2", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Interseccion2", "Hospital2", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Interseccion1", "Hospital3", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Interseccion3", "Hospital3", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Hospital3", "Plaza", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Plaza", "Hospital4", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Hospital4", "Escuela", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Escuela", "Hospital2", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Hospital4", "Interseccion2", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Plaza", "Interseccion1", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Escuela", "Interseccion3", rand.nextInt(15) + 1);
        mapaCiudad.agregarArista("Hospital4", "Hospital5", rand.nextInt(15) + 1);

        // Registrar hospitales fuera del grafo
        List<IHospital> hospitales = Arrays.asList(
            new Hospital(mapaCiudad.getIndiceNodo("Hospital1"), "Clinica Zabala", "Cabildo y Zabala"),
            new Hospital(mapaCiudad.getIndiceNodo("Hospital2"), "Los Arcos", "Juan B. Justo y Paraguay"),
            new Hospital(mapaCiudad.getIndiceNodo("Hospital3"), "Fernandez", "Cerviño y Bulnes"),
            new Hospital(mapaCiudad.getIndiceNodo("Hospital4"), "Garrahan", "Pichincha y Brasil"),
            new Hospital(mapaCiudad.getIndiceNodo("Hospital5"), "Mater Dei", "Castex y Salguero")
        );

        String baseAmbulancia = "BaseAmbulancia";
        IAlgoritmoCaminoMinimo<String> algoritmo = new Dijkstra<>();
        int[] distancias = algoritmo.calcularCaminosMinimos(mapaCiudad, baseAmbulancia);
        System.out.println("Distancias mínimas desde la base de ambulancia (" + baseAmbulancia + "):");
        for (int i = 0; i < distancias.length; i++) {
            System.out.println("A ubicación " + mapaCiudad.getNodo(i) + ": " + distancias[i]);
        }

        // Calcular caminos mínimos y predecesores
        Dijkstra.ResultadoDijkstra<String> resultado = ((Dijkstra<String>) algoritmo).calcularTodo(mapaCiudad, baseAmbulancia);

        // Mostrar el mejor recorrido y la distancia mínima para llegar a cada hospital
        System.out.println("\nRecorrido y distancia mínima desde la base de ambulancia a cada hospital:");
        for (IHospital h : hospitales) {
            List<String> camino = resultado.reconstruirCamino(mapaCiudad.getNodo(h.getId()));
            if (camino.isEmpty()) {
                System.out.println("No hay camino a " + h.getNombre() + " (" + h.getDireccion() + ")");
            } else {
                System.out.println("- " + mapaCiudad.getNodo(h.getId()) + ": " + h.getNombre() + " (" + h.getDireccion() + "):");
                // Imprimir el recorrido con los pesos de las aristas
                StringBuilder recorridoConPesos = new StringBuilder();
                for (int i = 0; i < camino.size() - 1; i++) {
                    String origen = camino.get(i);
                    String destino = camino.get(i + 1);
                    int peso = -1;
                    // Buscar el peso de la arista origen -> destino
                    for (Object objArista : mapaCiudad.getAdyacentes(origen)) {
                        Grafo.Arista<String> arista = (Grafo.Arista<String>) objArista;
                        if (mapaCiudad.getNodo(arista.destino).equals(destino)) {
                            peso = arista.peso;
                            break;
                        }
                    }
                    recorridoConPesos.append(origen).append(" --").append(peso).append("--> ");
                }
                recorridoConPesos.append(camino.get(camino.size() - 1));
                System.out.println("  Recorrido: " + recorridoConPesos);
                System.out.println("  Distancia mínima: " + resultado.distancias[h.getId()]);
            }
        }

        // Buscar el hospital más cercano
        IHospital hospitalCercano = null;
        int minDist = Integer.MAX_VALUE;
        for (IHospital h : hospitales) {
            if (distancias[h.getId()] < minDist) {
                minDist = distancias[h.getId()];
                hospitalCercano = h;
            }
        }
        if (hospitalCercano != null) {
            System.out.println("\nLa ambulancia debe ir al hospital más cercano:");
            System.out.println("Nombre: " + hospitalCercano.getNombre());
            System.out.println("Dirección: " + hospitalCercano.getDireccion());
            System.out.println("Ubicación (nodo): " + mapaCiudad.getNodo(hospitalCercano.getId()));
            System.out.println("Distancia mínima desde la base: " + distancias[hospitalCercano.getId()]);
        } else {
            System.out.println("\nNo hay hospitales registrados en el grafo.");
        }


        
    }
}
