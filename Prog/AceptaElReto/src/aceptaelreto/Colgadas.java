
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 *
 * @author Andy Jan
 */
public class Colgadas {
        public static void main(String[] args) throws IOException {
        //Ponemos esto para leer
        //Entorno
        BufferedReader teclado;
        String linea;
        int reps;
        
        //Algoritmo
        teclado = new BufferedReader(new InputStreamReader(System.in));
        
        
        linea = teclado.readLine();
        reps = Integer.parseInt(linea);
        
        for (int i = 0; i<reps;i++){
            linea=teclado.readLine();
            if (linea.trim().toLowerCase().equals("colgadas")){
                System.out.println("Bien");
            } else {
                System.out.println("Mal");
            }
        }
        
    }
}
