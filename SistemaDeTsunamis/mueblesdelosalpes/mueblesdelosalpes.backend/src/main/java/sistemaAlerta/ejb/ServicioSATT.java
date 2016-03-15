/*
 * Implementacion de servicios de SATT
 */
package sistemaAlerta.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import sistemaAlerta.dto.BoletinDTO;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.entity.Boletin;
import sistemaAlerta.entity.EscenarioPremodelado;
import sistemaAlerta.entity.Parametro;
import sistemaAlerta.entity.Sensor;
import sistemaAlerta.interfaces.IServicioSATT;
import sistemaAlerta.persistenciaMock.PersistenciaBoletinesMock;
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
    @Inject private PersistenciaEscenariosMock persistenciEscenarios;
    
    @Inject private PersistenciaBoletinesMock persistenciaBoletines;
    
    //Constructor
    public ServicioSATT()
    {
        
    }
    
    public BoletinDTO generarBoletin(EventoSismicoDTO evento, Sensor sensorMasCercano) 
    {
        //Se calcula el tiempo de llegada de la ola
        Parametro medicion  = sensorMasCercano.getUltimaMedicion();
        double tiempoLlegada = evento.getDistanciaCosta()/medicion.getVelocidad();
        String perfil = darPerfilPreModelado(evento, medicion, tiempoLlegada);
        
        //Test
        //perfil = EscenarioPremodelado.ALERTA;
        
        if(perfil != null)
        {
            BoletinDTO respuesta = new BoletinDTO();
            respuesta.setAltura(medicion.getAltura());
            respuesta.setPerfil(perfil);
            respuesta.setTiempoLlegada(tiempoLlegada);
            respuesta.setZonaGeografica(evento.getZonaGeografica());
            
            Boletin boletin = new Boletin();
            boletin.setAltura(medicion.getAltura());
            boletin.setPerfil(perfil);
            boletin.setTiempoLlegada(tiempoLlegada);
            boletin.setZonaGeografica(evento.getZonaGeografica());
            //Seguimiento 
//            SATTMonitor monitor = new SATTMonitor(evento, sensorMasCercano, this, tiempoLlegada);
//            monitor.start();
            
            persistenciaBoletines.create(boletin);
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
        List<EscenarioPremodelado> escenarios = persistenciEscenarios.findAll();
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
    
    
    
    /**
     * Genera un escenario premodelado con datos aleatorios
     */
    public EscenarioPremodelado generarEscenario()
    {
        int nEscenarios = 150;
        
        for(int i = 0; i < nEscenarios; i++)
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
            
            
            EscenarioPremodelado escenario = new EscenarioPremodelado();
            escenario.setAlturaMaxima(alturaMax);
            escenario.setAlutraMinima(alturaMin);
            escenario.setTiempoMaximo(tiempoMax);
            escenario.setTiempoMinimo(tiempoMin);
            escenario.setPerfil(perfil);
            escenario.setZona(zonaGeografica);
            persistenciEscenarios.create(escenario);
        }
            return new EscenarioPremodelado();
    }
    
    
}
