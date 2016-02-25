/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.ejb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Persistence;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.dto.ParametroDTO;
import sistemaAlerta.entity.Parametro;
import sistemaAlerta.entity.Sensor;
import sistemaAlerta.interfaces.IServicioSensores;
import sistemaAlerta.persistenciaMock.PersistenciaSensoresMock;

/**
 * Servicio de sensores
 * @author sebastian
 */
@Stateless
public class ServicioSensores implements IServicioSensores {
    
    //Atributos del EJB
    
    /**
     * Sensores
     */
    private PersistenciaSensoresMock persistenciaSensores;
    
    
    //Constructor
    public ServicioSensores()
    {
        //Genera 4000 sensores nuevos
        persistenciaSensores = new PersistenciaSensoresMock();
       
    }
    

    /**
     * Agrega una nueva medida al sensor que produjo la medida
     * @param medida
     * @return 
     */
    @Override
    public boolean agregarMedidaSensor(ParametroDTO medida) {
       return persistenciaSensores.agregarMedidaSensor(medida);
    }

    /**
     * Retorna todas las medidas
     * @return 
     */
    @Override
    public List<ParametroDTO> darMedidas() {
        return persistenciaSensores.darMedidas();
    }

    /**
     * Retorna la ultima medicion del sensor mas cercano a un evento sismico
     * @param evento
     * @return 
     */
    @Override
    public Sensor darSensorMasCercano(EventoSismicoDTO evento) {
        
        return persistenciaSensores.darSensorMasCercano(evento);
   
    }
    
    /**
     * Calcula la distancia esférica entre 2 puntos de la tierra con la formula Haversine
     * @param latitud1
     * @param latitud2
     * @param longitud1
     * @param longitud2 
     */
    public double distancia2Puntos(double latitud1, double latitud2, double longitud1, double longitud2)
    {
        //Radio de la tierra (m)
        double R = 6371000;
        double phi1 = Math.toRadians(latitud1);
        double phi2 = Math.toRadians(latitud2);
        double diffPhi = Math.toRadians(Math.abs(latitud2-latitud1));
        double diffLong = Math.toRadians(Math.abs(longitud2-longitud1));
        
        double a = Math.pow(Math.sin(diffPhi/2), 2) + Math.cos(phi1)*Math.cos(phi2)*Math.pow(Math.sin(diffLong/2), 2);
        double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        
        return R*c;
    }
    
}
