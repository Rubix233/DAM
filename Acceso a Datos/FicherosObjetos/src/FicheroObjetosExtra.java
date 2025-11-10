
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andy Jan
 */
public class FicheroObjetosExtra {
    public static void main(String args[]) {
        File file = null;
        FileOutputStream fileOut = null;
        ObjectOutputStream objOut = null;

        try {
            file = new File("object.dat");
            fileOut = new FileOutputStream(file);
            objOut = new ObjectOutputStream(fileOut);

            Persona p1;

            p1 = new Persona(22, "Viktor", "Cachopo");


            objOut.writeObject(p1);
        } catch (FileNotFoundException fnf) {
            fnf.printStackTrace();
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (objOut != null) {
                try {
                    objOut.close();
                } catch (IOException io) {
                    io.printStackTrace();
                }
            }
        }


    }
}
