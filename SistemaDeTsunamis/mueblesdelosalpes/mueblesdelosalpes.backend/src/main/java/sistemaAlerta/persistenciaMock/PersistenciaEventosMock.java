/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.persistenciaMock;

import java.util.ArrayList;
import java.util.List;
import sistemaAlerta.dto.EventoSismicoDTO;
import sistemaAlerta.entity.EventoSismico;

/**
 *
 * @author sebastian
 */
public class PersistenciaEventosMock extends CrudPersistence<EventoSismico> {
    
    public PersistenciaEventosMock()
    {
        this.entityClass = EventoSismico.class;
    }
    
    
}
