/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 *Realizar una aplicación java de nombre Ej1 que pida por teclado un número entre 2 y
50 y genere el fichero muestra.txt con el formato que se muestra, conteniendo tantas
letras por línea como número se haya introducido. En el ejemplo se muestra el
contenido del fichero si se hubiera introducido 50.
• El fichero debe generarse en src\Ficheros.
• El código debe contener nombre completo del autor.
• No puede usarse la clase Leer de primero.
 * 
 * @author Andy Jan
 */
public class EJ1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        File archivo;
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        
        PrintStream escritor;
        int repeticiones = 0;
        
        new File("src/Ficheros").mkdir();
        archivo = new File("src/Ficheros/muestra.txt");
        escritor = new PrintStream(archivo);
        
        while(repeticiones < 2 || repeticiones > 50){
            System.out.println("Introduzca numero 2-50: ");
            try{
                repeticiones = Integer.parseInt(teclado.readLine());
            } catch (NumberFormatException format){
                System.out.println("No es un numero valido.");
            }
        }
        
        for(char i = 'A'; i <= 'Z'; i++){
            String linea = "";
            for(int j = 0; j < repeticiones; j++){
                linea += i;
            }
            escritor.println(linea);
        }
        
        for(char i = 'a'; i <= 'z'; i++){
            String linea = "";
            for(int j = 0; j < repeticiones; j++){
                linea += i;
            }
            escritor.println(linea);
        }
        
        
        
    }
}
