/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.persistenciaMock;

import sistemaAlerta.entity.Sensor;

/**
 *
 * @author sebastian
 */
public class PersistenciaSensoresMock extends CrudPersistence<Sensor>{
    
    public PersistenciaSensoresMock()
    {
        this.entityClass = Sensor.class;
    }
    
    
    

}
