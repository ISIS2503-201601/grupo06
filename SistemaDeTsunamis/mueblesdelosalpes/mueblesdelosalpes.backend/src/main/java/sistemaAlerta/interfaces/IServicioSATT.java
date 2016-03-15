/*
 * Servicios para la generacion de boletines y seguimiento
 */
package sistemaAlerta.interfaces;

import sistemaAlerta.dto.BoletinDTO;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.entity.EscenarioPremodelado;
import sistemaAlerta.entity.Parametro;
import sistemaAlerta.entity.Sensor;

/**
 * Conjunto de servicios para generar boletines y realizar seguimiento
 * @author sebastian
 */
public interface IServicioSATT {
    
    public BoletinDTO generarBoletin(EventoSismicoDTO evento, Sensor sensorMasCercano);
    
    public String darPerfilPreModelado(EventoSismicoDTO evento, Parametro medicion, double tiempoLlegada);
    
    public EscenarioPremodelado generarEscenario();
    
}
