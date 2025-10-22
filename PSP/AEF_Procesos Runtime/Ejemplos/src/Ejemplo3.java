
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class Ejemplo3 {

    public static void main(String[] args) {
        
        
        Runtime rt = Runtime.getRuntime();
        Process procesoDate = null;
        BufferedReader lectorProceso = null;
        BufferedWriter escritorProceso = null;
        
        String linea = "";

        try {
            procesoDate = rt.exec("CMD /C DATE");
            
            lectorProceso = new BufferedReader(new InputStreamReader(procesoDate.getInputStream()));
            escritorProceso = new BufferedWriter(new OutputStreamWriter(procesoDate.getOutputStream()));
            
            escritorProceso.write("03-03-15");
            escritorProceso.newLine();
            escritorProceso.flush();
            
            while((linea = lectorProceso.readLine()) != null){
                System.out.println(linea);
            }
            lectorProceso.close();
            escritorProceso.close();
        } catch (IOException io){
            System.out.println("Error io");
        }
    }
}
