/*
 * Esta clase representa un sensor ubicado en la costa
 */
package sistemaAlerta.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * Sensor en la costa
 * @author sebastian
 */
public class Sensor {
    
    //Zona atlantica
    public final static String ZONA_ATLANTICA = "Atlantica";
    
    //Zona pacifica
    public final static String ZONA_PACIFICA = "Pacifica";
    
    /**
     * id autogenerado del sensor
     */
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
    
    /**
     * Parametros medidos por el sensor
     */
    private List<Parametro> parametros;
    
    //Constructor
    public Sensor (Long id, String zonaGeografica, double longitud, double latitud)
    {
        this.id = id;
        this.zonaGeografica = zonaGeografica;
        this.longitud = longitud;
        this.latitud = latitud;
        parametros = new ArrayList<Parametro>();
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
     * @return the parametros
     */
    public List<Parametro> getParametros() {
        return parametros;
    }

    /**
     * @param parametros the parametros to set
     */
    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }
    
    /**
     * Agrega una medicion al sensor
     */
    public void agregarParametro(Parametro nuevo)
    {
        parametros.add(nuevo);
    }
    
    /**
     * Obtiene la ultima medicion del sensor
     */
    public Parametro darUlitmaMedicion()
    {
        return parametros.get(parametros.size()-1);
    }
    
    
}
