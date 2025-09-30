
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 * Hacer una aplicación Java que al escribir java copia fic1.txt fic2.txt
 * realice una copia de fic1 en fic2 carácter a carácter.
 *
 * @author Andy Jan
 */
public class Ud1Act6 {

    public static void main(String[] args) throws IOException {
        final String ruta = "Ficheros/";

        FileReader lector;
        FileWriter escritor;
        File directorio = new File(ruta);
        File archivo = new File(directorio, "fic1.txt");
        File copia = new File(directorio, "fic2.txt");

        try {
            lector = new FileReader(archivo);
            try {
                
                if (archivo.length() > 0) {
                    escritor = new FileWriter(copia);
                    int caracter = lector.read();
                    do {
                        escritor.write(caracter);
                        caracter = lector.read();
                    } while (caracter != -1);
                    lector.close();
                    escritor.close();
                    System.out.println("Archivo copiado");
                } else {
                    System.out.println("Archivo original vacio");
                }

            } catch (IOException io) {
                System.out.println("Error con el duplicado");
            }

        } catch (FileNotFoundException fnf) {
            System.out.println("Archivo original no encontrado");
        }

    }
}
