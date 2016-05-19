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
import javax.inject.Inject;
import javax.persistence.Persistence;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.dto.ParametroDTO;
import sistemaAlerta.entity.Parametro;
import sistemaAlerta.entity.Sensor;
import sistemaAlerta.interfaces.IServicioSensores;
import sistemaAlerta.persistenciaMock.PersistenciaParametrosMock;
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
    @Inject private PersistenciaSensoresMock persistenciaSensores;
    
    @Inject private PersistenciaParametrosMock persistenciaParametros;
    
    
    //Constructor
    public ServicioSensores()
    {
        
    }
    public List<Sensor> darSensores()
    {
        List<Sensor> parametros = persistenciaSensores.findAll();
     
        
        return parametros;
    }
    public boolean agregarMedidaSensor(ParametroDTO medida) {
       Parametro medidaNueva = new Parametro();
       medidaNueva.setAltura(medida.getAltura());
       medidaNueva.setIdSensor(medida.getIdSensor());
       medidaNueva.setVelocidad(medida.getVelocidad());
       //Sensor sensor = persistenciaSensores.find(medida.getIdSensor());
       Sensor sensor = persistenciaSensores.getSensorNumeroSerie(medida.getIdSensor().intValue());
       sensor.setUltimaMedicion(medidaNueva);
       persistenciaSensores.update(sensor);
       persistenciaParametros.create(medidaNueva);
       return true;
    }
    
    public List<ParametroDTO> darMedidas() {
             
    
        
        List<ParametroDTO> respuesta = new ArrayList<ParametroDTO>();
        List<Sensor> parametros = persistenciaSensores.findAll();
            for(int i = 0; i < parametros.size(); i++)
            {

                Sensor s = (Sensor) parametros.get(i);
                if(s.getUltimaMedicion()!=null)
                {
                ParametroDTO param = new ParametroDTO();
                param.setAltura(s.getUltimaMedicion().getAltura());
                param.setIdSensor(s.getUltimaMedicion().getIdSensor());
                param.setVelocidad(s.getUltimaMedicion().getVelocidad());
                respuesta.add(param);
                }
            }

        
        
        return respuesta;
    }
    
    public Sensor darSensorMasCercano(EventoSismicoDTO evento) {
       
        List<Sensor> sensores = persistenciaSensores.findAll();
        Sensor masCercano = null;
        double distanciaMinima = 0;
        double distanciaIteracion = 0;
        for(int i = 0; i < sensores.size(); i++)
        {
            Sensor sensor = (Sensor) sensores.get(i);
            distanciaIteracion = distancia2Puntos(evento.getLatitud(), sensor.getLatitud(), evento.getLongitud(), sensor.getLongitud());
            if(i == 0)
            {
                distanciaMinima = distanciaIteracion;
            }
            else if(distanciaIteracion < distanciaMinima)
            {
                distanciaMinima = distanciaIteracion;
                masCercano = sensor;
            }
        }
        
        //return masCercano;
        //Test
        for(Sensor s : sensores)
        {
            if(s.getNumeroDeSerie() == 37)
                return s;
        }
        return null;
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
    
    /**
     * Configuracion inicial de 4000 sensores
     */
    public void configurarSensores()
    {
        for(int i = 0; i < 4000; i++)
        {
            int zona = (int)(Math.random()*10);
            double longitud = Math.random()*100;
            double latitud = Math.random()*100;
            String zonaGeografica;
            if(zona <= 5)
                zonaGeografica = Sensor.ZONA_ATLANTICA;
            else
                zonaGeografica = Sensor.ZONA_PACIFICA;
            
            Sensor nuevo = new Sensor();
            nuevo.setLatitud(latitud);
            nuevo.setLongitud(longitud);
            nuevo.setZonaGeografica(zonaGeografica);
            nuevo.setNumeroDeSerie(i);
            persistenciaSensores.create(nuevo);
        }
    }
    
}
