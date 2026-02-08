
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
public class HiloServer extends Thread {

    private Socket socket;
    private Cola cola;

    public HiloServer(Socket socket, Cola cola) {
        this.socket = socket;
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream());
            
            String tipo = (String) entrada.readObject();
            
            if(tipo.equals("PRODUCTOR")){
                manejarProductor(entrada, salida);
            } else {
                manejarConsumidor(salida);
            }

            salida.close();
            entrada.close();
            this.socket.close();


        } catch (IOException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void manejarProductor (ObjectInputStream entrada, ObjectOutputStream salida) throws IOException, ClassNotFoundException{
        boolean seguir = true;
        do{
            int numero = (int) entrada.readObject();
            
            if(cola.agregarNum(numero)){
                salida.writeObject((String)"OK");
            } else{
                salida.writeObject((String)"LLENO");
                seguir = false;
            }
        }while(seguir);
    }
    
    private void manejarConsumidor(ObjectOutputStream salida) throws InterruptedException, IOException{
        boolean seguir = true;
        do{
            int num = cola.obtenerNumero();
            
            if(num == -1){
                salida.writeObject((String)"VACIO");
                seguir = false;
            } else {
                salida.writeObject((int)num);
            }
            
            
        }while(seguir);
    }
}

