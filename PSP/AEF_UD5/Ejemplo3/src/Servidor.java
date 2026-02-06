
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
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
public class Servidor {

    public static void main(String[] args) {
        int puerto = 50000;

        try {
            ServerSocket server = new ServerSocket(puerto);
            System.out.println("Server escuchando en el puerto " + puerto);
            while(true) {
                int i = 1;
                Socket socket = server.accept();
                System.out.println("Conexion establecida con cliente " + i);

                DataInputStream entrada = new DataInputStream(socket.getInputStream());

                String mensaje = entrada.readUTF();

                System.out.println("Mensaje recibido: " + mensaje);

                entrada.close();
                socket.close();
                i++;
            }
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
