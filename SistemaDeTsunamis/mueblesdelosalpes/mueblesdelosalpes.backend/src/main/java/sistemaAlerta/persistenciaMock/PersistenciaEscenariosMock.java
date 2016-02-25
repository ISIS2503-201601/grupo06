/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.persistenciaMock;

import java.util.ArrayList;
import java.util.List;
import sistemaAlerta.dto.BoletinDTO;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.entity.EscenarioPremodelado;
import sistemaAlerta.entity.Parametro;
import sistemaAlerta.entity.Sensor;
import sistemaAlerta.thread.SATTMonitor;

/**
 *
 * @author sebastian
 */
public class PersistenciaEscenariosMock {
    
    /**
     * Escenarios premodelados
     */
    private List<EscenarioPremodelado> escenarios;
    
    
    
    public PersistenciaEscenariosMock()
    {
        escenarios = new ArrayList<EscenarioPremodelado>();
        
        //Genera un numero arbitrario de escenarios premodelados
        int nEscenarios = 150;
        
        for(int i = 0; i < nEscenarios; i++)
        {
            EscenarioPremodelado escenario = generarEscenario();
            escenarios.add(escenario);
        }
    }
    
    
    
    /**
     * Genera un escenario premodelado con datos aleatorios
     */
    public EscenarioPremodelado generarEscenario()
    {
        double alturaMax, alturaMin, tiempoMax, tiempoMin,temp;
        int aleatorioPerfil, aleatorioZona;
        String zonaGeografica, perfil;
        
        alturaMax = Math.random()*10;
            alturaMin = Math.random()*10;
            if(alturaMax < alturaMin)
            {
                temp = alturaMin;
                alturaMin = alturaMax;
                alturaMax = temp;
            }
            
            tiempoMax = Math.random()*10;
            tiempoMin = Math.random()*10;
            if(tiempoMax < tiempoMin)
            {
                temp = tiempoMin;
                tiempoMin = tiempoMax;
                tiempoMax = temp;
            }
            
            aleatorioPerfil = (int)Math.random();
            
            if(aleatorioPerfil <= 2)
                perfil = EscenarioPremodelado.ALARMA;
            else if(aleatorioPerfil > 2 && aleatorioPerfil <= 5)
                perfil = EscenarioPremodelado.ALERTA;
            else if(aleatorioPerfil > 5 && aleatorioPerfil <= 8)
                perfil = EscenarioPremodelado.INFORMATIVO;
            else
                perfil = EscenarioPremodelado.PRECAUCION;
            
            aleatorioZona = (int)Math.random();
            
            if(aleatorioZona <=5)
                zonaGeografica = Sensor.ZONA_ATLANTICA;
            else
                zonaGeografica = Sensor.ZONA_PACIFICA;
        
            return new EscenarioPremodelado(alturaMax, alturaMin, tiempoMax, tiempoMin, perfil, zonaGeografica);
    }
    
    public BoletinDTO generarBoletin(EventoSismicoDTO evento, Sensor sensorMasCercano) 
    {
        //Se calcula el tiempo de llegada de la ola
        Parametro medicion  = sensorMasCercano.darUlitmaMedicion();
        double tiempoLlegada = evento.getDistanciaCosta()/medicion.getVelocidad();
        String perfil = darPerfilPreModelado(evento, medicion, tiempoLlegada);
        
        if(perfil != null)
        {
            BoletinDTO respuesta = new BoletinDTO();
            respuesta.setAltura(medicion.getAltura());
            respuesta.setPerfil(perfil);
            respuesta.setTiempoLlegada(tiempoLlegada);
            respuesta.setZonaGeografica(evento.getZonaGeografica());
            
            //Seguimiento 
//            SATTMonitor monitor = new SATTMonitor(evento, sensorMasCercano, this, tiempoLlegada);
//            monitor.start();
            
            return respuesta;
        }
        else
            return null;
        
    }
    
    /**
     * Busca el perfil de alerta de la comparacion con escenarios premodelados
     */
    public String darPerfilPreModelado(EventoSismicoDTO evento, Parametro medicion, double tiempoLlegada)
    {
  
        String respuesta = null;
        
        //Se asume que los intervalos de los escenarios son disyuntos
        for(EscenarioPremodelado escenario : escenarios)
        {
            if(evento.getZonaGeografica().equals(escenario.getZona())) 
            {
                if(medicion.getAltura() <= escenario.getAlturaMaxima()
                   && medicion.getAltura() >= escenario.getAlutraMinima()
                   && tiempoLlegada <= escenario.getTiempoMaximo()
                   && tiempoLlegada >= escenario.getTiempoMinimo())
                {
                    respuesta = escenario.getPerfil();
                    break;
                }
            }
            
        }
        
        return respuesta;
    }
    
    
    
}
