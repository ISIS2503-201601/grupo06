/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.entity.EventoSismico;
import sistemaAlerta.interfaces.IServicioEventosSismicos;
import sistemaAlerta.persistenciaMock.PersistenciaEventosMock;

/**
 *
 * @author sebastian
 */
@Stateless
public class ServicioEventosSismicos implements IServicioEventosSismicos {
    
    //Atributos del EJB
    
    /**
     * Eventos
     */
    private PersistenciaEventosMock persistenciaEventos;
    
    //Constructor
    public ServicioEventosSismicos()
    {
        persistenciaEventos = new PersistenciaEventosMock();
    }

    /**
     * agrega un nuevo evento sismico
     * @param evento
     * @return 
     */
    @Override
    public boolean agregarEventoSismico(EventoSismicoDTO evento) {
        return persistenciaEventos.agregarEventoSismico(evento);
    }

    /**
     * Devuelve los eventos
     * @return 
     */
    @Override
    public List<EventoSismicoDTO> darEventosSismicos() {
        return persistenciaEventos.darEventosSismicos();
    }
    
}
