/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package documentodat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author andyj
 */
public class VariableAFijoFichData {
    public static void main(String[] args) {
        FileInputStream fileInput = null;
        DataInputStream dataInput = null;
        
        FileOutputStream fileOutput = null;
        DataOutputStream dataOutput = null;


        String nombreLeido;
        byte edadLeida;
        final byte tamNombre = 30;
        boolean finFichero = false; 

        try {
            fileInput = new FileInputStream("Ficheros/FichData.dat");
            dataInput = new DataInputStream(fileInput);
            
            fileOutput = new FileOutputStream("Ficheros/FichDataFijo.dat");
            dataOutput = new DataOutputStream(fileOutput);

            while (!finFichero) {
                try {
                    //Leo el nombre
                    nombreLeido = dataInput.readUTF();
                    
                    //Escribo el nombre caracter a caracter
                    for(byte i = 0; i < tamNombre; i++){
                        if(i < nombreLeido.length()){
                            dataOutput.writeChar(nombreLeido.charAt(i));
                        } else {
                            dataOutput.writeChar(' ');
                        }
                    }
                    
                    //Leer edad
                    edadLeida = dataInput.readByte();
                    
                    //Escribe edad
                    dataOutput.write(edadLeida);
                    
                } catch (EOFException eof) {
                    finFichero = true;
                    System.out.println("Fin del archivo");
                }

            }

        } catch (FileNotFoundException fnf) {
            System.out.println("No existe el archivo");
        } catch (IOException io) {
            System.out.println("Paso algo con el disco");
        } finally {
            try {
                if (dataInput != null) dataInput.close();
                if (fileInput != null) fileInput.close();    
                if (dataOutput != null) dataOutput.close();
                if (fileOutput != null) fileOutput.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo.");
            }
        }
    }
}
