package modelo;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import interfaces.IGrafo;
import java.util.Set;

// Clase utilitaria para visualizar un grafo utilizando la librería GraphStream
public class VisualizadorGrafo {

    // Método estático genérico para visualizar un grafo y destacar ciertos nodos
    public static <T> void visualizar(IGrafo<T> grafo, Set<String> nodosDestacados) {
        System.setProperty("org.graphstream.ui", "swing"); // Configura el backend gráfico a usar (Swing)

        Graph graph = new SingleGraph("Mapa de la Ciudad"); // Crea un nuevo grafo visual con un nombre

        // Agregar nodos al grafo visual
        for (int i = 0; i < grafo.getV(); i++) {
            String id = grafo.getNodo(i).toString(); // Se usa la representación string del nodo como ID
            Node node = graph.addNode(id); // Agrega el nodo al grafo visual
            node.setAttribute("ui.label", id); // Muestra el ID como etiqueta visible

            // Si el nodo está en el conjunto de nodos destacados, se le asigna una clase CSS especial
            if (nodosDestacados != null && nodosDestacados.contains(id)) {
                node.setAttribute("ui.class", "mejor"); // Clase 'mejor' usada en el stylesheet
            }
        }

        // Agregar aristas (edges) al grafo visual
        for (int i = 0; i < grafo.getV(); i++) {
            T origen = grafo.getNodo(i);
            for (Object objArista : grafo.getAdyacentes(origen)) {
                // Cast explícito necesario: sabemos que el objeto es una arista de tipo Grafo.Arista<T>
                modelo.Grafo.Arista<T> arista = (modelo.Grafo.Arista<T>) objArista;

                String idOrigen = origen.toString();
                String idDestino = grafo.getNodo(arista.getDestino()).toString();
                String edgeId = idOrigen + "-" + idDestino; // ID único para la arista

                // Solo se agrega la arista si aún no fue agregada (evita duplicados visuales)
                if (graph.getEdge(edgeId) == null) {
                    Edge edge = graph.addEdge(edgeId, idOrigen, idDestino, true); // true indica que la arista es dirigida
                    edge.setAttribute("ui.label", arista.getPeso()); // Muestra el peso como etiqueta de la arista
                }
            }
        }

        // Definición de estilos CSS para nodos y aristas
        String styleSheet =
            "node { fill-color: blue; text-size: 18; }" +    // Nodos normales en azul
            "node.mejor { fill-color: red; }" +              // Nodos destacados en rojo
            "edge { fill-color: gray; text-size: 14; }";     // Aristas en gris con tamaño de texto

        // Aplicar estilos y configuraciones visuales
        graph.setAttribute("ui.stylesheet", styleSheet); // Aplica la hoja de estilos
        graph.setAttribute("ui.quality");                 // Mejora visual
        graph.setAttribute("ui.antialias");               // Suavizado de bordes

        // Mostrar el grafo visualmente en una ventana
        graph.display();
    }
}
