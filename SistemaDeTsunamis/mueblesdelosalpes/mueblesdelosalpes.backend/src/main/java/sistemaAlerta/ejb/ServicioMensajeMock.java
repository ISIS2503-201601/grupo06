/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$ ServicioCarritoMock.java
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 * Licenciado bajo el esquema Academic Free License version 3.0
 *
 * Ejercicio: Muebles de los Alpes
 * Autor: Juan Sebastián Urrego
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package sistemaAlerta.ejb;

import sistemaAlerta.dto.Mensaje;
import sistemaAlerta.interfaces.IServicioMensajeMockLocal;
import sistemaAlerta.interfaces.IServicioMensajeMockRemote;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;

/**
 * Implementacion de los servicios del carrito de compras en el sistema.
 * @author Juan Sebastián Urrego editado por Edgar Sandoval
 */

@Stateless
public class ServicioMensajeMock implements IServicioMensajeMockRemote, IServicioMensajeMockLocal
{
    //-----------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------
    
    private List<Mensaje> mensajes;
    
    //-----------------------------------------------------------
    // Constructor
    //-----------------------------------------------------------
    
    /**
     * Constructor sin argumentos de la clase
     */
    public ServicioMensajeMock()
    {
        mensajes = new ArrayList();
    }

    //-----------------------------------------------------------
    // Getters y setters
    //-----------------------------------------------------------


    /**
     * Modifica el inventario del carrito
     * @param inventario Nueva lista de muebles
     */
    @Override
    public void recibirMensaje(Mensaje mensaje)
    {
        mensajes.add(mensaje);
    }
    
    @Override
    public List<Mensaje> darMensajes()
    {
        return mensajes;
    }

    @Override
    public Mensaje buscarUltimoRegistroSensorCercano(double latitud, double longitud) 
    {
        Mensaje masCercano = mensajes.get(0);
        double distanciaMin = distancia2Puntos(latitud, masCercano.getLatitud() , longitud, masCercano.getLongitud());
        double d = 0;
        
        for(Mensaje m : mensajes)
        {
            d = distancia2Puntos(latitud, m.getLatitud() , longitud, m.getLongitud());
            if(d < distanciaMin)
            {
                distanciaMin = d;
                masCercano = m;
            }
            
        }
        
        return masCercano;
        
    }
    
    /**
     * Calcula la distancia esférica entre 2 puntos de la tierra con la formula Haversine
     * @param latitud1
     * @param latitud2
     * @param longitud1
     * @param longitud2 
     */
    public double distancia2Puntos(double latitud1, double latitud2, double longitud1, double longitud2)
    {
        //Radio de la tierra (m)
        double R = 6371000;
        double phi1 = Math.toRadians(latitud1);
        double phi2 = Math.toRadians(latitud2);
        double diffPhi = Math.toRadians(Math.abs(latitud2-latitud1));
        double diffLong = Math.toRadians(Math.abs(longitud2-longitud1));
        
        double a = Math.pow(Math.sin(diffPhi/2), 2) + Math.cos(phi1)*Math.cos(phi2)*Math.pow(Math.sin(diffLong/2), 2);
        double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        
        return R*c;
    }

    
    
}
