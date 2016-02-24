/*
 * Escenario premodelado de un evento sismico
 */
package sistemaAlerta.entity;

/**
 * Escenario premodelado
 * @author sebastian
 */
public class EscenarioPremodelado {
    
    //Perfiles posibles
    
    public final static String INFORMATIVO = "Informativo";
    
    public final static String PRECAUCION = "Precaucion";
    
    public final static String ALERTA = "Alerta";
    
    public final static String ALARMA = "Alarma";
    
    //Atributos 
    /**
     * Altura maxima de la ola
     */
    private double alturaMaxima;
    
    /**
     * Altura minima de la ola
     */
    private double alutraMinima;
    
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
    public EscenarioPremodelado(double alturaMax, double alturaMin, double tiempoMax, double tiempoMin, String perfil, String zonaGeo)
    {
        this.alturaMaxima = alturaMax;
        this.alutraMinima = alturaMin;
        this.tiempoMaximo = tiempoMax;
        this.tiempoMinimo = tiempoMin;
        this.perfil = perfil;
        this.zona = zonaGeo;
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
     * @return the alutraMinima
     */
    public double getAlutraMinima() {
        return alutraMinima;
    }

    /**
     * @param alutraMinima the alutraMinima to set
     */
    public void setAlutraMinima(double alutraMinima) {
        this.alutraMinima = alutraMinima;
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
