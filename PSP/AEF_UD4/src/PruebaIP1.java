/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Andy
 */
public class PruebaIP1 {
    public static void main(String[] args) {
        String maquina = "";
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Introduzca nombre del equipo");
        
        
        try {
            maquina = teclado.readLine();
            System.out.println(InetAddress.getByName(maquina));
        } catch (UnknownHostException ex) {
            System.out.println("No se ha encontrado la maquina "+ maquina);
            System.out.println("Detalles del error: " + ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(PruebaIP1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                teclado.close();
            } catch (IOException ex) {
                Logger.getLogger(PruebaIP1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
