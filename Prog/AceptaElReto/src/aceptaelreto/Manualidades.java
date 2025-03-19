
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 *
 * @author Andy Jan
 */
public class Manualidades {
    public static void main(String[] args) throws IOException {
        //Ponemos esto para leer
        //Entorno
        BufferedReader teclado;
        String linea;
        byte reps,suf;
        int max,min, firstNum;
                
        //Algoritmo
        teclado = new BufferedReader(new InputStreamReader(System.in));
        
        linea = teclado.readLine();
        reps = Byte.parseByte(linea);
        
        for (int i = 0; i < reps; i++) {
            //Lee altura y anchura
            linea = teclado.readLine();
            //Establece max y min
            max = Integer.parseInt(linea.substring(0, linea.indexOf(" ")));
            min = Integer.parseInt(linea.substring(0, linea.indexOf(" ")));
            if(Integer.parseInt(linea.substring(linea.indexOf(" ")+1)) >= max){
                max = Integer.parseInt(linea.substring(0, linea.indexOf(" ")));
            } else {
                min = Integer.parseInt(linea.substring(0, linea.indexOf(" ")));
            }
            max *= 2;
            min *= 2;
            //Lee colores
            linea = teclado.readLine();
            suf = 0;
            firstNum = Integer.parseInt(linea.substring(0, linea.indexOf(" ")));
            
            if (firstNum > 1){
                linea = linea.substring(linea.indexOf(" ")+1);
                while (suf < 2 && !linea.isEmpty()){
                    firstNum = Integer.parseInt(linea.substring(0, linea.indexOf(" ")));
                    if(firstNum >= max){
                        suf++;
                        max = min;
                    } else {
                        if(firstNum >= min){
                            suf++;
                            min = max;
                        }
                    }
                    if(linea.indexOf(" ") != -1){
                        linea = linea.substring(linea.indexOf(" ")+1);
                    } else {
                        linea = "";
                    }
                    
                }
            }
            
            if(suf >= 2){
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
        
        
    }
}
