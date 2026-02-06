/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andy
 */
public class Cliente {

    public static void main(String[] args) {
        int puerto = 50000;
        String host = "localhost";

        try {
            InetAddress miAddress = InetAddress.getLocalHost();
            String myIP = miAddress.getHostAddress();

            Socket socket = new Socket(host, puerto);


            DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
            DataInputStream entrada = new DataInputStream(socket.getInputStream());

            salida.writeUTF("Hola, soy el cliente con IP: " + myIP);
            
            System.out.println(entrada.readUTF());

            salida.close();
            entrada.close();
            socket.close();

        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
