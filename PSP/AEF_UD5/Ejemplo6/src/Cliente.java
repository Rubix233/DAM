/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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


            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());

            String p = "Hola, soy el cliente con IP: " + myIP;

            //TENEMOS QUE MANDAR OBJETOS SI USAMOS EL FLUJO DE OBJETOS
            //O ABRIR Y CERRAR LOS FLUJOS DE CADA DATO INDIVIDUAL
            //SI QUEREMOS MANDAR UN INT LO MANDAMOS COMO INTEGER
            salida.writeObject(p);
            
            Usuario usuario = (Usuario) entrada.readObject();
            usuario.setIP(myIP);
            usuario.setNombre("Andy Cliente");
            
            salida.writeObject(usuario);

            salida.close();
            entrada.close();
            socket.close();

        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
