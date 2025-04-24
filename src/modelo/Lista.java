package modelo;



//Saque la implementación implements ILista, OJO ustedes la mantienen
public class Lista  {
	
    private Nodo primero;

    public Lista() {
        this.primero = null;
    }

    
    public boolean esVacia() {
        return primero == null;
    }

    
    public void insertarPrimero(Vehiculo dato) {
        Nodo nuevo = new Nodo(dato);
    	if(!esVacia()) {
        nuevo.setSiguiente(primero);
        primero.setAnterior(nuevo); // Establecer el nodo anterior
        primero = nuevo;
    	}else {
    		primero = nuevo;
    	}
    }

    
    public void insertarUltimo(Vehiculo dato) {
        Nodo nuevo = new Nodo(dato);
        if (esVacia()) {
            primero = nuevo;
        } else {
            Nodo actual = primero;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
            nuevo.setAnterior(actual); // Establecer el nodo anterior
        }
    }

    public void insertarEnPosicion(Vehiculo dato, int posicion){
        Nodo nuevo = new Nodo(dato);
        if(primero == null){
            primero = nuevo;
        }else{
            if(posicion == 0){
                nuevo.setSiguiente(primero);
                primero = nuevo;
                primero.setAnterior(nuevo); // Establecer el nodo anterior
            }else{
                Nodo aux = primero;
                for(int i=0; i< posicion-1; i++){
                    aux = aux.getSiguiente();
                }
                nuevo.setSiguiente(aux.getSiguiente());
                // nuevo.setAnterior(aux.getAnterior()); // ESTA BIEN ASI?
                aux.setSiguiente(nuevo);
            }
        }
    }


  

   
    public Vehiculo obtenerPrimero() {
        if (esVacia()) throw new IllegalStateException("Lista vacía");
        return primero.getDato();
    }


   
    public int cantidadElementos() {
        int contador = 0;
        Nodo actual = primero;

        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }

        return contador;
    }

 
    public void mostrarLista() {
        Nodo actual = primero;
        while (actual != null) {
        	//getDato --- Del Nodo ---- Vehiculo!!!
            System.out.print(actual.getDato() +"\n");
            actual = actual.getSiguiente();
        }
        
    }
}