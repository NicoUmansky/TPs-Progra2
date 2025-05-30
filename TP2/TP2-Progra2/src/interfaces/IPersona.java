package interfaces;
public interface IPersona {

    /**
     * PRE: La persona ha sido creada.
     * POST: Devuelve el nombre actual de la persona.
     * AXIOMA: getNombre() == nombre actual almacenado.
     */
    public String getNombre();

    /**
     * PRE: La persona ha sido creada. El parámetro 'nombre' no debe ser null.
     * POST: El nombre de la persona se actualiza al valor dado.
     * AXIOMA: setNombre(x); getNombre() == x.
     */
    public void setNombre(String nombre);

    /**
     * PRE: La persona ha sido creada.
     * POST: Devuelve el DNI actual de la persona.
     * AXIOMA: getDni() == DNI actual almacenado.
     */
    public int getDni();

    /**
     * PRE: La persona ha sido creada. El parámetro 'dni' no debe ser null.
     * POST: El DNI de la persona se actualiza al valor dado.
     * AXIOMA: setDni(x); getDni() == x.
     */
    public void setDni(int dni);

    /**
     * PRE: La persona ha sido creada.
     * POST: Devuelve una representación en texto de la persona (por ejemplo, nombre y DNI).
     * AXIOMA: toString() == representación textual coherente con el estado actual (por ejemplo: "Nombre: Juan, DNI: 12345678").
     */
    @Override
    public String toString();

}




