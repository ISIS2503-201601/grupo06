/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ AutenticacionException.java
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
 * Clase de excepción en caso de existir un error de autenticación
 * @author Juan Sebastian Urrego
 */
public class AutenticacionException extends Exception
{

    // -----------------------------------------------
    // Constructor
    // -----------------------------------------------

    /**
     * Constructor de la clase.
     * @param mensaje Mensaje de la excepción
     */
    public AutenticacionException( String mensaje ){
        super( mensaje );
    }
}
