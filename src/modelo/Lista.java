package modelo;
import interfaces.ILista;
import interfaces.INodo;

public class Lista implements ILista  {
	
    private INodo primero;
    private INodo ultimo;

    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }

    @Override
    public boolean esVacia() {
        return primero == null;
    }

    @Override
    public void insertarPrimero(Vehiculo dato) {
        INodo nuevo = new Nodo(dato);
    	if(!esVacia()) {
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo); // Establecer el nodo anterior
            primero = nuevo;
    	}else {
    		primero = nuevo;
            ultimo = nuevo; // Si la lista estaba vacía, el nuevo nodo es también el último
    	}
    }

    @Override
    public void insertarUltimo(Vehiculo dato) {
        INodo nuevo = new Nodo(dato);
        if (esVacia()) {
            primero = nuevo;
            ultimo = nuevo; // Si la lista estaba vacía, el nuevo nodo es también el último
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo); // Establecer el nodo anterior
            ultimo = nuevo; // Actualizar el último nodo
        }
    }
    @Override
    public void insertarEnPosicion(Vehiculo dato, int posicion){
       if (posicion == 0){
              insertarPrimero(dato);
        }
        else{
        INodo nuevo = new Nodo(dato);
        INodo actual = primero;
        int contador = 0;
        while (actual != null && contador < posicion - 1) {
                    actual = actual.getSiguiente();
                    contador++;
        }
        if (actual == null) {
                System.err.println("Posición fuera de rango. No se puede insertar el dato.");
                return;
        }
            nuevo.setSiguiente(actual.getSiguiente());
            if (actual.getSiguiente() != null) {
                actual.getSiguiente().setAnterior(nuevo); // Establecer el nodo anterior
            } else {
                ultimo = nuevo; // Si estamos insertando al final, actualizar el último nodo
            }
            actual.setSiguiente(nuevo);
            nuevo.setAnterior(actual); // Establecer el nodo anterior
        }
    }

    @Override
    public INodo eliminarPrimero() {
        if (!esVacia()) {
            INodo eliminado = primero;
            if (primero == ultimo) {
                primero = null;
                ultimo = null;
            } else {
                primero = primero.getSiguiente();
                primero.setAnterior(null);
            }
            eliminado.setSiguiente(null); // Desvincular el nodo eliminado
            eliminado.setAnterior(null); // Desvincular el nodo eliminado
            return eliminado;
        } else {
            System.err.println("La lista está vacía. No se puede eliminar el primer elemento.");
            return null;
        }
    }

    @Override
    public INodo eliminarUltimo() {
        if (!esVacia()) {
            INodo eliminado = ultimo;
            if (primero == ultimo) {
                primero = null;
                ultimo = null;
            } else {
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
            }
            eliminado.setAnterior(null); // Desvincular el nodo eliminado
            eliminado.setSiguiente(null); // Desvincular el nodo eliminado
            return eliminado;
        } else {
            System.err.println("La lista está vacía. No se puede eliminar el último elemento.");
            return null;
        }
    }
@Override
public INodo eliminarEnPosicion(int posicion) {
    if (esVacia()) {
        System.err.println("La lista está vacía. No se puede eliminar el elemento en la posición " + posicion + ".");
        return null;
    }
    if (posicion == 0) {
        return eliminarPrimero();
    }

    INodo actual = primero;
    int contador = 0;

    while (actual.getSiguiente() != null && contador < posicion - 1) {
        actual = actual.getSiguiente();
        contador++;
    }

    INodo eliminar = actual.getSiguiente();

    if (eliminar == null) {
        System.err.println("Posición fuera de rango. No se puede eliminar el dato en la posición " + posicion + ".");
        return null;
    }

    actual.setSiguiente(eliminar.getSiguiente());
    if (eliminar.getSiguiente() != null) {
        eliminar.getSiguiente().setAnterior(actual);
    } else {
        ultimo = actual;
    }
    eliminar.setSiguiente(null); // Desvincular el nodo eliminado
    eliminar.setAnterior(null); // Desvincular el nodo eliminado
    return eliminar;
}

    @Override
    public Vehiculo obtenerPrimero(){

        if (esVacia()) {
            System.err.println("La lista está vacía. No se puede obtener el primer elemento.");
            return null;
        }
        return primero.getDato(); // Retorna el dato del primer nodo
    }
    @Override
    public Vehiculo obtenerUltimo() {
        if (esVacia()) {
            System.err.println("La lista está vacía. No se puede obtener el último elemento.");
            return null;
        }
        return ultimo.getDato(); // Retorna el dato del último nodo
    }
    @Override
    public Vehiculo obtenerEnPosicion(int posicion) {
        if (esVacia()) {
            System.err.println("La lista está vacía. No se puede obtener el elemento en la posición " + posicion + ".");
            return null;
        }
        INodo actual = primero;
        int contador = 0;
        
        while(actual != null && contador < posicion) {
            actual = actual.getSiguiente();
            contador++;
        }
        if (actual == null) {
            System.err.println("Posición fuera de rango. No se puede obtener el dato en la posición " + posicion + ".");
            return null;
        }
        return actual.getDato(); // Retorna el dato del nodo en la posición especificada
    }
    @Override
    public int cantidadElementos() {
        int contador = 0;
        if (esVacia()) { // Si la lista está vacía, devuelve 0
            return contador;
            }
        else{
            INodo actual = primero;
            while (actual.getSiguiente() != null) { // Recorre la lista contando los nodos
                contador++;
                actual = actual.getSiguiente();
            }
            return contador + 1; // Devuelve la cantidad de nodos en la lista
        }
    }
    @Override
    public void vaciarLista() {
        primero = null;
        ultimo = null;
    } 
    @Override
    public int buscarElemento(Vehiculo dato) {
        INodo actual = primero;
        int posicion = 0;
        while (actual != null) {
            if (actual.getDato().equals(dato)) {
                return posicion; 
            }
            actual = actual.getSiguiente();
            posicion++;
        }
        return -1; // Si no se encuentra el elemento, devuelve -1
    }
    @Override   
    public void ordenar(){
        if (esVacia() || primero.getSiguiente() == null) return;
        INodo actual = primero;
        while (actual != null) {
            INodo menor = actual;
            INodo buscador = actual.getSiguiente();
            while (buscador != null) {
                if (buscador.getDato().getPatente().compareTo(menor.getDato().getPatente()) < 0) {  
                    menor = buscador;
                }
                buscador = buscador.getSiguiente();
            }
            if (menor != actual) {
                // Intercambiar los datos
                Vehiculo aux = actual.getDato();
                actual.setDato(menor.getDato());
                menor.setDato(aux);
            }
            actual = actual.getSiguiente();
            
        }
    }

    @Override
    public void mostrarLista() {
        INodo actual = primero;
        while (actual != null) {
            System.out.print(actual.getDato() + " -> ");
            actual = actual.getSiguiente();
        }
        System.out.println("Final de la lista");
    }


}