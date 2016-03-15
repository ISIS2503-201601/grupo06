/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.persistenciaMock;

import sistemaAlerta.entity.EscenarioPremodelado;

/**
 *
 * @author sebastian
 */
public class PersistenciaEscenariosMock extends CrudPersistence<EscenarioPremodelado>{
    
    public PersistenciaEscenariosMock()
    {
        this.entityClass = EscenarioPremodelado.class;
    }
    
}
