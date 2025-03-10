import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Andy Jan
 */
public class HolaMundo {
        public static void main(String[] args) throws IOException {
        //Ponemos esto para leer
        //Entorno
        BufferedReader teclado;
        String linea;
        byte reps;
        
        //Algoritmo
        teclado = new BufferedReader(new InputStreamReader(System.in));
        
        
        linea = teclado.readLine();
        reps = Byte.parseByte(linea);
        
        for (byte i = 0;i<reps;i++){
            System.out.println("Hola mundo.");
        }
        
    }
}
