/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.ejb;

import java.util.ArrayList;
import java.util.List;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.entity.EventoSismico;
import sistemaAlerta.interfaces.IServicioEventosSismicos;

/**
 *
 * @author sebastian
 */
public class ServicioEventosSismicos implements IServicioEventosSismicos {
    
    //Atributos del EJB
    
    /**
     * Lista de eventos
     */
    private List<EventoSismico> eventos;
    
    /**
     * Id temporal
     */
    private Long id;
    
    //Constructor
    public ServicioEventosSismicos()
    {
        id = new Long(0);
        eventos = new ArrayList<EventoSismico>();
    }

    /**
     * agrega un nuevo evento sismico
     * @param evento
     * @return 
     */
    @Override
    public boolean agregarEventoSismico(EventoSismicoDTO evento) {
        EventoSismico nuevo = new EventoSismico();
        nuevo.setDistanciaCosta(evento.getDistanciaCosta());
        nuevo.setId(id);
        nuevo.setLatitud(evento.getLatitud());
        nuevo.setLongitud(evento.getLongitud());
        nuevo.setZonaGeografica(evento.getZonaGeografica());
        eventos.add(nuevo);
        id++;
        return true;
    }

    /**
     * Devuelve los eventos
     * @return 
     */
    @Override
    public List<EventoSismicoDTO> darEventosSismicos() {
        List<EventoSismicoDTO> respuesta = new ArrayList<EventoSismicoDTO>();
        for(EventoSismico evento : eventos)
        {
            EventoSismicoDTO e = new EventoSismicoDTO();
            e.setDistanciaCosta(evento.getDistanciaCosta());
            e.setLatitud(evento.getLatitud());
            e.setLongitud(evento.getLongitud());
            e.setZonaGeografica(evento.getZonaGeografica());
            respuesta.add(e);
        }
        return respuesta;
    }
    
}
