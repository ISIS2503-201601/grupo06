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
import sistemaAlerta.thread.SATTMonitor;

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
    public List<Boletin> darBoletines()
    {
    return persistenciaBoletines.findAll();
   }
    public BoletinDTO generarBoletin(EventoSismicoDTO evento, Sensor sensorMasCercano) 
    {
        //Se calcula el tiempo de llegada de la ola
        Parametro medicion  = sensorMasCercano.getUltimaMedicion();
        double tiempoLlegada = evento.getDistanciaCosta()/medicion.getVelocidad();
        String perfil = darPerfilPreModelado(evento, medicion, tiempoLlegada);
        
        //Test
        perfil = EscenarioPremodelado.ALERTA;
        
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
            List<EscenarioPremodelado> escenarios = persistenciEscenarios.findAll();
            SATTMonitor monitor = new SATTMonitor(evento, sensorMasCercano, tiempoLlegada,escenarios);
            monitor.start();
            
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
                   && medicion.getAltura() >= escenario.getAlturaMinima()
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
        
        alturaMax = (i/150)*10;
        if(alturaMax>2.5)
        {
            alturaMin=alturaMax-2.5;
        }
        else
        {
            alturaMin=0;
        }
        tiempoMax = (1-(i/150))*10;
        if(tiempoMax>2.5)
        {
            tiempoMin=tiempoMax-2.5;
        }
        else
        {
            tiempoMin=0;
        }
        
           
            aleatorioZona = (int)Math.random()*10;
            
            if(aleatorioZona <=5)
                zonaGeografica = Sensor.ZONA_ATLANTICA;
            else
                zonaGeografica = Sensor.ZONA_PACIFICA;
            
            
            EscenarioPremodelado escenario = new EscenarioPremodelado();
            escenario.setAlturaMaxima(alturaMax);
            escenario.setAlturaMinima(alturaMin);
            escenario.setTiempoMaximo(tiempoMax);
            escenario.setTiempoMinimo(tiempoMin);
            if(alturaMax==10&&alturaMin>7.5&&tiempoMin==0&&tiempoMax<2.5)
            {
            escenario.setPerfil(EscenarioPremodelado.ALARMA);
            }
            else if(alturaMax<7.5&&alturaMin>5&&tiempoMin>2.5&&tiempoMax<5)
            {
            escenario.setPerfil(EscenarioPremodelado.ALERTA);
            }
            else if(alturaMax<5&&alturaMin>2.5&&tiempoMin>5&&tiempoMax<7.5)
            {
            escenario.setPerfil(EscenarioPremodelado.PRECAUCION);
            }
            else
            {
            escenario.setPerfil(EscenarioPremodelado.INFORMATIVO);
            }
            if(escenario.getPerfil()==null)
            {
            escenario.setPerfil(EscenarioPremodelado.INFORMATIVO);
            }
            escenario.setZona(zonaGeografica);
            persistenciEscenarios.create(escenario);
        }
            return new EscenarioPremodelado();
    }
    
    public List<EscenarioPremodelado> darEscenarios()
    {
    return  persistenciEscenarios.findAll();
    }
}
