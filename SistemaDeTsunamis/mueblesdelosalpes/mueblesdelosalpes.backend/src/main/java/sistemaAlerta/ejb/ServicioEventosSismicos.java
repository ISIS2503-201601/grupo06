/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.entity.EventoSismico;
import sistemaAlerta.interfaces.IServicioEventosSismicos;
import sistemaAlerta.persistenciaMock.PersistenciaEventosMock;

/**
 *
 * @author sebastian
 */
@Stateless
public class ServicioEventosSismicos implements IServicioEventosSismicos {
    
    @Inject private PersistenciaEventosMock persistenciaEventos;
    
    public boolean agregarEventoSismico(EventoSismicoDTO evento) {
        EventoSismico nuevo = new EventoSismico();
        nuevo.setDistanciaCosta(evento.getDistanciaCosta());
        nuevo.setLatitud(evento.getLatitud());
        nuevo.setLongitud(evento.getLongitud());
        nuevo.setZonaGeografica(evento.getZonaGeografica());
        persistenciaEventos.create(nuevo);
        return true;
    }
    
    public List<EventoSismicoDTO> darEventosSismicos() {
        List<EventoSismicoDTO> respuesta = new ArrayList<EventoSismicoDTO>();
        List<EventoSismico> eventos = persistenciaEventos.findAll();
        
        for(int i = 0; i < eventos.size(); i++)
        {
            EventoSismico evento = (EventoSismico) eventos.get(i);
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
