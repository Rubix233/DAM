/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package documentodat;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author andyj
 */
public class Estadistica {
    public static void main(String [] args) throws IOException {
        FileOutputStream fileOutput = null;
        BufferedReader teclado = new BufferedReader( new InputStreamReader(System.in));
        String textoIntroducido;
        byte numeroIntroducido;
        
        byte [] numerosFrec = new byte[10];
        
        do{
            numeroIntroducido = -1;
            System.out.println("Introduzca un numero de 1 - 10 para continuar o 0 para parar."); 
            textoIntroducido = teclado.readLine();
            if(textoIntroducido.trim().matches("(?:10|[0-9])")){
                numeroIntroducido = Byte.parseByte(textoIntroducido);
                if(numeroIntroducido > 0) numerosFrec[numeroIntroducido-1]++;
            } else {
                System.out.println("Input no valido");
            }
            
        }while(numeroIntroducido != 0);
        
        try{
            fileOutput = new FileOutputStream("Ficheros/Frecuencia.dat");
            
            for(byte i = 0; i < 10; i++){
                fileOutput.write(numerosFrec[i]);
            }
            
        } catch (FileNotFoundException fnf){
            System.out.println("No se encontro el archivo");
        } catch (IOException io){
            System.out.println("Algo se jodio con el disco");
        } finally {
            try{
                if(fileOutput != null) fileOutput.close();
            } catch (IOException io){
                System.out.println("Error al cerrar");
            }
        }
    }
}
