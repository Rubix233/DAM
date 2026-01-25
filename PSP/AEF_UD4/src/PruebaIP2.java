
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy
 */
public class PruebaIP2 {
    public static void main(String[] args) {
        InetAddress local,google;
        try {
            local = InetAddress.getLocalHost();
            //google = InetAddress.getByName("www.google.es");
            
            System.out.println("Local host name: " + local.getHostName());
            System.out.println("Local IP: " + local.getHostAddress());
            System.out.println("Local nombre canonigo: " + local.getCanonicalHostName());
            System.out.println("**********************************************************");
            //System.out.println("Google host name: " + local.getHostName());
            //System.out.println("Google IP: " + local.getHostAddress());
            //System.out.println("Google nombre canonigo: " + local.getCanonicalHostName());
            
            
            
        } catch (UnknownHostException ex) {
            Logger.getLogger(PruebaIP2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
