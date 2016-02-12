/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package posttest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.codec.DecoderException;





/**
 *
 * @author sebastian
 */
public class POSTTest {

    
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
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "http://localhost:8080/mueblesdelosalpes.servicios/webresources/CarroCompras/agregar";
        String json = "[{\"referencia\":6000,\"nombre\":\"TEST\",\"descripcion\":\"Con diseÃ±o moderno. Sus hijos ahora podrÃ¡n tener unos felices sueÃ±os.\",\"tipo\":\"Interior\",\"precio\":56565.0,\"imagen\":\"camarote\",\"cantidad\":85,\"seleccion\":false}]";
        POSTTest.POST(url, json);
    }
    
}
