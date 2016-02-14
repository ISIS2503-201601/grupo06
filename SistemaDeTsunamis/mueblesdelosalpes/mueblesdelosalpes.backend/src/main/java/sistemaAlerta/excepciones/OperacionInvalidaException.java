/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ OperacionInvalidaException.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package sistemaAlerta.excepciones;

/**
 * Clase de excepción que se presenta cuando se viola alguna restricción de unicidad en el modelo.
 * @author Juan Sebastian Urrego
 */
public class OperacionInvalidaException extends Exception
{

    // -----------------------------------------------
    // Constructor
    // -----------------------------------------------

    /**
     * Constructor de la clase.
     * @param mensaje Mensaje de la excepción
     */
    public OperacionInvalidaException( String mensaje )
    {
        super( mensaje );
    }
}
