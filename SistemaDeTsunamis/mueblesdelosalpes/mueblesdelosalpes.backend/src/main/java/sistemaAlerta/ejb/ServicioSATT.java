/*
 * Implementacion de servicios de SATT
 */
package sistemaAlerta.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import sistemaAlerta.dto.BoletinDTO;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.entity.EscenarioPremodelado;
import sistemaAlerta.entity.Parametro;
import sistemaAlerta.entity.Sensor;
import sistemaAlerta.interfaces.IServicioSATT;
import sistemaAlerta.persistenciaMock.PersistenciaEscenariosMock;

/**
 * Servicio de SATT
 * @author sebastian
 */
@Stateless
public class ServicioSATT implements IServicioSATT{

    //Atributos del servicio
    
    /**
     * Escenarios premodelados
     */
    private PersistenciaEscenariosMock persistenciEscenarios;
    
    //Constructor
    public ServicioSATT()
    {
        persistenciEscenarios = new PersistenciaEscenariosMock();
    }
    
    
    
    /**
     * Genera un boletin de alerta dado un evento sismico, una medicion y la 
     * logica de negocio
     * @param evento
     * @param medicion
     * @return 
     */
    @Override
    public BoletinDTO generarBoletin(EventoSismicoDTO evento, Parametro medicion) 
    {
        return persistenciEscenarios.generarBoletin(evento, medicion);
    }
    
    
    
}
