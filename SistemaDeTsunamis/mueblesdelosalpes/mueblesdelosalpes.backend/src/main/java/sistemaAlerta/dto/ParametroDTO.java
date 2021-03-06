/*
 * Esta clase representa un DTO de parametro que
 * contiene la informacion generada por un sensor
 */
package sistemaAlerta.dto;

import java.util.Date;

/**
 * Clase de parametro
 * @author sebastian
 */
public class ParametroDTO {
    
    /**
     * Id del sensor que genero esta informacion
     */
    private Long idSensor;
    
    /**
     * Altura de la ola registrada
     */
    private double altura;
    
    /**
     * velocidad de la ola registrada
     */
    private double velocidad;
    
     
     
     //Constructor
     public ParametroDTO(){}

    /**
     * @return the idSensor
     */
    public Long getIdSensor() {
        return idSensor;
    }

    /**
     * @param idSensor the idSensor to set
     */
    public void setIdSensor(Long idSensor) {
        this.idSensor = idSensor;
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
     * @return the velocidad
     */
    public double getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

   
     
    
}
