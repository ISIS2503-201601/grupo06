/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaAlerta.dto;

/**
 *
 * @author sebastian
 */
public class BoletinAlerta {
    
    //id
    private long id;
    
    //Perfil de alerta
    private String perfilAlerta;
    
    //Zona Geografica
    private String zona;
    
    //tiempo de llegada
    private double tiempoLlegada;
    
    //Altura de la ola
    private double altura;

    
    //Constructor POJO
    public BoletinAlerta(long id, String perfilAlerta, String zona, double tiempoLlegada, double altura)
    {
        this.id = id;
        this.perfilAlerta = perfilAlerta;
        this.zona = zona;
        this.tiempoLlegada = tiempoLlegada;
        this.altura = altura;
    }
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the perfilAlerta
     */
    public String getPerfilAlerta() {
        return perfilAlerta;
    }

    /**
     * @param perfilAlerta the perfilAlerta to set
     */
    public void setPerfilAlerta(String perfilAlerta) {
        this.perfilAlerta = perfilAlerta;
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
    
}
