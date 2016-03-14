/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.persistenciaMock;

import sistemaAlerta.entity.Parametro;

/**
 *
 * @author sebastian
 */
public class PersistenciaParametrosMock extends CrudPersistence<Parametro> {
    
    public PersistenciaParametrosMock()
    {
        this.entityClass = Parametro.class;
    }
    
    
}
