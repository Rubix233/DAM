
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *Realizar una aplicación java que genere el fichero muestra.txt con el
siguiente contenido.
* AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA
* -
* zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz
 * @author Andy Jan
 */
public class Ud1Act10 {
    public static void main(String[] args) throws IOException{
        final String ruta = "Ficheros/";
        final String ejemplo = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
        

        BufferedWriter escritor;

        File directorio = new File(ruta);
        File archivo = new File(directorio, "muestra.txt");
        
        escritor = new BufferedWriter(new FileWriter(archivo));
        
        for(char i = 'A';i <= 'Z';i++){
            String linea = "";
            for(int j = 0; j < ejemplo.length(); j++){
                linea += i;
            }
            escritor.write(linea);
            escritor.newLine();
        }
        for(char i = 'a';i <= 'z';i++){
            String linea = "";
            for(int j = 0; j < ejemplo.length(); j++){
                linea += i;
            }
            escritor.write(linea);
            escritor.newLine();
        }
        escritor.close();
        
    }
}
