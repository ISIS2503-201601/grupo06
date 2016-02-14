/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ IServicioCatalogoMockLocal.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package sistemaAlerta.interfaces;


import java.util.ArrayList;
import sistemaAlerta.dto.Mensaje;
import java.util.List;
import javax.ejb.Local;
import sistemaAlerta.dto.EventoSismico;

/**
 * Contrato funcional de los servicios que se le prestan al catálogo
 * @author Juan Sebastián Urrego
 */
@Local
public interface IServicioEventoSismicoMockLocal
{

    /**
     * Agrega un mueble al sistema
     * @param mueble Nuevo mueble
     */
    public void recibirEvento(EventoSismico evento);

    public List<EventoSismico> darEventos();


}
