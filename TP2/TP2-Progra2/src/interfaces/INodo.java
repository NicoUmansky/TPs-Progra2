package interfaces;
public interface INodo<T> {


    /**
     * PRE: El nodo ha sido creado.
     * POST: Devuelve el dato almacenado en el nodo.
     * AXIOMA: getDato() == dato almacenado en el nodo.
     */
    public T getDato();

    /**
     * PRE: El nodo ha sido creado. El parámetro 'dato' no debe ser null si se requiere consistencia de datos.
     * POST: El valor del dato almacenado en el nodo se actualiza al nuevo valor.
     * AXIOMA: setDato(x); getDato() == x.
     */
    public void setDato(T dato);

    /**
     * PRE: El nodo ha sido creado.
     * POST: Devuelve una referencia al nodo que está a la derecha (siguiente).
     * AXIOMA: getderecha() == nodo apuntado como siguiente (puede ser null).
     */
    public INodo<T> getderecha();

    /**
     * PRE: El nodo ha sido creado. Puede recibir null como parámetro.
     * POST: Actualiza la referencia al nodo que está a la derecha (siguiente).
     * AXIOMA: setderecha(n); getderecha() == n.
     */
    public void setderecha(INodo<T> derecha);

    /**
     * PRE: El nodo ha sido creado.
     * POST: Devuelve una referencia al nodo que está a la izquierda (anterior).
     * AXIOMA: getizquierda() == nodo apuntado como anterior (puede ser null).
     */
    public INodo<T> getizquierda();

    /**
     * PRE: El nodo ha sido creado. Puede recibir null como parámetro.
     * POST: Actualiza la referencia al nodo que está a la izquierda (anterior).
     * AXIOMA: setizquierda(n); getizquierda() == n.
     */
    public void setizquierda(INodo<T> izquierda);
}