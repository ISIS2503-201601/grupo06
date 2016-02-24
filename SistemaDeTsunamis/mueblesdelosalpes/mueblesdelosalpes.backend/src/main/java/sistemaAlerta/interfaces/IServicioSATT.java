/*
 * Servicios para la generacion de boletines y seguimiento
 */
package sistemaAlerta.interfaces;

import sistemaAlerta.dto.BoletinDTO;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.entity.Parametro;

/**
 * Conjunto de servicios para generar boletines y realizar seguimiento
 * @author sebastian
 */
public interface IServicioSATT {
    
    /**
     * Generar boletin a partir de un evento sismico y una medicion del sensor mas cercano
     */
    public BoletinDTO generarBoletin(EventoSismicoDTO evento, Parametro medicion);
    
}
