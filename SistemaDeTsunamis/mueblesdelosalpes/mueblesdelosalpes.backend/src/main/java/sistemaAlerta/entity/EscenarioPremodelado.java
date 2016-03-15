/*
 * Escenario premodelado de un evento sismico
 */
package sistemaAlerta.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Escenario premodelado
 * @author sebastian
 */
@Entity
public class EscenarioPremodelado {
    
    //Perfiles posibles
    
    public final static String INFORMATIVO = "Informativo";
    
    public final static String PRECAUCION = "Precaucion";
    
    public final static String ALERTA = "Alerta";
    
    public final static String ALARMA = "Alarma";
    
    //Atributos 
    
    @Id
    @GeneratedValue(generator = "Escenario")
    private Long id;
    /**
     * Altura maxima de la ola
     */
    private double alturaMaxima;
    
    /**
     * Altura minima de la ola
     */
    private double alturaMinima;
    
    /**
     * Tiempo maximo de llegada
     */
    private double tiempoMaximo;
    
    /**
     * Tiempo minimo de llegada
     */
    private double tiempoMinimo;
    
    /**
     * Perfil de alerta
     */
    private String perfil;
    
    /**
     * Zona geografica
     */
    private String zona;
    
    //Constructor
    public EscenarioPremodelado()
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
     * @return the alturaMaxima
     */
    public double getAlturaMaxima() {
        return alturaMaxima;
    }

    /**
     * @param alturaMaxima the alturaMaxima to set
     */
    public void setAlturaMaxima(double alturaMaxima) {
        this.alturaMaxima = alturaMaxima;
    }

    /**
     * @return the alturaMinima
     */
    public double getAlturaMinima() {
        return alturaMinima;
    }

    /**
     * @param alturaMinima the alturaMinima to set
     */
    public void setAlturaMinima(double alutraMinima) {
        this.alturaMinima = alutraMinima;
    }

    /**
     * @return the tiempoMaximo
     */
    public double getTiempoMaximo() {
        return tiempoMaximo;
    }

    /**
     * @param tiempoMaximo the tiempoMaximo to set
     */
    public void setTiempoMaximo(double tiempoMaximo) {
        this.tiempoMaximo = tiempoMaximo;
    }

    /**
     * @return the tiempoMinimo
     */
    public double getTiempoMinimo() {
        return tiempoMinimo;
    }

    /**
     * @param tiempoMinimo the tiempoMinimo to set
     */
    public void setTiempoMinimo(double tiempoMinimo) {
        this.tiempoMinimo = tiempoMinimo;
    }

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the zona
     */
    public String getZona() {
        return zona;
    }

    /**
     * @param zona the zona to set
     */
    public void setZona(String zona) {
        this.zona = zona;
    }
    
    
}
