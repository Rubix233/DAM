
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
            for (int i = 0; i < 5; i++) {
                Socket socket = server.accept();
                System.out.println("Conexion establecida con cliente " + (i+1));

                DataInputStream entrada = new DataInputStream(socket.getInputStream());
                ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());

                String mensaje = entrada.readUTF();

                System.out.println("Mensaje recibido: " + mensaje);
                
                salida.writeObject(new Numero());

                entrada.close();
                salida.close();
                socket.close();
            }
            server.close();
            System.out.println("Buenas noches");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
