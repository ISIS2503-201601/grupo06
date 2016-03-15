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
import sistemaAlerta.dto.BoletinAlerta;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.dto.Mensaje;
import sistemaAlerta.interfaces.IServicioEventoSismicoMockLocal;
import sistemaAlerta.interfaces.IServicioMensajeMockLocal;

/**
 *
 * @author scvalencia606
 */
@Path("/EventosSismicos")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventoSismicoService {
    
    @EJB
    private IServicioEventoSismicoMockLocal eventoEjb;
    
    @EJB
    private IServicioMensajeMockLocal mensajesEjb;
    
    @POST
    @Path("enviar/") 
    public BoletinAlerta recibirEvento(EventoSismicoDTO evento) {
        
        eventoEjb.recibirEvento(evento);
        Mensaje m = mensajesEjb.buscarUltimoRegistroSensorCercano(evento.getLatitud(), evento.getLongitud());
        return eventoEjb.generarBoletin(m, evento);
        
    }
    
    @GET
    @Path("ver/") 
    public List<EventoSismicoDTO> verEventos() {
        
        return eventoEjb.darEventos();
        
    }
 
}

