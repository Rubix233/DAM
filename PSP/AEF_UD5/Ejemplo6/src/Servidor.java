
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

            Socket socket = server.accept();
            System.out.println("Conexion establecida con cliente");

            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            //salida.flush();
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            

            String mensaje = (String)entrada.readObject();

            System.out.println("Mensaje recibido: " + mensaje);

            salida.writeObject(new Usuario(null,generarPassword(),null));
            //salida.flush();
            
            System.out.println(((Usuario) entrada.readObject()).toString());

            entrada.close();
            salida.close();
            socket.close();
            server.close();
            System.out.println("Buenas noches");
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String generarPassword() {
        // 1. Definimos el "alfabeto" permitido
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        
        // 2. Usamos StringBuilder para ir pegando letras (es más eficiente que String +=)
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        // 3. Bucle de 10 iteraciones
        for (int i = 0; i < 10; i++) {
            // Genera un índice aleatorio entre 0 y la longitud de la cadena 'caracteres'
            int index = random.nextInt(caracteres.length());
            
            // Añade el carácter correspondiente a ese índice
            password.append(caracteres.charAt(index));
        }

        return password.toString();
    }
}
