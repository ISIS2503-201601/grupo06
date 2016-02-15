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

import sistemaAlerta.dto.EventoSismico;
import sistemaAlerta.interfaces.IServicioMensajeMockLocal;
import sistemaAlerta.interfaces.IServicioMensajeMockRemote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sistemaAlerta.dto.BoletinAlerta;
import sistemaAlerta.dto.Mensaje;
import sistemaAlerta.interfaces.IServicioEventoSismicoMockLocal;
import sistemaAlerta.interfaces.IServicioEventoSismicoMockRemote;

/**
 * Implementacion de los servicios del carrito de compras en el sistema.
 * @author Juan Sebastián Urrego editado por Edgar Sandoval
 */

@Stateless
public class ServicioEventoSismicoMock implements IServicioEventoSismicoMockRemote, IServicioEventoSismicoMockLocal
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    //@Inject private EventoPersistence persistence;
    
    private List<EventoSismico> eventos;
    
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioEventoSismicoMock()
    {
        eventos = new ArrayList();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------


    /**
     * Modifica el inventario del carrito
     * @param inventario Nueva lista de muebles
     */
    public void recibirEvento(EventoSismico evento)
    {
        //EventoEntity entidad = new EventoEntity(evento.getId(), evento.getLatitud(), evento.getLongitud(), evento.getDistancia());
        //persistence.create(entidad);
        
        eventos.add(evento);
    }
    
    public List<EventoSismico> darEventos()
    {
        //List<EventoEntity> entidades = persistence.findAll();
        //List<EventoSismico> retorno = new ArrayList();
        //for(int i = 0; i < entidades.size(); i++)
        //{
            //EventoEntity temp = (EventoEntity) entidades.get(i);
            //EventoSismico nuevo = new EventoSismico(temp.getId(), temp.getLatitud(), temp.getLongitud(), temp.getDistancia());
            //retorno.add(nuevo);
        //}
        
        //return retorno;
        
        return eventos;
    }

    @Override
    public BoletinAlerta generarBoletin(Mensaje mensaje, EventoSismico evento) {
        
        String zona = "";
        double tiempo = 0;
        String perfil = "";
        
        //Calculo de zona costera mas cercana
        if(mensaje.getLatitud()>=0 && mensaje.getLongitud() < 80)
            zona = "Atlantico";
        else
            zona = "Pacifico";
        
        //Tiempo de llegada de la ola
        tiempo = evento.getDistancia()/mensaje.getVelocidad();
        
        /**
         * TODO: encontrar el perfil de alerta segun escenarios premodelados
         */
        perfil = "informativo";
        
        return new BoletinAlerta(1, perfil, zona, tiempo, mensaje.getAltura());
        
        
    }

    
    
}
