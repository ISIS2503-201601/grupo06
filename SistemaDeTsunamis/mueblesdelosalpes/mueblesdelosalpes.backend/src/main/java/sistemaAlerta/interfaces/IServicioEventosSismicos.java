/*
 * Servicios para manejar eventos sismicos
 */
package sistemaAlerta.interfaces;

import java.util.List;
import sistemaAlerta.dto.EventoSismicoDTO;

/**
 * Conjunto de servicios para manejar eventos sismicos
 * @author sebastian
 */
public interface IServicioEventosSismicos {
    
    /**
     * Agrega un evento sismico
     */
    public boolean agregarEventoSismico(EventoSismicoDTO evento);
    
    /**
     * Retorna todos los eventos sismicos
     */
    public List<EventoSismicoDTO> darEventosSismicos();
    
}
