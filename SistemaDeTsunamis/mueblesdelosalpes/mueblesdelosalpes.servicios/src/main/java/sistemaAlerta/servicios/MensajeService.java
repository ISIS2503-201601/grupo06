/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.servicios;
import sistemaAlerta.dto.Mensaje;
import sistemaAlerta.interfaces.IServicioMensajeMockLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author scvalencia606
 */
@Path("/Mensajes")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MensajeService {
    
    @EJB
    private IServicioMensajeMockLocal mensajeEjb;
    
    @POST
    @Path("enviar/") 
    public void recibirMensaje(Mensaje mensaje) {
        
        mensajeEjb.recibirMensaje(mensaje);
        
    }
 
}

