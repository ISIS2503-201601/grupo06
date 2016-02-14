/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ Mueble.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package sistemaAlerta.dto;

/**
 * Clase que representa la información de un mueble en el sistema
 * @author Juan Sebastián Urrego
 */
public class EventoSismico
{

    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------

    /**
     * Referencia que identifica el modelo del mueble en el sistema.
     */
    private long id;

    /**
     * Nombre del mueble.
     */
    private double latitud;

    /**
     * Descripción del mueble.
     */
    private double longitud;

    /**
     * Tipo de mueble.
     */
    private double distancia;


    
    //-----------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------

    /**
     * Constructor sin argumentos de la clase
     */
    public EventoSismico() 
    {

    }

    /**
     * Constructor de la clase. Inicializa los atributos con los valores que ingresan por parametro.
     * @param referencia Referencia del mueble
     * @param nombre Nombre del mueble
     * @param descripcion Descripión del mueble
     * @param tipo Tipo de mueble
     * @param cantidad Cantidad de ejemplares
     */
    public EventoSismico(long id, double latitud, double longitud, double distancia)
    {
        this.id = id;
        this.latitud = latitud;
        this.longitud = longitud;
        this.distancia = distancia;
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------

    

    /**
     * Devuelve la referencia del mueble
     * @return referencia Referencia del mueble
     */
    public long getId()
    {
        return id;
    }

    /**
     * Modifica la referencia del mueble
     * @param referencia Nueva referencia del mueble
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Devuelve el precio del mueble
     * @return precio Precio del mueble
     */
    public double getLongitud()
    {
        return longitud;
    }

    /**
     * Modifica el precio del mueble
     * @param precio Nuevo precio del mueble
     */
    public void setLongitud(double longitud)
    {
        this.longitud = longitud;
    }
    
    /**
     * Devuelve el precio del mueble
     * @return precio Precio del mueble
     */
    public double getLatitud()
    {
        return latitud;
    }

    /**
     * Modifica el precio del mueble
     * @param precio Nuevo precio del mueble
     */
    public void setLatitud(double latitud)
    {
        this.latitud = latitud;
    }
    
    /**
     * Devuelve el precio del mueble
     * @return precio Precio del mueble
     */
    public double getDistancia()
    {
        return distancia;
    }

    /**
     * Modifica el precio del mueble
     * @param precio Nuevo precio del mueble
     */
    public void setDistancia(double distancia)
    {
        this.distancia = distancia;
    }

}
