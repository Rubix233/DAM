
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        RandomAccessFile fich;
        byte longEntrada = 58;
        StringBuilder nombre, apellidos;

        fich = new RandomAccessFile("Rprueba.dat", "rw");

        fich.writeInt(1);
        nombre = new StringBuilder("Pedro");
        nombre.setLength(10);
        fich.writeChars(nombre.toString());
        apellidos = new StringBuilder("Pascual");
        apellidos.setLength(15);
        fich.writeChars(apellidos.toString());
        fich.writeFloat(800.98F);
      
        
        fich.seek(longEntrada * 3);

        fich.writeInt(10);
        nombre = new StringBuilder("Ana");
        nombre.setLength(10);
        fich.writeChars(nombre.toString());
        apellidos = new StringBuilder("Beeman");
        apellidos.setLength(15);
        fich.writeChars(apellidos.toString());
        fich.writeFloat(999.98F);
        

       fich.seek(0);
        try {
           
            while (true) {
                System.out.print(fich.readInt());
                System.out.print(" - ");
                for (int i = 0; i < 10; i++) {
                    System.out.print(fich.readChar());
                }
                System.out.print(" - ");
                for (int i = 0; i < 15; i++) {
                    System.out.print(fich.readChar());
                }
                System.out.print(" - ");
                System.out.println(fich.readFloat());
                System.out.println("");
            }
        } catch (EOFException eof) {
            System.out.println("Fin fichero");
        }
    }
}
