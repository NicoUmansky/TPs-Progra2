package interfaces;

/**
 * Interfaz que representa el comportamiento abstracto de un hospital.
 * Proporciona métodos para acceder a su identificador, nombre y dirección.
 */
public interface IHospital {

    /**
     * Devuelve el identificador único del hospital.
     * 
     * PRE: El hospital ha sido correctamente inicializado.
     * POST: Se retorna un número entero que representa el identificador único del hospital.
     * AXIOMAS: 
     *     - getId() != getId() de otro hospital si son hospitales distintos.
     *     - getId() == getId() si es el mismo hospital.
     */
    int getId();

    /**
     * Devuelve el nombre del hospital.
     * 
     * PRE: El hospital ha sido correctamente inicializado.
     * POST: Se retorna una cadena no nula que representa el nombre del hospital.
     * AXIOMAS:
     *     - getNombre().length() > 0
     *     - getNombre() == getNombre() si el hospital no ha cambiado su nombre.
     */
    String getNombre();

    /**
     * Devuelve la dirección del hospital.
     * 
     * PRE: El hospital ha sido correctamente inicializado.
     * POST: Se retorna una cadena no nula que representa la dirección física del hospital.
     * AXIOMAS:
     *     - getDireccion().length() > 0
     *     - getDireccion() == getDireccion() si no ha cambiado la ubicación del hospital.
     */
    String getDireccion();
}
