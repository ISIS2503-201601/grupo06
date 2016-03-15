/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.persistenciaMock;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    

    public EntityManager getEm() {
        return em;
    }
    
    public Sensor getSensorNumeroSerie(int numero)
    {
        Query q = getEm().createQuery("select u from Sensor u where u.numeroDeSerie = :num").setParameter("num", numero);
        return (Sensor)q.getSingleResult();
    }
    
    
    

}
