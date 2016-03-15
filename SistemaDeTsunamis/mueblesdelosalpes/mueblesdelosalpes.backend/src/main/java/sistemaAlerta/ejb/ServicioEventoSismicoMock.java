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


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sistemaAlerta.dto.BoletinAlerta;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.dto.Mensaje;
import sistemaAlerta.entity.Boletin;
import sistemaAlerta.entity.EventoSismico;
import sistemaAlerta.interfaces.IServicioEventoSismicoMockLocal;
import sistemaAlerta.interfaces.IServicioEventoSismicoMockRemote;
import sistemaAlerta.persistenciaMock.PersistenciaBoletinesMock;
import sistemaAlerta.persistenciaMock.PersistenciaEventosMock;

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
    
    @Inject private PersistenciaEventosMock persistenciaEventos;
    
    @Inject private PersistenciaBoletinesMock persistenciaBoletines;
    
    
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioEventoSismicoMock()
    {
        
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------


    /**
     * Modifica el inventario del carrito
     * @param inventario Nueva lista de muebles
     */
    public void recibirEvento(EventoSismicoDTO evento)
    {
        EventoSismico entidad = new EventoSismico();
        entidad.setDistanciaCosta(evento.getDistanciaCosta());
        entidad.setLatitud(evento.getLatitud());
        entidad.setLongitud(evento.getLongitud());
        entidad.setZonaGeografica(evento.getZonaGeografica());
        persistenciaEventos.create(entidad);
        
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<EventoSismicoDTO> darEventos()
    {
        List<EventoSismico> entidades = persistenciaEventos.findAll();
        List<EventoSismicoDTO> retorno = new ArrayList();
        for(int i = 0; i < entidades.size(); i++)
        {
            EventoSismico temp = (EventoSismico) entidades.get(i);
            EventoSismicoDTO nuevo = new EventoSismicoDTO();
            nuevo.setId(temp.getId());
            nuevo.setDistanciaCosta(temp.getDistanciaCosta());
            nuevo.setLatitud(temp.getLatitud());
            nuevo.setLongitud(temp.getLongitud());
            
            retorno.add(nuevo);
        }
        
        return retorno;
        
    }

    @Override
    public BoletinAlerta generarBoletin(Mensaje mensaje, EventoSismicoDTO evento) {
        
        String zona = "";
        double tiempo = 0;
        String perfil = "";
        
        //Calculo de zona costera mas cercana
        if(mensaje.getLatitud()>=0 && mensaje.getLongitud() < 80)
            zona = "Atlantico";
        else
            zona = "Pacifico";
        
        //Tiempo de llegada de la ola
        tiempo = evento.getDistanciaCosta()/mensaje.getVelocidad();
        
        /**
         * TODO: encontrar el perfil de alerta segun escenarios premodelados
         */
        perfil = "informativo";
        Boletin boletin = new Boletin();
        boletin.setAltura(mensaje.getAltura());
        boletin.setPerfil(perfil);
        boletin.setZonaGeografica(zona);
        boletin.setTiempoLlegada(tiempo);
        persistenciaBoletines.create(boletin);
        return new BoletinAlerta(1, perfil, zona, tiempo, mensaje.getAltura());
        
        
    }

    
    
}
