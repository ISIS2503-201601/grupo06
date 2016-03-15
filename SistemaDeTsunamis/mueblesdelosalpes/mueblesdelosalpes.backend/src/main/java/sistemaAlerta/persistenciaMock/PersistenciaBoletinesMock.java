/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.persistenciaMock;

import sistemaAlerta.entity.Boletin;

/**
 *
 * @author sebastian
 */
public class PersistenciaBoletinesMock extends CrudPersistence<Boletin>{
    
    public PersistenciaBoletinesMock()
    {
        this.entityClass = Boletin.class;
    }
    
}
