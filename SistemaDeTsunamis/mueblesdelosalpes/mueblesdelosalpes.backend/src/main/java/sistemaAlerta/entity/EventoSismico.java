/*
 * Representa el DTO de un evento sísmico
 */
package sistemaAlerta.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Clase para representar el DTO de un evento sismico
 * @author sebastian
 */
@Entity
public class EventoSismico {
    
    /**
     * Id
     */
    @Id
    @GeneratedValue(generator = "Evento")
    private Long id;
    
    /**
     * Longitud del evento
     */
    private double longitud;
    
    /**
     * Latitud del evento
     */
    private double latitud;
    
    /**
     * Distancia a la costa del evento
     */
    private double distanciaCosta;
    
    /**
     * Zona geografica del evento
     */
    private String zonaGeografica;

    //Constructor
    public EventoSismico(){}

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
     * @return the distanciaCosta
     */
    public double getDistanciaCosta() {
        return distanciaCosta;
    }

    /**
     * @param distanciaCosta the distanciaCosta to set
     */
    public void setDistanciaCosta(double distanciaCosta) {
        this.distanciaCosta = distanciaCosta;
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
    
    
    
}
