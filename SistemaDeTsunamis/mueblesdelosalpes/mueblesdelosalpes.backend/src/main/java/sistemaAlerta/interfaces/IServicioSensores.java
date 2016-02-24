/*
 * Servicios para el manejo de sensores y sus mediciones
 */
package sistemaAlerta.interfaces;

import java.util.List;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.dto.ParametroDTO;
import sistemaAlerta.entity.Parametro;

/**
 * Servicios de sensores
 * @author sebastian
 */
public interface IServicioSensores {
    
    /**
     * Agregar medida de sensor
     */
    public boolean agregarMedidaSensor(ParametroDTO medida);
    
    /**
     * Retorna todas las medidas de los sensores
     */
    public List<ParametroDTO> darMedidas();
    
    /**
     * Retorna la medicion del sensor mas cercano dado un evento sismico
     */
    public Parametro darMedicionSensorMasCercano(EventoSismicoDTO evento);
    
}
