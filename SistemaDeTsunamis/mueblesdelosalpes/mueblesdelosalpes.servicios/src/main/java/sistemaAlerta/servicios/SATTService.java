/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.servicios;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sistemaAlerta.dto.BoletinDTO;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.dto.ParametroDTO;
import sistemaAlerta.entity.Boletin;
import sistemaAlerta.entity.EscenarioPremodelado;
import sistemaAlerta.entity.Sensor;
import sistemaAlerta.interfaces.IServicioEventosSismicos;
import sistemaAlerta.interfaces.IServicioSATT;
import sistemaAlerta.interfaces.IServicioSensores;

/**
 *
 * @author sebastian
 */
@Path("/SATT")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SATTService {
    
    //EJB's
    @Inject
    private IServicioSATT sattEjb;
    
    @Inject
    private IServicioSensores sensoresEjb;
    
    @Inject
    private IServicioEventosSismicos eventosEjb;
    
    /**
     * Creacion de una medida de sensor
     */
    @POST
    @Path("medicion/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void registrarSensor(ParametroDTO medicion)
    {
        sensoresEjb.agregarMedidaSensor(medicion);
    }
    
    /**
     * Devuelve todas las medidas hechas
     */
    @GET
    @Path("mediciones/")
    public List<ParametroDTO> darMediciones()
    {
        return sensoresEjb.darMedidas();
    }
    
    /**
     * Agrega un evento sismico y genera el boletin
     */
    @POST
    @Path("evento/")
    public BoletinDTO registrarEventoSismico(EventoSismicoDTO evento)
    {
        eventosEjb.agregarEventoSismico(evento);
        Sensor sensorMasCercano = sensoresEjb.darSensorMasCercano(evento);
        return sattEjb.generarBoletin(evento, sensorMasCercano);
        //return null;
    }
    
    /**
     * Retorna todos los eventos sismicos
     */
    @GET
    @Path("eventos/")
    public List<EventoSismicoDTO> darEventosSismicos()
    {
        return eventosEjb.darEventosSismicos();
    }
    
     /**
     * Retorna todos los eventos sismicos
     */
    @GET
    @Path("boletines/")
    public List<Boletin> darBoletines()
    {
        return sattEjb.darBoletines();
    }
    
    
    
    /**
     * Configuracion inicial de 4000 sensores
     */
    @GET
    @Path("sensores/")
    public List<Sensor> darSensores()
    {
       return sensoresEjb.darSensores();
    }
     /**
     * Configuracion inicial de 4000 sensores
     */
    @GET
    @Path("iniciarSensores/")
    public void configurarSensores()
    {
        sensoresEjb.configurarSensores();
    }
    
    @GET
    @Path("iniciarEscenarios/")
    public void generarEscenarios()
    {
        sattEjb.generarEscenario();
    }
    @GET
    @Path("escenarios/")
    public List<EscenarioPremodelado> darEscenarios()
    {
        return sattEjb.darEscenarios();
    }
    
    
    
    
}
