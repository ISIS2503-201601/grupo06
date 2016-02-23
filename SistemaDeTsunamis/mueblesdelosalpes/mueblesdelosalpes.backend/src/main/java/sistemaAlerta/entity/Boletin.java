/*
 * DTO de un boletin de alerta
 */
package sistemaAlerta.entity;

/**
 * Boletin de alerta
 * @author sebastian
 */
public class Boletin {
    
    /**
     * Id
     */
    private Long id;
    
    /**
     * perfil de alerta del boletin
     */
    private String perfil;
    
    /**
     * Zona geografica del boletin
     */
    private String zonaGeografica;
    
    /**
     * Tiempo de llegada de la ola
     */
    private double tiempoLlegada;
    
    /**
     * altura de la ola
     */
    private double altura;
    
    //Constructor
    public Boletin(){}

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
     * @return the tiempoLlegada
     */
    public double getTiempoLlegada() {
        return tiempoLlegada;
    }

    /**
     * @param tiempoLlegada the tiempoLlegada to set
     */
    public void setTiempoLlegada(double tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
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
