package modelo;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import interfaces.IGrafo;
import java.util.Set;

public class VisualizadorGrafo {
    public static <T> void visualizar(IGrafo<T> grafo, Set<String> nodosDestacados) {
        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Mapa de la Ciudad");

        // Agregar nodos
        for (int i = 0; i < grafo.getV(); i++) {
            String id = grafo.getNodo(i).toString();
            Node node = graph.addNode(id);
            node.setAttribute("ui.label", id);
            if (nodosDestacados != null && nodosDestacados.contains(id)) {
                node.setAttribute("ui.class", "mejor");
            }
        }

        // Agregar aristas
        for (int i = 0; i < grafo.getV(); i++) {
            T origen = grafo.getNodo(i);
            for (Object objArista : grafo.getAdyacentes(origen)) {
                modelo.Grafo.Arista<T> arista = (modelo.Grafo.Arista<T>) objArista; //El compilador no puede garantizar que el objeto es una arista, nosotros si
                String idOrigen = origen.toString();
                String idDestino = grafo.getNodo(arista.getDestino()).toString();
                String edgeId = idOrigen + "-" + idDestino;
                if (graph.getEdge(edgeId) == null) { // Evitar duplicados
                    Edge edge = graph.addEdge(edgeId, idOrigen, idDestino, true);
                    edge.setAttribute("ui.label", arista.getPeso());
                }
            }
        }

        // Opcional: estilos
        String styleSheet =
            "node { fill-color: blue; text-size: 18; }" +
            "node.mejor { fill-color: red; }" +
            "edge { fill-color: gray; text-size: 14; }";
        graph.setAttribute("ui.stylesheet", styleSheet);
        graph.setAttribute("ui.quality");
        graph.setAttribute("ui.antialias");

        graph.display();
    }
} 