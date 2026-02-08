
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
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
            while (true) {
                Socket socket = server.accept();
                HiloServer hilo = new HiloServer(socket);
                hilo.start();
            }

        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
