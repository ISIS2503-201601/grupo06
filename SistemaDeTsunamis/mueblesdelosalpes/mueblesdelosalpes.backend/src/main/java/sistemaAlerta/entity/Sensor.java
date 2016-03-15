/*
 * Esta clase representa un sensor ubicado en la costa
 */
package sistemaAlerta.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


/**
 * Sensor en la costa
 * @author sebastian
 */
@Entity
public class Sensor {
    
    //Zona atlantica
    public final static String ZONA_ATLANTICA = "Atlantica";
    
    //Zona pacifica
    public final static String ZONA_PACIFICA = "Pacifica";
    
    /**
     * id autogenerado del sensor
     */
    @Id
    @GeneratedValue(generator = "Sensor")
    private Long id;
    
    /**
     * Zona geografica {Atlantica, Pacifica}
     */
    private String zonaGeografica;
    
    /**
     * Longitud del sensor
     */
    private double longitud;
    
    /**
     * Latitud del sensor
     */
    private double latitud;
    
    private int numeroDeSerie;
    
    private Parametro ultimaMedicion;
    
    
    //Constructor
    public Sensor ()
    {
        
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the zonaGeografica
     */
    public String getZonaGeografica() {
        return zonaGeografica;
    }

    /**
     * @param zonaGeografica the zonaGeografica to set
     */
    public void setZonaGeografica(String zonaGeografica) {
        this.zonaGeografica = zonaGeografica;
    }

    /**
     * @return the longitud
     */
    public double getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    /**
     * @return the latitud
     */
    public double getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    /**
     * Obtiene la ultima medicion del sensor
     */
    public Parametro getUltimaMedicion()
    {
        return ultimaMedicion;
    }
    
    public void setUltimaMedicion(Parametro ultimaMedicion)
    {
        this.ultimaMedicion = ultimaMedicion;
    }

    /**
     * @return the numeroDeSerie
     */
    public int getNumeroDeSerie() {
        return numeroDeSerie;
    }

    /**
     * @param numeroDeSerie the numeroDeSerie to set
     */
    public void setNumeroDeSerie(int numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }

    
    
}
