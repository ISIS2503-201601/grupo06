/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioCarritoMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package sistemaAlerta.ejb;

import sistemaAlerta.dto.Mensaje;
import sistemaAlerta.interfaces.IServicioMensajeMockLocal;
import sistemaAlerta.interfaces.IServicioMensajeMockRemote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Implementacion de los servicios del carrito de compras en el sistema.
 * @author Juan Sebastián Urrego editado por Edgar Sandoval
 */

@Stateless
public class ServicioMensajeMock implements IServicioMensajeMockRemote, IServicioMensajeMockLocal
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    private List<Mensaje> mensajes;
    
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioMensajeMock()
    {
        mensajes = new ArrayList();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------


    /**
     * Modifica el inventario del carrito
     * @param inventario Nueva lista de muebles
     */
    @Override
    public void recibirMensaje(Mensaje mensaje)
    {
        mensajes.add(mensaje);
    }
    
    @Override
    public List<Mensaje> darMensajes()
    {
        return mensajes;
    }

    
    
}
