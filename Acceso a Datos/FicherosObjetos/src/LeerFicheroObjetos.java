
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Andy Jan
 */
public class LeerFicheroObjetos {

    public static void main(String args[]) {
        File file = null;
        FileInputStream fileIn = null;
        ObjectInputStream objIn = null;

        try {
            file = new File("object.dat");
            fileIn = new FileInputStream(file);
            objIn = new ObjectInputStream(fileIn);

            Object objeto;

            
            while (true){
                    objeto = objIn.readObject();
                    if(objeto instanceof Persona){
                        System.out.println(((Persona) objeto).getNombre());
                    }   
            }

        }catch(EOFException eof){
            System.out.println("FIN");
        }
        catch (ClassNotFoundException cnf) {
            cnf.printStackTrace();
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (objIn != null) {
                try {
                    objIn.close();
                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        }

    }
}
