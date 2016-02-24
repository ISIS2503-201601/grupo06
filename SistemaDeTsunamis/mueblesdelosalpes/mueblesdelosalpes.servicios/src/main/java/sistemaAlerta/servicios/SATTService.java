/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.servicios;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import sistemaAlerta.dto.BoletinDTO;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.dto.ParametroDTO;
import sistemaAlerta.entity.Parametro;
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
    @EJB
    private IServicioSATT sattEjb;
    
    @EJB
    private IServicioSensores sensoresEjb;
    
    @EJB
    private IServicioEventosSismicos eventosEjb;
    
    /**
     * Creacion de una medida de sensor
     */
    @POST
    @Path("registrarSensor/")
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
    @Path("registrarEventoSismico/")
    public BoletinDTO registrarEventoSismico(EventoSismicoDTO evento)
    {
        eventosEjb.agregarEventoSismico(evento);
        Parametro medicion = sensoresEjb.darMedicionSensorMasCercano(evento);
        return sattEjb.generarBoletin(evento, medicion);
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
    
    
}
