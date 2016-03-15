/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.thread;

import javax.ejb.EJB;
import javax.inject.Inject;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.entity.EscenarioPremodelado;
import sistemaAlerta.entity.Parametro;
import sistemaAlerta.entity.Sensor;
import sistemaAlerta.interfaces.IServicioSATT;
import sistemaAlerta.interfaces.IServicioSensores;
import sistemaAlerta.persistenciaMock.PersistenciaEscenariosMock;
import sistemaAlerta.persistenciaMock.PersistenciaEventosMock;

/**
 *
 * @author sebastian
 */
public class SATTMonitor extends Thread{
    
    //Atributos
    /**
     * Sensor mas cercano al evento sismico dado
     */
    private Sensor sensorMasCercano;
    
    /**
     * Servicio de persistencia de escenarios para variable de sincronizacion
     */
    @Inject
    private IServicioSATT servicioSatt;
    
    /**
     * Altura de la ola original que origino el boletin
     */
    private double alturaOriginal;
    
    /**
     * Evento sismico original
     */
    private EventoSismicoDTO eventoOriginal;
    
    /**
     * Evento sismico generado
     * 
     */
    private boolean alerta;
    
    
    
    //Constructor
    public SATTMonitor(EventoSismicoDTO eventoOriginal, Sensor sensorMasCercano, double alturaOriginal)
    {
        this.sensorMasCercano = sensorMasCercano;
       
        this.alturaOriginal = alturaOriginal;
        this.eventoOriginal = eventoOriginal;
        alerta = true;
    }
    
  
    //Run del thread
    
    public void run()
    {
        while(alerta)
        {
            synchronized(this)
            {
                try
            {
                //Espera de 5 minutos
                this.wait(3000);
                Parametro nuevaMedicion = sensorMasCercano.getUltimaMedicion();
                double alturaActual = nuevaMedicion.getAltura();
                double tiempoLlegadaNuevo = eventoOriginal.getDistanciaCosta()/nuevaMedicion.getVelocidad();
                double differencia = Math.abs(alturaOriginal-alturaActual);
                if(differencia >= 1.5)
                {
                   String perfilNuevo = servicioSatt.darPerfilPreModelado(eventoOriginal, sensorMasCercano.getUltimaMedicion(), tiempoLlegadaNuevo);
                   
                   //Generar y enviar un nuevo boletin
                   /*
                   * TODO
                   */
                   //Test
                   perfilNuevo = EscenarioPremodelado.PRECAUCION;
                   System.out.println("Perfil: " + perfilNuevo);
                   
                   if(perfilNuevo.equals(EscenarioPremodelado.INFORMATIVO))
                       alerta = false;
                }
                        
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
            }
            System.out.println("Estado normal");
        }
    }
    
    
}
