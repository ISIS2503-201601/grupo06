/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.interfaces;

import java.util.List;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.dto.ParametroDTO;

/**
 *
 * @author sebastian
 */
public interface IServicioSATT {
    
    /**
     * Agregar medicion de un sensor
     */
    public boolean agregarMedicionSensor(ParametroDTO medicion);
    
    /**
     * Retorna las mediciones de los sensores
     */
    public List<ParametroDTO> darMediciones();
    
    /**
     * Agrega un evento sismico
     */
    public boolean agregarEventoSismico(EventoSismicoDTO evento);
    
    /**
     * Retorna los eventos sismicos
     */
    public  List<EventoSismicoDTO> darEventosSismicos();
    
  
    
}
