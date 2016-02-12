/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posttest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
*/

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;

/**
 *
 * @author da.ordonez11
 */
public class Sensor extends Thread{

    double lat;
    double lon;
    //En metros
    int id;
    double altura;
    //En km por hora
    double velocidad;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 0; i < 20; i++) {
          Sensor s = new Sensor(i,i,i);
          s.start();
        
          
        }
       
    }
    public Sensor(int nId,int nLat, int nLon)
    {
        id = nId;
        lat=nLat;
        lon=nLon;
    }

    @Override
    public void run() {
         while(true)
        {
            altura= (int) ((Math.random())*2000);
            velocidad=(int)((Math.random())*500);
        System.out.println("Sensor: "+id+"| Altura: "+altura+"| Velocidad: "+velocidad);
          String url = "http://localhost:8080/mueblesdelosalpes.servicios/webresources/Mensajes/enviar";
        String json = "{\"id\":"+id+",\"latitud\":\""+lat+"\",\"longitud\":\""+lon+"\",\"velocidad\":\""+velocidad+"\",\"altura\":\""+altura+"\"}";
        POSTTest.POST(url, json);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
            }
        } 
    }
    
     public static void POST(String url, String json) 
    {
        try
        {
            StringRequestEntity request = new StringRequestEntity(json);
            HttpClient client = new HttpClient();
            PostMethod post = new PostMethod(url);
            post.setRequestHeader("Content-Type", "application/json");
            post.setRequestEntity(request);
            int response = client.executeMethod(post);
            System.out.println("Response: "+response);
        } 
        catch (UnsupportedEncodingException ex) {
            Logger.getLogger(POSTTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(POSTTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
   
}
