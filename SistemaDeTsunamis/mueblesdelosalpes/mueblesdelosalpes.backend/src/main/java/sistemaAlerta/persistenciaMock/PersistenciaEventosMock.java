/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.persistenciaMock;

import java.util.ArrayList;
import java.util.List;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.entity.EventoSismico;

/**
 *
 * @author sebastian
 */
public class PersistenciaEventosMock {
    
    /**
     * Lista de eventos
     */
    private List<EventoSismico> eventos;
    
    /**
     * Id temporal
     */
    private Long id;
    
    public PersistenciaEventosMock()
    {
        id = new Long(0);
        eventos = new ArrayList<EventoSismico>();
    }
    
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
