/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ IServicioCatalogoMockRemote.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package sistemaAlerta.interfaces;



import sistemaAlerta.dto.Mensaje;
import java.util.List;
import javax.ejb.Remote;


/**
 * Contrato funcional de los servicios que se le prestan al catálogo
 * @author Juan Sebastián Urrego
 */
@Remote
public interface IServicioMensajeMockRemote
{

    /**
     * Agrega un mueble al sistema
     * @param mueble Nuevo mueble
     */
    public void recibirMensaje(Mensaje mensaje);
    
    
    public List<Mensaje> darMensajes();

    
    
}
