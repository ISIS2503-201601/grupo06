/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.persistenciaMock;

import java.util.ArrayList;
import java.util.List;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.dto.ParametroDTO;
import sistemaAlerta.entity.Parametro;
import sistemaAlerta.entity.Sensor;

/**
 *
 * @author sebastian
 */
public class PersistenciaSensoresMock {
    
    private List<Sensor> sensores;
    
    
    
    public PersistenciaSensoresMock()
    {
        sensores = new ArrayList<Sensor>();
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
            
            Sensor nuevo = new Sensor(new Long(i), zonaGeografica, longitud, latitud);
            sensores.add(nuevo);
        }
    }
    
    public boolean agregarMedidaSensor(ParametroDTO medida) {
       Parametro medidaNueva = new Parametro(medida.getIdSensor(), medida.getAltura(), medida.getVelocidad());
       sensores.get(medida.getIdSensor().intValue()).agregarParametro(medidaNueva);
       return true;
    }
    
    public List<ParametroDTO> darMedidas() {
             
        List<ParametroDTO> respuesta = new ArrayList<ParametroDTO>();
        
        for(int i = 0; i < sensores.size(); i++)
        {
            
            Sensor sensor = sensores.get(i);
            for(Parametro medida: sensor.getParametros())
            {

                ParametroDTO param = new ParametroDTO();
                param.setAltura(medida.getAltura());
                param.setIdSensor(medida.getIdSensor());
                param.setVelocidad(medida.getVelocidad());
                respuesta.add(param);
            }

        }
        
        return respuesta;
    }
    
    public Sensor darSensorMasCercano(EventoSismicoDTO evento) {
       
        Sensor masCercano = sensores.get(0);
        double distanciaMinima = distancia2Puntos(evento.getLatitud(), masCercano.getLatitud(), evento.getLongitud(), masCercano.getLongitud());
        double distanciaIteracion;
        for(Sensor sensor: sensores)
        {
            distanciaIteracion = distancia2Puntos(evento.getLatitud(), sensor.getLatitud(), evento.getLongitud(), sensor.getLongitud());
            if(distanciaIteracion < distanciaMinima)
            {
                distanciaMinima = distanciaIteracion;
                masCercano = sensor;
            }
        }
        
        return masCercano;
        //return darMedidaSensor3();
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
    
    public Parametro darMedidaSensor3()
    {
                
        //Para efecto de pruebas
        Sensor s = sensores.get(3);
        Parametro medida = s.darUlitmaMedicion();
        return medida;  
    }
    

}
